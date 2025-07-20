package org.example;

public class Excepcion extends Exception {
    public Excepcion(String mensaje) {
        super(mensaje);
    }

    //  Error cuando la habitacion ya esta reservada
    public static class ReservaNoDisponibleException extends Excepcion {
        public ReservaNoDisponibleException(String mensaje) {
            super(mensaje);
        }
    }

    // Error cuando las fechas estan mal o faltan datos
    public static class DatosInvalidosException extends Excepcion {
        public DatosInvalidosException(String mensaje) {
            super(mensaje);
        }
    }

    // siError general para cualquier caso
    public static class ExcepcionGeneral extends Excepcion {
        public ExcepcionGeneral(String mensaje) {
            super("Error inesperado: " + mensaje);
        }
    }
}
