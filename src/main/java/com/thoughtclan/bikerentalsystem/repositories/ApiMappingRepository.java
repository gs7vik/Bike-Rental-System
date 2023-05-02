package com.thoughtclan.bikerentalsystem.repositories;


import com.thoughtclan.bikerentalsystem.models.ApiMapping;
import com.thoughtclan.bikerentalsystem.utils.HttpMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiMappingRepository extends JpaRepository<ApiMapping,Long> {
    Optional<ApiMapping> findByHttpMethodAndUrl(HttpMethod httpMethod, String url);
}
