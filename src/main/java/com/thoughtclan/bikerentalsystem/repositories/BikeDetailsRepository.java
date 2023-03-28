package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.models.BikeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeDetailsRepository extends JpaRepository<BikeDetails,Integer> {

}
