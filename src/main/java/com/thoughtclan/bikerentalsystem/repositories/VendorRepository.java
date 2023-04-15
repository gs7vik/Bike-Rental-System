package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> {

}
