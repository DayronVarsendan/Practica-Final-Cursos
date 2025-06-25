package com.ProyectoFinal.reservas_salas;

import com.empresa.reservas.models.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {

    // INSERTAR una sala
    public void insertarSala(Sala sala) {
    	String sql = "INSERT INTO salas (nombre, capacidad, recursos) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	 stmt.setString(1, sala.getNombre());
             stmt.setInt(2, sala.getCapacidad());
             stmt.setString(3, sala.getRecursos());

            stmt.executeUpdate();

            System.out.println("✅ Sala insertada correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar sala: " + e.getMessage());
        }
    }

    // LISTAR todas las salas
    public List<Sala> listarSalas() {
    	List<Sala> salas = new ArrayList<>();
        String sql = "SELECT * FROM salas";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
            	
            	Sala sala = new Sala(
            	rs.getInt("id"),
            	rs.getString("nombre"),
            	rs.getInt("capacidad"),
            	rs.getString("recursos")
            	
            		);
            	
                salas.add(sala);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al listar salas: " + e.getMessage());
        }

        return salas;
    }

    // ACTUALIZAR una sala
    public void actualizarSala(Sala sala) {
    	String sql = "UPDATE salas SET nombre = ?, capacidad = ?, recursos = ? WHERE id = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	stmt.setString(1, sala.getNombre());
        	stmt.setInt(2, sala.getCapacidad());
        	stmt.setString(3, sala.getRecursos());
        	stmt.setInt(4, sala.getId());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Sala actualizada correctamente.");
            } else {
                System.out.println("⚠️ Sala no encontrada.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar sala: " + e.getMessage());
        }
    }

    // ELIMINAR una sala por ID
    public void eliminarSala(int id) {
        String sql = "DELETE FROM salas WHERE id = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Sala eliminada correctamente.");
            } else {
                System.out.println("⚠️ Sala no encontrada.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar sala: " + e.getMessage());
        }
    }
}