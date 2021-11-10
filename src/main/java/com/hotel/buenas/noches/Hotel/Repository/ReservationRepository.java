package com.hotel.buenas.noches.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hotel.buenas.noches.Hotel.Data.Reservation;
import com.hotel.buenas.noches.Hotel.Data.Guest;
import java.util.List;
import java.util.stream.Stream;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByGuest(Guest guest);
    
    @Query(value = "select r.* from resevation r inner join guest g on g.id = r.id"+ 
        " where g.first_name = ?1 or g.last_name = ?2 or g.email = ?3", nativeQuery = true)
    Stream<Reservation> findByNameOrLastNameOrEmail(String name,String lastName, String email);
}