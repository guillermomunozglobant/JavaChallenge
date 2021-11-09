package com.hotel.buenas.noches.Hotel.Controller;

import java.util.List;
import com.hotel.buenas.noches.Hotel.Data.Reservation;
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
class ReservationController {
  @Autowired
  private final IService service;

  ReservationController(IService service) {
    this.service = service;
  }

  @GetMapping("/Reservations")
  List<Reservation> all() {
    return service.GetReservations();
  }

  @PostMapping("/Reservations")
  Reservation newReservation(@RequestBody Reservation newReservation) {
    return service.addReservation(newReservation);
  }

  @PostMapping("/Reservations/CheckIn")
  String CheckIn(@RequestBody Long newReservation) {
    return service.CheckIn(newReservation);
  }

  @GetMapping("/Reservations/{id}")
  Reservation one(@PathVariable Long id) {
    
    return service.GetReservation(id);
  }

  @PutMapping("/Reservations/{id}")
  Reservation replaceReservation(@RequestBody Reservation newReservation, @PathVariable Long id) {
    
    return service.replaceReservation(newReservation, id);
  }

  @DeleteMapping("/Reservations/{id}")
  void deleteReservation(@PathVariable Long id) {
    service.DeleteReservation(id);
  }
}