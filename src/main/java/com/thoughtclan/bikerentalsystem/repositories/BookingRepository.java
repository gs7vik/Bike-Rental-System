package com.thoughtclan.bikerentalsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thoughtclan.bikerentalsystem.models.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {


}
