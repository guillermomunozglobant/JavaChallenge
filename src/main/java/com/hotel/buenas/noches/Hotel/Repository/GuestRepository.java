package com.hotel.buenas.noches.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.buenas.noches.Hotel.Data.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}