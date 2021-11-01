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
}