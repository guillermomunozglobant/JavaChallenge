package com.hotel.buenas.noches.Hotel.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  private int stars;

  public Long getId(){
    return id;
  }
  public String getName() {
    return name;
  }
  public int getStars() {
    return stars;
  }
  public void setStars(int stars) {
    this.stars = stars;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setId(Long id) {
    this.id = id;
  }
}