package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
