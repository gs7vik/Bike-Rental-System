package com.thoughtclan.bikerentalsystem.filter;


import com.google.common.net.HttpHeaders;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.ApiMappingOutputDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.services.RoleMappingService;
import com.thoughtclan.bikerentalsystem.services.UserService;
import com.thoughtclan.bikerentalsystem.services.implementation.ApiMappingServiceImpl;
import com.thoughtclan.bikerentalsystem.utils.CurrentUser;
import com.thoughtclan.bikerentalsystem.utils.HttpMethod;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class SecurityFilter extends OncePerRequestFilter {

    private final UserService userService;

    private final ApiMappingServiceImpl apiMappingService;

    private final RoleMappingService roleMappingService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      if (false)
        {
            filterChain. doFilter(request, response);
        }
        else {
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            com.thoughtclan.bikerentalsystem.utils.HttpMethod method = HttpMethod.valueOf(request.getMethod());
            String uri = request.getRequestURI();
            uri = uri.replaceAll("[0-9]+","{id}");


            if (method.equals(HttpMethod.OPTIONS)) {
                filterChain.doFilter(request, response);
            } else if (isPublicApi(uri)) {//we need to check public api or not
                filterChain.doFilter(request, response);
            } else {
                if (StringUtils.isNotBlank(token) && (token.startsWith("Bearer "))) {
                    String actualToken = token.split(" ")[1].trim();
                    if (StringUtils.isNotBlank(actualToken)) {
                        try {
                            FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(actualToken);
                            String fireBaseId = firebaseToken.getUid();
                            User user = userService.getByFireBaseId(fireBaseId);
                            CurrentUser.set(user);
                            ApiMappingOutputDto apiMappingOutputDto = apiMappingService.getAllPermissions(method,uri);
                            System.out.println(apiMappingOutputDto);
                            List<Long> roles = roleMappingService.getRoles(apiMappingOutputDto.getId());
                            if(roles.contains(user.getRole().getId())) {
                                filterChain.doFilter(request, response);
                            }
                            else{
                                throw new EntityNotFoundException("You Can't Access this api");
                            }
                        }
                        catch (Exception e) {
                            throw new RuntimeException(e.getMessage());
                        }
                    }
                } else {
                    logger.error("No token sent or blank token sent");
                    throw new RuntimeException("No token sent or blank token sent");
                }
            }
        }
    }
    private boolean isPublicApi(String url){
        final List<String> publicApis = List.of("/user/login","/apiMapping","/roleMapping","/bike","/user");
        return publicApis.contains(url);
    }
}