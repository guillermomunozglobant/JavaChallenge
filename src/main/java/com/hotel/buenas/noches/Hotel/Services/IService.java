package com.hotel.buenas.noches.Hotel.Services;


import java.util.List;
import com.hotel.buenas.noches.Hotel.Data.*;
import com.hotel.buenas.noches.Hotel.Model.*;


public interface IService {
    List<Hotel> GetHotels();
    Hotel addHotel(Hotel newHotel);
    Hotel GetHotel(Long id);
    void DeleteHotel(Long id);
    Hotel replaceHotel(Hotel newRoom,Long id);
    List<Room> getRoomByHotel(Long id);

    List<Room> GetRooms();
    Room addRoom(Room room);
    Room GetRoom(Long id);
    void DeleteRoom(Long id);
    Room replaceRoom(Room newRoom,Long id);

    

    List<RoomType> GetRoomTypes();
    RoomType addRoomType(RoomType room);
    RoomType GetRoomType(Long id);
    void DeleteRoomType(Long id);
    RoomType replaceRoomType(RoomType newRoomType,Long id);

    
    List<Guest> GetGuests();
    Guest addGuest(Guest room);
    Guest GetGuest(Long id);
    void DeleteGuest(Long id);
    Guest replaceGuest(Guest newGuest,Long id);
    Boolean isVip(Long id);

    
    List<GuestType> GetGuestTypes();
    GuestType addGuestType(GuestType room);
    GuestType GetGuestType(Long id);
    void DeleteGuestType(Long id);
    GuestType replaceGuestType(GuestType newGuestType,Long id);

    
    List<Reservation> GetReservations();
    Reservation addReservation(Reservation room);
    Reservation GetReservation(Long id);
    void DeleteReservation(Long id);
    Reservation replaceReservation(Reservation newReservation,Long id);
    String CheckIn (Long id);

    <T> Respuesta<T> GenerateRespuesta(T objeto);
}
