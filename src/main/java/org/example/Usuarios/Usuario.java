package org.example.Usuarios;

public abstract class Usuario {
    private String nombre;
    private String telefono;
    private String domicilio;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, String telefono, String domicilio) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public abstract String getTipoUsuario();
}
