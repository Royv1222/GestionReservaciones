package org.example.Usuarios;

public class Colaborador extends Usuario {
    public Colaborador(String nombre) {
        super(nombre);
    }

    public Colaborador(String nombre, String telefono, String domicilio) {
        super(nombre, telefono, domicilio);
    }

    @Override
    public String getTipoUsuario() {
        return "Colaborador";
    }
}
