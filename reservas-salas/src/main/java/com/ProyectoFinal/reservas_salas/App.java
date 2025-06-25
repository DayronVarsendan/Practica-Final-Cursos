package com.ProyectoFinal.reservas_salas;


import com.empresa.reservas.models.Sala;
import java.util.List;
import java.util.Scanner;



public class App {
  public static void main(String[] args) {
    ConexionBD.obtenerConexion();
    
    Scanner sc = new Scanner(System.in);
    SalaDAO salaDAO = new SalaDAO();
    int opcion;

    do {
        System.out.println("\n==== MENÚ DE GESTIÓN DE SALAS ====");
        System.out.println("1. Insertar sala");
        System.out.println("2. Listar salas");
        System.out.println("3. Actualizar sala");
        System.out.println("4. Eliminar sala");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.print("Nombre de la sala: ");
                String nombre = sc.nextLine();
                System.out.print("Capacidad: ");
                int capacidad = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                System.out.print("Recursos (separados por comas): ");
                String recursos = sc.nextLine();

                Sala nuevaSala = new Sala(nombre, capacidad, recursos);
                salaDAO.insertarSala(nuevaSala);
                break;

            case 2:
                List<Sala> salas = salaDAO.listarSalas();
                System.out.println("\n--- Lista de Salas ---");
                for (Sala s : salas) {
                    System.out.println("ID: " + s.getId() +
                                       ", Nombre: " + s.getNombre() +
                                       ", Capacidad: " + s.getCapacidad() +
                                       ", Recursos: " + s.getRecursos());
                }
                break;

            case 3:
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

                Sala salaActualizada = new Sala(idActualizar, nuevoNombre, nuevaCapacidad, nuevosRecursos);
                salaDAO.actualizarSala(salaActualizada);
                break;

            case 4:
                System.out.print("ID de la sala a eliminar: ");
                int idEliminar = sc.nextInt();
                sc.nextLine();
                salaDAO.eliminarSala(idEliminar);
                break;

            case 0:
                System.out.println("👋 Saliendo del sistema.");
                break;

            default:
                System.out.println("⚠️ Opción inválida.");
        }
    } while (opcion != 0);
  }
}
