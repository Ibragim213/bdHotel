package com.example.bdhotel.repository;

import com.example.bdhotel.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    Optional<Passenger> findByfullName(String fullName);
    Boolean existsByFullName(String fullName);
    Boolean existsByMail(String mail);
}
