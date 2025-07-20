package org.example.Reservas;
import org.example.Excepcion;
import org.example.Habitacion;
import org.example.Usuarios.Cliente;
import java.time.LocalDateTime;


public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private boolean activa;

    public Reserva(int idReserva, Cliente cliente, Habitacion habitacion,
                   LocalDateTime fechaEntrada, LocalDateTime fechaSalida) throws Excepcion.DatosInvalidosException {
        if (fechaEntrada.isAfter(fechaSalida)) {
            throw new Excepcion.DatosInvalidosException("La fecha de entrada no puede ser posterior a la de salida.");
        }
        if (cliente == null || habitacion == null) {
            throw new Excepcion.DatosInvalidosException("Cliente y habitacion no pueden estar vacio.");
        }

        this.idReserva = idReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.activa = true;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void cancelarReserva() {
        this.activa = false;
    }

    @Override
    public String toString() {
        return "Reserva #" + idReserva + " | Cliente: " + cliente.getNombre() + //getNombre se tiene que crear dentro de cliente
                " | Habitación: " + habitacion.getNumero() +
                " | Hotel: " + habitacion.getHotel().getNombre() +
                " | Entrada: " + fechaEntrada +
                " | Salida: " + fechaSalida +
                " | Activa: " + activa;
    }
}
