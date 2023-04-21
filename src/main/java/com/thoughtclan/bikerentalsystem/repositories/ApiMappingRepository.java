package com.thoughtclan.bikerentalsystem.repositories;


import com.thoughtclan.bikerentalsystem.models.ApiMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiMappingRepository extends JpaRepository<ApiMapping,Long> {
    Optional<ApiMapping> findByHttpMethodAndUrl(HttpMethod httpMethod, String url);
}
