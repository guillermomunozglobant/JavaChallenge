package com.hotel.buenas.noches.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.buenas.noches.Hotel.Data.GuestType;

public interface GuestTypeRepository extends JpaRepository<GuestType, Long> {

}