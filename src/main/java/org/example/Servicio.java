package org.example;

public class Servicio {
    private int id;
    private String nombre;
    private String descripcion;
    private boolean disponible;


    public Servicio(int id, String nombre, String descripcion, boolean disponible){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.disponible = disponible;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return String.format("Servicio: %s\nDescripción:%s \nEstado %s ", nombre,descripcion,disponible?"Disponible": "No disponible");




    }
}
