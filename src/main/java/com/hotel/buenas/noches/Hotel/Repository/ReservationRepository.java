package com.hotel.buenas.noches.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.buenas.noches.Hotel.Data.Reservation;
import com.hotel.buenas.noches.Hotel.Data.Guest;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByGuest(Guest guest);
}