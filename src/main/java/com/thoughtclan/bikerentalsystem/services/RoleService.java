package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.RoleInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.RoleOutputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {
    public RoleOutputDto saveRole(RoleInputDto role);
    public RoleOutputDto getRole(Long id);

    public List<RoleOutputDto> getAllRoles();

    public ResponseEntity<RoleOutputDto> deleteRole(Long id);

    public RoleOutputDto updateRole(Long id,RoleInputDto role);
    public RoleOutputDto patchUpdate(Long id,RoleInputDto role);

}