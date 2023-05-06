package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thoughtclan.bikerentalsystem.models.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    public List<Booking> findByIdAndBookingStatus(Long Id,BookingStatus bookingStatus);

    public List<Booking> findByBikeId(Long id);

    public List<Booking> findByUserId(Long id);



}
