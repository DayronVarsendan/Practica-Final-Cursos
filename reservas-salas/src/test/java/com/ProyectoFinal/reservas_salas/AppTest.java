package com.ProyectoFinal.reservas_salas;

import com.empresa.reservas.models.Sala;
import com.empresa.reservas.models.Empleado;
import com.empresa.reservas.models.Reserva;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppTest {

    private SalaDAO salaDAO;
    private EmpleadoDAO empleadoDAO;
    private ReservaDAO reservaDAO;
    
    // Este método se ejecuta antes de cada test para inicializar las instancias de los DAO
    @BeforeEach
    public void setUp() {
        salaDAO = new SalaDAO();
        empleadoDAO = new EmpleadoDAO();
        reservaDAO = new ReservaDAO();
    }

    // === PRUEBAS PARA SALAS ===
    
    // Test para insertar una sala en la base de datos
    @Test
    public void testInsertarSala() {
        Sala sala = new Sala("Sala Test", 10, "Proyector");
        salaDAO.insertarSala(sala); 
    }
    
    // Test para listar todas las salas y mostrarlas por consola
    @Test
    public void testListarSalas() {
        salaDAO.listarSalas().forEach(System.out::println);
    }

    // === PRUEBAS PARA EMPLEADOS ===
    
    // Test para insertar un nuevo empleado en la base de datos
    @Test
    public void testInsertarEmpleado() {
        Empleado emp = new Empleado(0, "Empleado Test", "test@email.com", "TI");
        empleadoDAO.insertarEmpleado(emp);
    }
    
    // Test para listar todos los empleados y mostrarlos por consola
    @Test
    public void testListarEmpleados() {
        empleadoDAO.listarEmpleados().forEach(System.out::println);
    }

    // === PRUEBAS PARA RESERVAS ===
    
    // Test para insertar una nueva reserva (requiere que empleado_id y sala_id existan)
    @Test
    public void testInsertarReserva() {
        Reserva reserva = new Reserva();
        reserva.setEmpleadoId(1);
        reserva.setSalaId(1);
        reserva.setFecha(LocalDate.now().plusDays(1));
        reserva.setHoraInicio(LocalTime.of(10, 0));
        reserva.setHoraFin(LocalTime.of(11, 0));
        reservaDAO.insertarReserva(reserva);
    }

    // Test para listar todas las reservas y mostrarlas por consola
    @Test
    public void testListarReservas() {
        reservaDAO.listarReservas().forEach(System.out::println);
    }
}
