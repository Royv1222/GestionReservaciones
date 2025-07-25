package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Interfaz extends JFrame {

    private JTextField txtCliente, txtHabitacion, txtEntrada, txtSalida;
    private JTextArea areaReservas;

    public Interfaz() {
        setTitle("Gestión de Reservas de Hotel");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("Cliente:"));
        txtCliente = new JTextField();
        panel.add(txtCliente);

        panel.add(new JLabel("Habitación (número):"));
        txtHabitacion = new JTextField();
        panel.add(txtHabitacion);

        panel.add(new JLabel("Fecha Entrada (yyyy-MM-dd HH:mm):"));
        txtEntrada = new JTextField();
        panel.add(txtEntrada);

        panel.add(new JLabel("Fecha Salida (yyyy-MM-dd HH:mm):"));
        txtSalida = new JTextField();
        panel.add(txtSalida);

        JButton btnGuardar = new JButton("Guardar Reserva");
        JButton btnVer = new JButton("Ver Reservas");
        panel.add(btnGuardar);
        panel.add(btnVer);

        // Área para mostrar reservas
        areaReservas = new JTextArea();
        areaReservas.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaReservas);

        // Eventos
        btnGuardar.addActionListener(this::guardarReserva);
        btnVer.addActionListener(e -> mostrarReservas());

        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private void guardarReserva(ActionEvent e) {
        String cliente = txtCliente.getText();
        int habitacion = Integer.parseInt(txtHabitacion.getText());
        String entradaStr = txtEntrada.getText();
        String salidaStr = txtSalida.getText();

        try (Connection conn = ConexionSQL.conectar()) {
            if (conn != null) {
                CallableStatement stmt = conn.prepareCall("{CALL sp_insertar_reserva(?, ?, ?, ?)}");
                stmt.setString(1, cliente);
                stmt.setInt(2, habitacion);
                stmt.setString(3, entradaStr);
                stmt.setString(4, salidaStr);
                stmt.execute();
                JOptionPane.showMessageDialog(this, "Reserva guardada correctamente.");
                limpiarCampos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }

    private void mostrarReservas() {
        areaReservas.setText("");
        try (Connection conn = ConexionSQL.conectar()) {
            if (conn != null) {
                CallableStatement stmt = conn.prepareCall("{CALL sp_listar_reservas()}");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    areaReservas.append("ID: " + rs.getInt("id") + " | Cliente: " + rs.getString("cliente") +
                            " | Habitación: " + rs.getInt("habitacion") +
                            " | Entrada: " + rs.getString("fechaEntrada") +
                            " | Salida: " + rs.getString("fechaSalida") +
                            " | Activa: " + rs.getBoolean("activa") + "\n");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        txtCliente.setText("");
        txtHabitacion.setText("");
        txtEntrada.setText("");
        txtSalida.setText("");
    }
}
