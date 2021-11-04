package com.hotel.buenas.noches.Hotel.Controller;

import java.util.List;
import com.hotel.buenas.noches.Hotel.Repository.HotelRepository;
import com.hotel.buenas.noches.Hotel.Data.Hotel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HotelController {

  private final HotelRepository repository;

  HotelController(HotelRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/Hotels")
  List<Hotel> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/Hotels")
  Hotel newHotel(@RequestBody Hotel newHotel) {
    return repository.save(newHotel);
  }

  // Single item
  
  @GetMapping("/Hotels/{id}")
  Hotel one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("No se encontro cliente"));
  }

  @PutMapping("/Hotels/{id}")
  Hotel replaceHotel(@RequestBody Hotel newHotel, @PathVariable Long id) {
    
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

  @DeleteMapping("/Hotels/{id}")
  void deleteHotel(@PathVariable Long id) {
    repository.deleteById(id);
  }
}