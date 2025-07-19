package org.example.Reservas;
import org.example.Habitacion;
import java.time.LocalDateTime;

public class Limpieza {
    private int idLimpieza;
    private Habitacion habitacion;
    private LocalDateTime fechaHora;
    private String encargado;
    private boolean realizada;

    public Limpieza(int idLimpieza, Habitacion habitacion, LocalDateTime fechaHora, String encargado, boolean realizada) {
        this.idLimpieza = idLimpieza;
        this.habitacion = habitacion;
        this.fechaHora = fechaHora;
        this.encargado = encargado;
        this.realizada = realizada;
    }

    public int getIdLimpieza() {
        return idLimpieza;
    }

    public void setIdLimpieza(int idLimpieza) {
        this.idLimpieza = idLimpieza;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
    @Override
    public String toString() {
        return "Limpieza de habitación " + habitacion.getNumero() + " (" + habitacion.getHotel().getNombre() + ") programada para: " + fechaHora;
    }
}
