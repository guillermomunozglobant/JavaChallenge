package com.hotel.buenas.noches.Hotel.Services;

import com.hotel.buenas.noches.Hotel.Repository.HotelRepository;
import com.hotel.buenas.noches.Hotel.Repository.RoomRepository;
import com.hotel.buenas.noches.Hotel.Repository.RoomTypeRepository;
import com.hotel.buenas.noches.Hotel.Repository.BitacoraReservacionesRepository;
import com.hotel.buenas.noches.Hotel.Repository.GuestRepository;
import com.hotel.buenas.noches.Hotel.Repository.GuestTypeRepository;
import com.hotel.buenas.noches.Hotel.Repository.ReservationRepository;
import com.hotel.buenas.noches.Hotel.Data.Hotel;
import com.hotel.buenas.noches.Hotel.Data.Room;
import com.hotel.buenas.noches.Hotel.Data.Reservation;
import com.hotel.buenas.noches.Hotel.Data.BitacoraReservaciones;
import com.hotel.buenas.noches.Hotel.Data.Guest;
import com.hotel.buenas.noches.Hotel.Data.GuestType;
import com.hotel.buenas.noches.Hotel.Data.RoomType;
import com.hotel.buenas.noches.Hotel.Model.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;    

@Repository
public class Service implements IService {
    
    private final HotelRepository repository;
    private final RoomRepository roomRepository;
    private final BitacoraReservacionesRepository BitacoraReservacionesRepository;
    private final GuestRepository GuestRepository;
    private final GuestTypeRepository GuestTypeRepository;
    private final ReservationRepository ReservationRepository;
    private final RoomTypeRepository roomTypeRepository;
  
    Service(HotelRepository repository,
            RoomRepository roomRepository,
            BitacoraReservacionesRepository BitacoraReservacionesRepository,
            GuestRepository GuestRepository,
            GuestTypeRepository GuestTypeRepository,
            ReservationRepository ReservationRepository,
            RoomTypeRepository roomTypeRepository) {
        this.repository = repository;
        this.roomRepository = roomRepository;
        this.BitacoraReservacionesRepository = BitacoraReservacionesRepository;
        this.GuestRepository = GuestRepository;
        this.GuestTypeRepository = GuestTypeRepository;
        this.ReservationRepository = ReservationRepository;
        this.roomTypeRepository = roomTypeRepository;
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
  
  public List<RoomType> GetRoomTypes() {
    return roomTypeRepository.findAll();
  }
  
  public RoomType addRoomType(RoomType newRoomType) {
    return roomTypeRepository.save(newRoomType);
  }

  public RoomType GetRoomType(Long id) {
    
    return roomTypeRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("No se encontro cliente"));
  }

  public RoomType replaceRoomType(RoomType newRoomType,Long id) {
    
    return roomTypeRepository.findById(id)
      .map(RoomType -> {
        RoomType.setName(newRoomType.getName());
        return roomTypeRepository.save(RoomType);
      })
      .orElseGet(() -> {
        newRoomType.setId(id);
        return roomTypeRepository.save(newRoomType);
      });
  }

  public void DeleteRoomType( Long id) {
    roomTypeRepository.deleteById(id);
  }
  
  public List<Guest> GetGuests() {
    return GuestRepository.findAll();
  }
  
  public Guest addGuest(Guest newGuest) {
    return GuestRepository.save(newGuest);
  }

  public Guest GetGuest(Long id) {
    
    return GuestRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("No se encontro cliente"));
  }

  public Guest replaceGuest(Guest newGuest,Long id) {
    
    return GuestRepository.findById(id)
      .map(Guest -> {
        Guest.setFirst_name(newGuest.getFirst_name());
        return GuestRepository.save(Guest);
      })
      .orElseGet(() -> {
        newGuest.setId(id);
        return GuestRepository.save(newGuest);
      });
  }

  public void DeleteGuest( Long id) {
    GuestRepository.deleteById(id);
  }

  public Boolean isVip(Long id){
    Guest g = GetGuest(id);

    return ReservationRepository.findByGuest(g).size() > 4;
  }

  
  public List<GuestType> GetGuestTypes() {
    return GuestTypeRepository.findAll();
  }
  
  public GuestType addGuestType(GuestType newGuestType) {
    return GuestTypeRepository.save(newGuestType);
  }

  public GuestType GetGuestType(Long id) {
    
    return GuestTypeRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("No se encontro cliente"));
  }

  public GuestType replaceGuestType(GuestType newGuestType,Long id) {
    
    return GuestTypeRepository.findById(id)
      .map(GuestType -> {
        GuestType.setName(newGuestType.getName());
        return GuestTypeRepository.save(GuestType);
      })
      .orElseGet(() -> {
        newGuestType.setId(id);
        return GuestTypeRepository.save(newGuestType);
      });
  }

  public void DeleteGuestType( Long id) {
    GuestTypeRepository.deleteById(id);
  }

  
  public List<Reservation> GetReservations() {
    return ReservationRepository.findAll();
  }
  
  public Reservation addReservation(Reservation newReservation) {

    Guest g = GuestRepository.findById(newReservation.getGuest().getId()).orElse(null);
    
    if(g == null){
      addGuest(newReservation.getGuest());
    }

    return ReservationRepository.save(newReservation);
  }

  public Reservation GetReservation(Long id) {
    
    return ReservationRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("No se encontro cliente"));
  }

  public Reservation replaceReservation(Reservation newReservation,Long id) {
    
    return ReservationRepository.findById(id)
      .map(Reservation -> {
        Reservation.setId(newReservation.getId());
        return ReservationRepository.save(Reservation);
      })
      .orElseGet(() -> {
        newReservation.setId(id);
        return ReservationRepository.save(newReservation);
      });
  }

  public void DeleteReservation( Long id) {
    ReservationRepository.deleteById(id);
  }

  public void CancelarReservation( CancelaReserva reserva) {
    Optional<Guest> g = GuestRepository.findByFirstNameOrLastNameOrEmail
        (reserva.getName(), reserva.getLastName(), reserva.getEmail()).findAny();
    List<Reservation> listR = ReservationRepository.findByGuest(g.get());
    if(listR.size()>0){
      listR.stream().filter(r -> r.isCheck_in()== false && 
      new Date(System.currentTimeMillis()).compareTo(r.getStart_date())>1);
    }
  }

  public <T> Respuesta<T> GenerateRespuesta(T objeto){
    return new Respuesta<T>(objeto);
  }

  public List<Room> getRoomByHotel(Long id){
    Hotel h = GetHotel(id);

    return roomRepository.getRoomByHotel(h.getId());
  }

  public String CheckIn (Long id){
    Reservation r = ReservationRepository.findById(id).orElse(null);
    if(r == null){
      return "No se encontro reservacion";
    }
    r.setCheck_in(true);
    ReservationRepository.save(r);

    BitacoraReservaciones bitacora = new BitacoraReservaciones();
    bitacora.setStart_date(r.getStart_date());
    bitacora.setEnd_date(r.getEnd_date());
    bitacora.setHotel_name(r.getRoom().getHotel().getName());
    bitacora.setGuest_first_name(r.getGuest().getFirst_name());
    bitacora.setGuest_last_name(r.getGuest().getLast_name());
    bitacora.setRoom_name(r.getRoom().getName());
    BitacoraReservacionesRepository.save(bitacora);

    return "Se hizo el check in";
  }
}
