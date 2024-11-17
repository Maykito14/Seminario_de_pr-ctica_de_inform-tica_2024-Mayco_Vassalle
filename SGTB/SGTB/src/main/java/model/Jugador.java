package model;

public class Jugador {
    private int jugadorID;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private int puntaje;

    public Jugador(int jugadorID, String nombre, String apellido, int edad, String email, int puntaje) {
        this.jugadorID = jugadorID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.puntaje = puntaje;
    }

    public Jugador(String nombre, String apellido, int edad, String email) {
        this(0, nombre, apellido, edad, email, 0);
    }

    // Getters y Setters
    public int getJugadorID() {
        return jugadorID;
    }

    public void setJugadorID(int jugadorID) {
        this.jugadorID = jugadorID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}


