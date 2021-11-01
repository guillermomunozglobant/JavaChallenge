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
}