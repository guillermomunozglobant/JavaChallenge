package com.hotel.buenas.noches.Hotel.Services;

import com.hotel.buenas.noches.Hotel.Repository.HotelRepository;
import com.hotel.buenas.noches.Hotel.Repository.RoomRepository;
import com.hotel.buenas.noches.Hotel.Data.Hotel;
import com.hotel.buenas.noches.Hotel.Data.Room;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class Service implements IService {
    
    private final HotelRepository repository;
    private final RoomRepository roomRepository;
  
    Service(HotelRepository repository,RoomRepository roomRepository) {
        this.repository = repository;
        this.roomRepository = roomRepository;
    }

  public List<Hotel> GetHotels() {
    return repository.findAll();
  }
  
  public Hotel addHotel(Hotel newHotel) {
    return repository.save(newHotel);
  }

  public Hotel GetHotel(Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("No se encontro cliente"));
  }

  public Hotel replaceHotel(Hotel newHotel,Long id) {
    
    return repository.findById(id)
      .map(Hotel -> {
        Hotel.setName(newHotel.getName());
        return repository.save(Hotel);
      })
      .orElseGet(() -> {
        newHotel.setId(id);
        return repository.save(newHotel);
      });
  }

  public void DeleteHotel( Long id) {
    repository.deleteById(id);
  }

  public List<Room> GetRooms() {
    return roomRepository.findAll();
  }
  
  public Room addRoom(Room newRoom) {
    return roomRepository.save(newRoom);
  }

  public Room GetRoom(Long id) {
    
    return roomRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("No se encontro cliente"));
  }

  public Room replaceRoom(Room newRoom,Long id) {
    
    return roomRepository.findById(id)
      .map(Room -> {
        Room.setName(newRoom.getName());
        return roomRepository.save(Room);
      })
      .orElseGet(() -> {
        newRoom.setId(id);
        return roomRepository.save(newRoom);
      });
  }

  public void DeleteRoom( Long id) {
    roomRepository.deleteById(id);
  }
}
