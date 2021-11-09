package com.hotel.buenas.noches.Hotel.Controller;

import java.util.List;
import com.hotel.buenas.noches.Hotel.Services.IService;
import com.hotel.buenas.noches.Hotel.Data.Hotel;
import com.hotel.buenas.noches.Hotel.Data.Room;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
class HotelController {

  @Autowired
  private final IService service;

  HotelController(IService service) {
    this.service = service;
  }

  @GetMapping("/Hotels")
  List<Hotel> all() {
    return service.GetHotels();
  }

  @PostMapping("/Hotels")
  Hotel newHotel(@RequestBody Hotel newHotel) {
    return service.addHotel(newHotel);
  }

  @GetMapping("/Hotels/{id}")
  Hotel one(@PathVariable Long id) {
    
    return service.GetHotel(id);
  }

  @PutMapping("/Hotels/{id}")
  Hotel replaceHotel(@RequestBody Hotel newHotel, @PathVariable Long id) {
    
    return service.replaceHotel(newHotel, id);
  }

  @DeleteMapping("/Hotels/{id}")
  void deleteHotel(@PathVariable Long id) {
    service.DeleteHotel(id);
  }

  @GetMapping("/Hotels/{id}/Rooms")
  List<Room> getRoomsByHotel(@PathVariable Long id) {
    
    return service.getRoomByHotel(id);
  }
}