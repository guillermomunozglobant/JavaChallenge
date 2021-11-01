package com.hotel.buenas.noches.Hotel.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @ManyToOne
  private Room room;
  @ManyToOne
  private Guest guest;
  private Date start_date;
  private Date end_date;
  private boolean check_in;
  private boolean check_out;
}