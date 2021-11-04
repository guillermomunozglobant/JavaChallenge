package com.hotel.buenas.noches.Hotel.Controller;

import java.util.List;
import com.hotel.buenas.noches.Hotel.Repository.RoomRepository;
import com.hotel.buenas.noches.Hotel.Data.Room;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RoomController {

  private final RoomRepository repository;

  RoomController(RoomRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/Rooms")
  List<Room> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/Rooms")
  Room newRoom(@RequestBody Room newRoom) {
    return repository.save(newRoom);
  }

  // Single item
  
  @GetMapping("/Rooms/{id}")
  Room one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("No se encontro cliente"));
  }

  @PutMapping("/Rooms/{id}")
  Room replaceRoom(@RequestBody Room newRoom, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(Room -> {
        Room.setName(newRoom.getName());
        return repository.save(Room);
      })
      .orElseGet(() -> {
        newRoom.setId(id);
        return repository.save(newRoom);
      });
  }

  @DeleteMapping("/Rooms/{id}")
  void deleteRoom(@PathVariable Long id) {
    repository.deleteById(id);
  }
}