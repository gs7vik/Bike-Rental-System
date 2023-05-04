package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.enums.BikeStatus;
import com.thoughtclan.bikerentalsystem.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Long> {

    List<Bike> findByUserIdId(Long id);

    List<Bike> findByBikeStatus(BikeStatus bikeStatus);
}
