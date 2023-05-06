package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByFireBaseId(String uid);

    User findByEmail(String email);
}
