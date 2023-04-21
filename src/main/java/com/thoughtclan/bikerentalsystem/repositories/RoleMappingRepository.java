package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.models.RoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMappingRepository extends JpaRepository<RoleMapping,Long> {
    List<RoleMapping> findByApiMappingId(Long id);
}
