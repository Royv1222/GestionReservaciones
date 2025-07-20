package org.example;

import org.example.Reservas.Reserva;
import org.example.Usuarios.Cliente;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArchivoReserva {
    private static final String ARCHIVO = "reservas.txt";

    public static void guardar(List<Reserva> listaReservas) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Reserva reserva : listaReservas) {
                escritor.write(reserva.getIdReserva() + ";" +
                        reserva.getCliente().getNombre() + ";" +
                        reserva.getHabitacion().getNumero() + ";" +
                        reserva.getFechaEntrada() + ";" +
                        reserva.getFechaSalida() + ";" +
                        reserva.isActiva());
                escritor.newLine();
            }
        }
    }

    public static List<Reserva> cargar() throws IOException, Excepcion.ExcepcionGeneral {
        List<Reserva> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return lista;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                try {
                    Reserva reserva = ReservaDesdeLinea(linea);
                    lista.add(reserva);
                } catch (Exception e) {
                    System.err.println("Error leyendo línea: " + linea);
                    throw new Excepcion.ExcepcionGeneral("Error procesando archivo de reservas");
                }
            }
        }
        return lista;
    }

    //  Metodo para cargar las lineas de
    private static Reserva ReservaDesdeLinea(String linea) throws Exception {
        String[] partes = linea.split(";");
        if (partes.length != 6) throw new IllegalArgumentException("Línea incompleta");

        int id = Integer.parseInt(partes[0]);
        String nombreCliente = partes[1];
        int numeroHabitacion = Integer.parseInt(partes[2]);
        LocalDateTime fechaEntrada = LocalDateTime.parse(partes[3]);
        LocalDateTime fechaSalida = LocalDateTime.parse(partes[4]);
        boolean activa = Boolean.parseBoolean(partes[5]);

        Cliente cliente = new Cliente(nombreCliente);
        Habitacion habitacion = new Habitacion(numeroHabitacion, 2, null, null, false, false, null);

        Reserva reserva = new Reserva(id, cliente, habitacion, fechaEntrada, fechaSalida);
        reserva.setActiva(activa);
        return reserva;
    }
}
