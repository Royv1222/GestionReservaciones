package org.example.Usuarios;

public class Administrador extends Usuario {
    public Administrador(String nombre) {
        super(nombre);
    }

    public Administrador(String nombre, String telefono, String domicilio) {
        super(nombre, telefono, domicilio);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
}
