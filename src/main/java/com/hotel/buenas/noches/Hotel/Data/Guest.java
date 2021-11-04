package com.hotel.buenas.noches.Hotel.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Guest {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String first_name;
  private String last_name;
  private String email;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirst_name() {
    return this.first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return this.last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @ManyToOne
  private GuestType type;

  public GuestType getType() {
    return this.type;
  }

  public void setType(GuestType type) {
    this.type = type;
  }

}