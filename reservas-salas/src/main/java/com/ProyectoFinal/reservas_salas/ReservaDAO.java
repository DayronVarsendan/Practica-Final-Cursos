package com.ProyectoFinal.reservas_salas;

import com.empresa.reservas.models.Reserva;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

	 // INSERTAR reserva con control de conflictos
    public void insertarReserva(Reserva reserva) {
        if (hayConflicto(reserva)) {
            System.out.println("❌ Conflicto: ya existe una reserva para esa sala en ese horario.");
            return;
        }

        String sql = "INSERT INTO reservas (empleado_id, sala_id, fecha, hora_inicio, hora_fin) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getEmpleadoId());
            stmt.setInt(2, reserva.getSalaId());
            stmt.setDate(3, Date.valueOf(reserva.getFecha()));
            stmt.setTime(4, Time.valueOf(reserva.getHoraInicio()));
            stmt.setTime(5, Time.valueOf(reserva.getHoraFin()));

            stmt.executeUpdate();
            System.out.println("✅ Reserva insertada correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar reserva: " + e.getMessage());
        }
    }

 // VERIFICAR conflictos de horario
    private boolean hayConflicto(Reserva reserva) {
        String sql = "SELECT COUNT(*) FROM reservas " +
                     "WHERE sala_id = ? " +
                     "AND fecha = ? " +
                     "AND ( " +
                     "    (hora_inicio < ? AND hora_fin > ?) " +
                     "    OR " +
                     "    (hora_inicio >= ? AND hora_inicio < ?) " +
                     ")";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getSalaId());
            stmt.setDate(2, Date.valueOf(reserva.getFecha()));
            stmt.setTime(3, Time.valueOf(reserva.getHoraFin()));
            stmt.setTime(4, Time.valueOf(reserva.getHoraInicio()));
            stmt.setTime(5, Time.valueOf(reserva.getHoraInicio()));
            stmt.setTime(6, Time.valueOf(reserva.getHoraFin()));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al comprobar conflictos: " + e.getMessage());
        }

        return false;
    }

    // ELIMINAR una reserva por ID
    public void eliminarReserva(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Reserva eliminada correctamente.");
            } else {
                System.out.println("⚠️ Reserva no encontrada.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar reserva: " + e.getMessage());
        }
    }
    
}
