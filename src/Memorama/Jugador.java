package Memorama;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Jugador implements Serializable {

    private String jugador;
    private long puntuacion;
    private LocalDate fecha;

    public Jugador(String jugador, long puntuacion, LocalDate fecha) {
        this.jugador = jugador;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "JUGADOR { nombre: " + jugador +", tiempo en resolver: " + puntuacion + ", fecha: " + fecha +"}";
    }
}
