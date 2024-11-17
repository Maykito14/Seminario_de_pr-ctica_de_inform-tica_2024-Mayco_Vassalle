package model;

public class Torneo {
    private int torneoID;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private String ubicacion;

    // Constructor vacío
    public Torneo() {
    }

    // Constructor sin ID (para agregar un nuevo torneo)
    public Torneo(String nombre, String fechaInicio, String fechaFin, String ubicacion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
    }

    // Constructor con ID (para modificar o trabajar con torneos existentes)
    public Torneo(int torneoID, String nombre, String fechaInicio, String fechaFin, String ubicacion) {
        this.torneoID = torneoID;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
    }

    // Getters y setters
    public int getTorneoID() {
        return torneoID;
    }

    public void setTorneoID(int torneoID) {
        this.torneoID = torneoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}

    