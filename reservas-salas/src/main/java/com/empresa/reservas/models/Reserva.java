package com.empresa.reservas.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int id;
    private int empleadoId;
    private int salaId;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Reserva() {}

    public Reserva(int id, int empleadoId, int salaId, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.salaId = salaId;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(int empleadoId) { this.empleadoId = empleadoId; }

    public int getSalaId() { return salaId; }
    public void setSalaId(int salaId) { this.salaId = salaId; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", empleadoId=" + empleadoId + ", salaId=" + salaId +
               ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + "]";
    }
}
