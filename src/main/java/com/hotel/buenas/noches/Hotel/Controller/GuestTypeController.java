package com.hotel.buenas.noches.Hotel.Controller;

import java.util.List;
import com.hotel.buenas.noches.Hotel.Data.GuestType;
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
class GuestTypeController {
  @Autowired
  private final IService service;

  GuestTypeController(IService service) {
    this.service = service;
  }

  @GetMapping("/GuestTypes")
  List<GuestType> all() {
    return service.GetGuestTypes();
  }

  @PostMapping("/GuestTypes")
  GuestType newGuestType(@RequestBody GuestType newGuestType) {
    return service.addGuestType(newGuestType);
  }

  @GetMapping("/GuestTypes/{id}")
  GuestType one(@PathVariable Long id) {
    
    return service.GetGuestType(id);
  }

  @PutMapping("/GuestTypes/{id}")
  GuestType replaceGuestType(@RequestBody GuestType newGuestType, @PathVariable Long id) {
    
    return service.replaceGuestType(newGuestType, id);
  }

  @DeleteMapping("/GuestTypes/{id}")
  void deleteGuestType(@PathVariable Long id) {
    service.DeleteGuestType(id);
  }
}