package com.hotel.buenas.noches.Hotel.Controller;

import java.util.List;
import com.hotel.buenas.noches.Hotel.Data.Room;
import com.hotel.buenas.noches.Hotel.Services.IService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
class GuestController {
  @Autowired
  private final IService service;

  GuestController(IService service) {
    this.service = service;
  }

  @GetMapping("/Rooms")
  List<Room> all() {
    return service.GetRooms();
  }

  @PostMapping("/Rooms")
  Room newRoom(@RequestBody Room newRoom) {
    return service.addRoom(newRoom);
  }

  @GetMapping("/Rooms/{id}")
  Room one(@PathVariable Long id) {
    
    return service.GetRoom(id);
  }

  @PutMapping("/Rooms/{id}")
  Room replaceRoom(@RequestBody Room newRoom, @PathVariable Long id) {
    
    return service.replaceRoom(newRoom, id);
  }

  @DeleteMapping("/Rooms/{id}")
  void deleteRoom(@PathVariable Long id) {
    service.DeleteRoom(id);
  }
}