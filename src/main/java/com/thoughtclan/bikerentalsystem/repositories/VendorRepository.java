package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.models.Bike;
import com.thoughtclan.bikerentalsystem.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> {
    List<Vendor> findByEmail(String email);
    List<Vendor> findByContactNo(String ContactNo);
}
