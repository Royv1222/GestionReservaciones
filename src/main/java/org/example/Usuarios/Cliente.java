package org.example.Usuarios;

public class Cliente extends Usuario {

    public Cliente(String nombre) {
        super(nombre);
    }

    public Cliente(String nombre, String telefono, String domicilio) {
        super(nombre, telefono, domicilio);
    }

    @Override
    public String getTipoUsuario() {
        return "Cliente";
    }


}
