package com.hotel.buenas.noches.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.buenas.noches.Hotel.Data.Room;
import com.hotel.buenas.noches.Hotel.Data.Hotel;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> getRoomByHotel(Long hotel_id);
}