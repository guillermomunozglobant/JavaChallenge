package com.hotel.buenas.noches.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.buenas.noches.Hotel.Data.RoomType;

interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}