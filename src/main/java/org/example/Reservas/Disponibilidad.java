package org.example.Reservas;
import org.example.Excepcion;
import org.example.Habitacion;
import java.time.LocalDateTime;
import java.util.List;

public class Disponibilidad {

    public static void verificarDisponibilidad(Habitacion habitacion, LocalDateTime nuevaEntrada,
                                               LocalDateTime nuevaSalida, List<Reserva> reservas)
            throws Excepcion.ReservaNoDisponibleException {
        for (Reserva r : reservas) {
            if (r.isActiva() && r.getHabitacion().getNumero() == habitacion.getNumero()) {
                LocalDateTime entradaExistente = r.getFechaEntrada();
                LocalDateTime salidaExistente = r.getFechaSalida();

                if (nuevaSalida.isAfter(entradaExistente.minusHours(3)) &&
                        nuevaEntrada.isBefore(salidaExistente.plusHours(3))) {
                    throw new Excepcion.ReservaNoDisponibleException("La habitacion no esta disponible entre " +
                            entradaExistente + " y " + salidaExistente + ".");
                }
            }
        }
    }
}

