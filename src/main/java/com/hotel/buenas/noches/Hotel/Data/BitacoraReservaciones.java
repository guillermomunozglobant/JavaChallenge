package com.hotel.buenas.noches.Hotel.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BitacoraReservaciones {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String hotel_name;
  private String room_name;
  private String guest_first_name;
  private String guest_last_name;
  private String guest_email;
  private Date start_date;
  private Date end_date;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getHotel_name() {
    return this.hotel_name;
  }

  public void setHotel_name(String hotel_name) {
    this.hotel_name = hotel_name;
  }

  public String getRoom_name() {
    return this.room_name;
  }

  public void setRoom_name(String room_name) {
    this.room_name = room_name;
  }

  public String getGuest_first_name() {
    return this.guest_first_name;
  }

  public void setGuest_first_name(String guest_first_name) {
    this.guest_first_name = guest_first_name;
  }

  public String getGuest_last_name() {
    return this.guest_last_name;
  }

  public void setGuest_last_name(String guest_last_name) {
    this.guest_last_name = guest_last_name;
  }

  public String getGuest_email() {
    return this.guest_email;
  }

  public void setGuest_email(String guest_email) {
    this.guest_email = guest_email;
  }

  public Date getStart_date() {
    return this.start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEnd_date() {
    return this.end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }

}