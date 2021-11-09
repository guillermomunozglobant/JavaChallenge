package com.hotel.buenas.noches.Hotel.Controller;

import java.util.List;
import com.hotel.buenas.noches.Hotel.Data.RoomType;
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
class RoomTypeTypeController {
  @Autowired
  private final IService service;

  RoomTypeTypeController(IService service) {
    this.service = service;
  }

  @GetMapping("/RoomTypes")
  List<RoomType> all() {
    return service.GetRoomTypes();
  }

  @PostMapping("/RoomTypes")
  RoomType newRoomType(@RequestBody RoomType newRoomType) {
    return service.addRoomType(newRoomType);
  }

  @GetMapping("/RoomTypes/{id}")
  RoomType one(@PathVariable Long id) {
    
    return service.GetRoomType(id);
  }

  @PutMapping("/RoomTypes/{id}")
  RoomType replaceRoomType(@RequestBody RoomType newRoomType, @PathVariable Long id) {
    
    return service.replaceRoomType(newRoomType, id);
  }

  @DeleteMapping("/RoomTypes/{id}")
  void deleteRoomType(@PathVariable Long id) {
    service.DeleteRoomType(id);
  }
}