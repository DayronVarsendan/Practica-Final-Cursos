package com.empresa.reservas.models;


public class Sala {
	
	private int id;// ID único de la sala (clave primaria en la BD)
    private String nombre;// Nombre de la sala
    private int capacidad;// Capacidad máxima de personas
    private String recursos;// Recursos disponibles en la sala


    public Sala() {}

 // Constructor para insertar una sala (sin ID)
    public Sala(String nombre, int capacidad, String recursos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.recursos = recursos;
    }

    // Constructor completo (para leer desde BD o actualizar)
    public Sala(int id, String nombre, int capacidad, String recursos) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.recursos = recursos;
    }


    // Getters y setters para cada campo
    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    
    // Representación en forma de texto de una sala, útil para impresión
    @Override
    public String toString() {
        return "Sala [id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", recursos=" + recursos + "]";
    }
}
