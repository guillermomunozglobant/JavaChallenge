package com.hotel.buenas.noches.Hotel.Model;

public class Respuesta <T>{
  private String Mensaje;
  private T Objeto;
  
  public Respuesta(T objeto){
    Mensaje = "Exitoso";
    Objeto = objeto;
  }

  public String getMensaje() {
    return this.Mensaje;
  }

  public void setMensaje(String Mensaje) {
    this.Mensaje = Mensaje;
  }

  public T getObjeto() {
    return this.Objeto;
  }

  public void setObjeto(T Objeto) {
    this.Objeto = Objeto;
  }

}