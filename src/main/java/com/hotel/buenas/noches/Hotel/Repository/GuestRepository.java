package com.hotel.buenas.noches.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

import com.hotel.buenas.noches.Hotel.Data.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    @Query(value ="select * from Guest g where g.first_name = ?1 or g.last_name = ?2 or g.email = ?3", nativeQuery = true)
    Stream<Guest> findByFirstNameOrLastNameOrEmail(String first_name, String last_name, String email);
}