package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.models.privileges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegesRepository extends JpaRepository<privileges, Integer> {
}
