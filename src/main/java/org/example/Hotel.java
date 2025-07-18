package org.example;

public class Hotel {

    private int id;
    private String nombre;
    private String direccion;
    private String cuidad;
    private String pais;

    public Hotel(int id, String nombre, String direccion, String cuidad, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuidad = cuidad;
        this.pais = pais;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                ", nombre='" + nombre + '\'' +
                ", cuidad='" + cuidad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

