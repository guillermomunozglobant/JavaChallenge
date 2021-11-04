package com.hotel.buenas.noches.Hotel.Services;


import java.util.List;
import com.hotel.buenas.noches.Hotel.Data.Hotel;
import com.hotel.buenas.noches.Hotel.Data.Room;

public interface IService {
    List<Hotel> GetHotels();
    Hotel addHotel(Hotel newHotel);
    Hotel GetHotel(Long id);
    void DeleteHotel(Long id);
    Hotel replaceHotel(Hotel newRoom,Long id);


    List<Room> GetRooms();
    Room addRoom(Room room);
    Room GetRoom(Long id);
    void DeleteRoom(Long id);
    Room replaceRoom(Room newRoom,Long id);
}
