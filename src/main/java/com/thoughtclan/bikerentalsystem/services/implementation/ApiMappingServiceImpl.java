
package com.thoughtclan.bikerentalsystem.services.implementation;


import com.thoughtclan.bikerentalsystem.dtos.inputDtos.ApiMappingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.ApiMappingOutputDto;
import com.thoughtclan.bikerentalsystem.models.ApiMapping;
import com.thoughtclan.bikerentalsystem.repositories.ApiMappingRepository;
import com.thoughtclan.bikerentalsystem.repositories.RoleRepository;
import com.thoughtclan.bikerentalsystem.services.ApiMappingService;
import com.thoughtclan.bikerentalsystem.services.RoleService;
import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiMappingServiceImpl implements ApiMappingService {

    private final ModelMapper modelMapper;

    private final PatchMapper patchMapper;

    private final ApiMappingRepository apiMappingRepository;

    private final RoleService roleService;

    private final RoleRepository roleRepository;

    @Override
    public ApiMappingOutputDto createApiMapping(ApiMappingInputDto input) {
        ApiMapping apiMapping = modelMapper.map(input, ApiMapping.class);
        apiMapping = apiMappingRepository.save(apiMapping);
        return modelMapper.map(apiMapping, ApiMappingOutputDto.class);
    }

    public ApiMappingOutputDto getApiMapping(Long id){
        ApiMapping apiMapping = apiMappingRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return modelMapper.map(apiMapping, ApiMappingOutputDto.class);
    }

    public ApiMappingOutputDto partialUpdate(Long id, ApiMappingInputDto input) {
        ApiMapping apiMapping = modelMapper.map(input, ApiMapping.class);
        ApiMapping apiMapping1  = apiMappingRepository.findById(id).orElseThrow(() -> new RuntimeException());
        patchMapper.map(apiMapping,apiMapping1);
        apiMapping1 = apiMappingRepository.save(apiMapping1);
        return modelMapper.map(apiMapping1, ApiMappingOutputDto.class);

    }

    public ApiMappingOutputDto getAllPermissions(HttpMethod httpMethod,String url){
        ApiMapping apiMapping = apiMappingRepository.findByHttpMethodAndUrl(httpMethod, url).orElseThrow(()->new RuntimeException());
        System.out.println(apiMapping);
        return modelMapper.map(apiMapping,ApiMappingOutputDto.class);
    }

    public String deleteApi(Long id){
        apiMappingRepository.deleteById(id);
        return "done";
    }
}
