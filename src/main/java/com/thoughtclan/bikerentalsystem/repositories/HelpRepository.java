package com.thoughtclan.bikerentalsystem.repositories;

import com.thoughtclan.bikerentalsystem.models.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends JpaRepository<Help,Long> {

}
