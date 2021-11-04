package com.hotel.buenas.noches.Hotel.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  private int floor;
  private int max_guest;
  @ManyToOne
  private RoomType type;
  @ManyToOne
  private Hotel hotel;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getFloor() {
    return this.floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  public int getMax_guest() {
    return this.max_guest;
  }

  public void setMax_guest(int max_guest) {
    this.max_guest = max_guest;
  }

  public RoomType getType() {
    return this.type;
  }

  public void setType(RoomType type) {
    this.type = type;
  }
  public Hotel getHotel() {
    return this.hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

}