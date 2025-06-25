package com.ProyectoFinal.reservas_salas;

import com.empresa.reservas.models.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {


    // INSERTAR empleado
    public void insertarEmpleado(Empleado emp) {
        String sql = "INSERT INTO empleados (nombre, email, departamento) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getEmail());
            stmt.setString(3, emp.getDepartamento());

            stmt.executeUpdate();
            System.out.println("✅ Empleado insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar empleado: " + e.getMessage());
        }
    }

    // LISTAR empleados
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Empleado emp = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("departamento")
                );
                empleados.add(emp);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al listar empleados: " + e.getMessage());
        }

        return empleados;
    }

    // ACTUALIZAR empleado
    public void actualizarEmpleado(Empleado emp) {
        String sql = "UPDATE empleados SET nombre = ?, email = ?, departamento = ? WHERE id = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getEmail());
            stmt.setString(3, emp.getDepartamento());
            stmt.setInt(4, emp.getId());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Empleado actualizado correctamente.");
            } else {
                System.out.println("⚠️ Empleado no encontrado.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar empleado: " + e.getMessage());
        }
    }

    // ELIMINAR empleado por ID
    public void eliminarEmpleado(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Empleado eliminado correctamente.");
            } else {
                System.out.println("⚠️ Empleado no encontrado.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar empleado: " + e.getMessage());
        }
    }
}
