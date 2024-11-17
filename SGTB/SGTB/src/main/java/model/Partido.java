package model;

public class Partido {
    private int partidoID;
    private int jugador1ID;
    private int jugador2ID;
    private String fecha;
    private int puntajeJugador1;
    private int puntajeJugador2;
    private String resultado;

    // Constructor completo
    public Partido(int partidoID, int jugador1ID, int jugador2ID, String fecha, int puntajeJugador1, int puntajeJugador2, String resultado) {
        this.partidoID = partidoID;
        this.jugador1ID = jugador1ID;
        this.jugador2ID = jugador2ID;
        this.fecha = fecha;
        this.puntajeJugador1 = puntajeJugador1;
        this.puntajeJugador2 = puntajeJugador2;
        this.resultado = resultado;
    }

    // Constructor sin ID (para agregar nuevos partidos)
    public Partido(int jugador1ID, int jugador2ID, String fecha, int puntajeJugador1, int puntajeJugador2, String resultado) {
        this.jugador1ID = jugador1ID;
        this.jugador2ID = jugador2ID;
        this.fecha = fecha;
        this.puntajeJugador1 = puntajeJugador1;
        this.puntajeJugador2 = puntajeJugador2;
        this.resultado = resultado;
    }

    // Getters y Setters
    public int getPartidoID() {
        return partidoID;
    }

    public void setPartidoID(int partidoID) {
        this.partidoID = partidoID;
    }

    public int getJugador1ID() {
        return jugador1ID;
    }

    public void setJugador1ID(int jugador1ID) {
        this.jugador1ID = jugador1ID;
    }

    public int getJugador2ID() {
        return jugador2ID;
    }

    public void setJugador2ID(int jugador2ID) {
        this.jugador2ID = jugador2ID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPuntajeJugador1() {
        return puntajeJugador1;
    }

    public void setPuntajeJugador1(int puntajeJugador1) {
        this.puntajeJugador1 = puntajeJugador1;
    }

    public int getPuntajeJugador2() {
        return puntajeJugador2;
    }

    public void setPuntajeJugador2(int puntajeJugador2) {
        this.puntajeJugador2 = puntajeJugador2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}

