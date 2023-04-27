package com.thoughtclan.bikerentalsystem.services.implementation;


import com.thoughtclan.bikerentalsystem.dtos.inputDtos.RoleInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.RoleOutputDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Role;
import com.thoughtclan.bikerentalsystem.repositories.RoleRepository;
import com.thoughtclan.bikerentalsystem.services.RoleService;
import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final ModelMapper modelMapper;

    private final PatchMapper patchMapper;

    private final RoleRepository roleRepository;


    public RoleOutputDto saveRole(RoleInputDto role){
        Role role1 = modelMapper.map(role,Role.class);
        role1 = roleRepository.save(role1);
        return modelMapper.map(role1,RoleOutputDto.class);
    }

    public RoleOutputDto getRole(Long id){
        Role role1 = roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role with given id "+id+" is not found"));
        return modelMapper.map(role1,RoleOutputDto.class);
    }

    @Override
    public List<RoleOutputDto> getAllRoles() {
        List<Role> roles =roleRepository.findAll();
        return roles.stream().map(role->modelMapper.map(role,RoleOutputDto.class)).collect(Collectors.toList());

    }

    public ResponseEntity<RoleOutputDto> deleteRole(Long id){
        Role role = roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role with given id "+id+" is not found"));
        roleRepository.delete(role);
        return ResponseEntity.ok(modelMapper.map(role,RoleOutputDto.class));
    }

    public RoleOutputDto updateRole(Long id,RoleInputDto role){
        Role role1 =  modelMapper.map(role,Role.class);
        Role role2 =  roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role with given id "+id+" is not found"));
        modelMapper.map(role1,role2);
        role2 = roleRepository.save(role2);
        return modelMapper.map(role2,RoleOutputDto.class);
    }
    public RoleOutputDto patchUpdate(Long id,RoleInputDto role){
        Role role1 = modelMapper.map(role,Role.class);
        Role existingRole = roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role with given id "+id+" is not found"));
        patchMapper.map(role1,existingRole);
        existingRole = roleRepository.save(existingRole);
        return modelMapper.map(existingRole, RoleOutputDto.class);
    }

}
