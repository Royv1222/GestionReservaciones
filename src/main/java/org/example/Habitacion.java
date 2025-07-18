package org.example;

import java.util.List;

public class Habitacion {
    private  int numero;
    private  int capacidadPersonas;
    private Hotel hotel;
    private  TipoHabitacion tipoHabitacion;
    private  boolean permiteMascota;
    private  boolean movilidadReducida;
    private List<Servicio> servicios;

    public Habitacion(int numero, int capacidadPersonas, Hotel hotel, TipoHabitacion tipoHabitacion, boolean permiteMascota, boolean movilidadReducida,List<Servicio> servicios){
        this.numero = numero;
        this.capacidadPersonas = capacidadPersonas;
        this.hotel = hotel;
        this.tipoHabitacion = tipoHabitacion;
        this.permiteMascota = permiteMascota;
        this.movilidadReducida = movilidadReducida;
        this.servicios = servicios;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public boolean isPermiteMascota() {
        return permiteMascota;
    }

    public void setPermiteMascota(boolean permiteMascota) {
        this.permiteMascota = permiteMascota;
    }

    public boolean isMovilidadReducida() {
        return movilidadReducida;
    }

    public void setMovilidadReducida(boolean movilidadReducida) {
        this.movilidadReducida = movilidadReducida;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Habitacion"+ numero " - " + tipoHabitacion.getNombre() + " en " + hotel.getNombre();
    }
}
