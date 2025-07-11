package com.empresa.reservas.models;

public class Empleado {
    // Atributos de la clase

    private int id;
    private String nombre;
    private String email;
    private String departamento;
    
    // Constructor vacío necesario para frameworks o instanciación sin datos

    public Empleado() {}

    
    // Constructor completo

    public Empleado(int id, String nombre, String email, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.departamento = departamento;
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    // Representación en forma de cadena del objeto Empleado

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", email=" + email + ", departamento=" + departamento + "]";
    }
}
