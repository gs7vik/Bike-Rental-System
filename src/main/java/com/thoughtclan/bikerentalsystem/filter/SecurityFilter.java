package com.thoughtclan.bikerentalsystem.filter;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
//        if (request.getHeader(HttpHeaders.AUTHORIZATION) == null) {
        if(true){
            filterChain.doFilter(request, response);
        }
        else {
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            HttpMethod method = HttpMethod.valueOf(request.getMethod());
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
                            List<Long> roles = roleMappingService.getRoles(apiMappingOutputDto.getId());
                            if(roles.contains(user.getRole().getId())) {
                                filterChain.doFilter(request, response);
                            }
                            else{
                                throw new ResourceNotFoundException("You Can't Access this api");
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
        final List<String> publicApis = List.of("/user/login","/apiMapping/{id}");
        return publicApis.contains(url);
    }
}