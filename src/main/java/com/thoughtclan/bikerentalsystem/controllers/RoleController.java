package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.RoleInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.RoleOutputDto;
import com.thoughtclan.bikerentalsystem.services.implementation.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleServiceImpl roleService;

    @PostMapping
    public RoleOutputDto createRole(@RequestBody RoleInputDto input){
        return roleService.saveRole(input);
    }

    @GetMapping("/{id}")
    public RoleOutputDto getRoleById(@PathVariable Long id){
        System.out.println("hru");
        return roleService.getRole(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleOutputDto> deleteRole(@PathVariable Long id){
        return roleService.deleteRole(id);
    }

    @PutMapping("/{id}")
    public RoleOutputDto updateRole(@PathVariable Long id,@RequestBody RoleInputDto input){
        return roleService.updateRole(id,input);
    }

    @PatchMapping("/{id}")
    public RoleOutputDto partialUpdateRole(@PathVariable Long id,@RequestBody RoleInputDto input){
        return roleService.patchUpdate(id,input);
    }

    @GetMapping
    public List<RoleOutputDto> getAllRoles(){
        return roleService.getAllRoles();
    }
}
