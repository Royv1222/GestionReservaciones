package org.example;

import java.sql.*;
import java.util.Scanner;

public class GestorReserva {
    public static void insertarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Número de habitación: ");
        int habitacion = Integer.parseInt(sc.nextLine());

        System.out.print("Fecha de entrada (YYYY-MM-DD HH:MM:SS): ");
        String entrada = sc.nextLine();

        System.out.print("Fecha de salida (YYYY-MM-DD HH:MM:SS): ");
        String salida = sc.nextLine();

        String sql = "{CALL sp_insertar_reserva(?, ?, ?, ?)}";

        try (Connection conn = ConexionSQL.conectar();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, cliente);
            cs.setInt(2, habitacion);
            cs.setString(3, entrada);
            cs.setString(4, salida);
            cs.execute();

            System.out.println("✅ Reserva guardada con procedimiento almacenado.");
        } catch (SQLException e) {
            System.out.println(" Error al llamar al procedimiento: " + e.getMessage());
        }
    }

    public static void listarReservas() {
        String sql = "{CALL sp_listar_reservas()}";

        try (Connection conn = ConexionSQL.conectar();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            System.out.println("📋 Reservas:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Cliente: " + rs.getString("cliente") +
                        " | Habitación: " + rs.getInt("habitacion") +
                        " | Entrada: " + rs.getString("fechaEntrada") +
                        " | Salida: " + rs.getString("fechaSalida") +
                        " | Activa: " + rs.getBoolean("activa"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar reservas: " + e.getMessage());
        }
    }
}