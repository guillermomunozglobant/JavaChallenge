package com.hotel.buenas.noches.Hotel.Controller;

import java.util.List;
import com.hotel.buenas.noches.Hotel.Data.Guest;
import com.hotel.buenas.noches.Hotel.Model.Respuesta;
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

  @GetMapping("/Guests")
  List<Guest> all() {
    return service.GetGuests();
  }

  @GetMapping("/Guests/IsVip")
  Respuesta<String> IsVip(@PathVariable Long id) {
    return service.GenerateRespuesta(
      service.isVip(id)
        ?"Es VIP":"No es VIP");
  }

  @PostMapping("/Guests")
  Guest newGuest(@RequestBody Guest newGuest) {
    return service.addGuest(newGuest);
  }

  @GetMapping("/Guests/{id}")
  Guest one(@PathVariable Long id) {
    
    return service.GetGuest(id);
  }

  @PutMapping("/Guests/{id}")
  Guest replaceGuest(@RequestBody Guest newGuest, @PathVariable Long id) {
    
    return service.replaceGuest(newGuest, id);
  }

  @DeleteMapping("/Guests/{id}")
  void deleteGuest(@PathVariable Long id) {
    service.DeleteGuest(id);
  }
}