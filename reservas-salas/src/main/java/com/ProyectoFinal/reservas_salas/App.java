package com.ProyectoFinal.reservas_salas;


import com.empresa.reservas.models.Sala;
import com.empresa.reservas.models.Empleado;
import com.empresa.reservas.models.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;



public class App {
  public static void main(String[] args) {
	  
    // Conexión inicial a la base de datos
    ConexionBD.obtenerConexion();
    
    Scanner sc = new Scanner(System.in);// Scanner para entrada de usuario
    SalaDAO salaDAO = new SalaDAO();// DAO para salas
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();// DAO para empleados
    ReservaDAO reservaDAO = new ReservaDAO();// DAO para reservas

    int opcionPrincipal;
    
    // Bucle del menú principal
    do {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Gestionar Salas");
        System.out.println("2. Gestionar Empleados");
        System.out.println("3. Gestionar Reservas");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
        opcionPrincipal = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        
        // Navegación por el menú
        switch (opcionPrincipal) {
            case 1:
                menuSalas(sc, salaDAO); // Submenú para salas
                break;
            case 2:
                menuEmpleados(sc, empleadoDAO);// Submenú para empleados
                break;
            case 3:
                menuReservas(sc, reservaDAO);// Submenú para reservas
                break;
            case 0:
                System.out.println("👋 Saliendo...");
                break;
            default:
                System.out.println("❌ Opción no válida.");
        }
    } while (opcionPrincipal != 0);
}

  // Submenú para gestionar SALAS
public static void menuSalas(Scanner sc, SalaDAO salaDAO) {
    int opcion;
    do {
        System.out.println("\n--- Gestión de Salas ---");
        System.out.println("1. Insertar sala");
        System.out.println("2. Listar salas");
        System.out.println("3. Actualizar sala");
        System.out.println("4. Eliminar sala");
        System.out.println("0. Volver");
        System.out.print("Elige una opción: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                // Insertar nueva sala

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Capacidad: ");
                int capacidad = sc.nextInt();
                sc.nextLine(); // limpiar
                System.out.print("Recursos: ");
                String recursos = sc.nextLine();

                Sala nuevaSala = new Sala(nombre, capacidad, recursos);
                salaDAO.insertarSala(nuevaSala);
                break;
            case 2:
                // Listar todas las salas

                salaDAO.listarSalas().forEach(System.out::println);
                break;
            case 3:
                // Actualizar sala existente

                System.out.print("ID de la sala a actualizar: ");
                int idActualizar = sc.nextInt();
                sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                System.out.print("Nueva capacidad: ");
                int nuevaCapacidad = sc.nextInt();
                sc.nextLine();
                System.out.print("Nuevos recursos: ");
                String nuevosRecursos = sc.nextLine();
                salaDAO.actualizarSala(new Sala(idActualizar, nuevoNombre, nuevaCapacidad, nuevosRecursos));
                break;
            case 4:
                // Eliminar sala por ID

                System.out.print("ID de la sala a eliminar: ");
                int idEliminar = sc.nextInt();
                salaDAO.eliminarSala(idEliminar);
                break;
            case 0:
                // Volver al menú principal

                break;
            default:
                System.out.println("❌ Opción no válida.");
        }
    } while (opcion != 0);
}

// Submenú para gestionar EMPLEADOS
public static void menuEmpleados(Scanner sc, EmpleadoDAO empleadoDAO) {
    int opcion;
    do {
        System.out.println("\n--- Gestión de Empleados ---");
        System.out.println("1. Insertar empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Actualizar empleado");
        System.out.println("4. Eliminar empleado");
        System.out.println("0. Volver");
        System.out.print("Elige una opción: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                // Insertar nuevo empleado

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Departamento: ");
                String departamento = sc.nextLine();

                Empleado nuevoEmp = new Empleado(0, nombre, email, departamento);
                empleadoDAO.insertarEmpleado(nuevoEmp);
                break;
            case 2:
                // Listar empleados

                empleadoDAO.listarEmpleados().forEach(System.out::println);
                break;
            case 3:
                // Actualizar empleado

                System.out.print("ID del empleado a actualizar: ");
                int idActualizar = sc.nextInt();
                sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                System.out.print("Nuevo email: ");
                String nuevoEmail = sc.nextLine();
                System.out.print("Nuevo departamento: ");
                String nuevoDep = sc.nextLine();

                empleadoDAO.actualizarEmpleado(new Empleado(idActualizar, nuevoNombre, nuevoEmail, nuevoDep));
                break;
            case 4:
                // Eliminar empleado

                System.out.print("ID del empleado a eliminar: ");
                int idEliminar = sc.nextInt();
                empleadoDAO.eliminarEmpleado(idEliminar);
                break;
            case 0:
                // Volver al menú principal

                break;
            default:
                System.out.println("❌ Opción no válida.");
        }
    } while (opcion != 0);
}

// Submenú para gestionar RESERVAS
public static void menuReservas(Scanner sc, ReservaDAO reservaDAO) {
    int opcion;
    do {
        System.out.println("\n--- Gestión de Reservas ---");
        System.out.println("1. Crear reserva");
        System.out.println("2. Listar reservas");
        System.out.println("3. Eliminar reserva");
        System.out.println("0. Volver");
        System.out.print("Elige una opción: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                // Crear una nueva reserva

                System.out.print("ID de empleado: ");
                int empleadoId = sc.nextInt();
                System.out.print("ID de sala: ");
                int salaId = sc.nextInt();
                sc.nextLine(); 
                
                // Pedir fecha y horas

                System.out.print("Fecha (YYYY-MM-DD): ");
                LocalDate fecha = LocalDate.parse(sc.nextLine());
                System.out.print("Hora de inicio (HH:MM): ");
                LocalTime inicio = LocalTime.parse(sc.nextLine());
                System.out.print("Hora de fin (HH:MM): ");
                LocalTime fin = LocalTime.parse(sc.nextLine());

                Reserva nuevaReserva = new Reserva(0, empleadoId, salaId, fecha, inicio, fin);
                reservaDAO.insertarReserva(nuevaReserva);
                break;
            case 2:
                // Listar reservas existentes

                List<Reserva> reservas = reservaDAO.listarReservas();
                reservas.forEach(System.out::println);
                break;
            case 3:
                // Eliminar reserva por ID

                System.out.print("ID de la reserva a eliminar: ");
                int idEliminar = sc.nextInt();
                reservaDAO.eliminarReserva(idEliminar);
                break;
            case 0:
                // Volver al menú principal

                break;
            default:
                System.out.println("❌ Opción no válida.");
        }
    } while (opcion != 0);
  }
}
