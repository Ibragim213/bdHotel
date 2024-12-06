package com.example.bdhotel.repository;

import com.example.bdhotel.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findBySurname(String surname);
    Boolean existsBySurname(String Surname);
    Boolean existsByEmail(String email);
}
