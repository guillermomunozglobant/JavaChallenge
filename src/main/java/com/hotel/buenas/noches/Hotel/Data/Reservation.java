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

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne
  private Room room;

  public Room getRoom() {
    return this.room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  @ManyToOne
  private Guest guest;
  private Date start_date;
  private Date end_date;
  private boolean check_in;
  private boolean check_out;

  public Guest getGuest() {
    return this.guest;
  }

  public void setGuest(Guest guest) {
    this.guest = guest;
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

  public boolean isCheck_in() {
    return this.check_in;
  }

  public void setCheck_in(boolean check_in) {
    this.check_in = check_in;
  }

  public boolean isCheck_out() {
    return this.check_out;
  }

  public void setCheck_out(boolean check_out) {
    this.check_out = check_out;
  }

}