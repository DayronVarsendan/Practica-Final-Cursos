package com.ProyectoFinal.reservas_salas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {

	private static final String URL = "jdbc:mysql://localhost:3306/reservas_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "1234";

    public static Connection obtenerConexion() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión exitosa a la base de datos.");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar: " + e.getMessage());
            return null;
        }
    }
}
