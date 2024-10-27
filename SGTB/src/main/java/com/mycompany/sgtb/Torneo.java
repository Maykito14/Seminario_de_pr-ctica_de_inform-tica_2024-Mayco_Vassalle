package com.mycompany.sgtb;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Torneo {
    private int torneoID;
    private String nombre;
    private Date fecha;
    private String estado; // Puede ser "activo" o "inactivo"
    private ArrayList<Partido> partidos;

    private static ArrayList<Torneo> torneos = new ArrayList<>();
    private static int torneoIDCounter = 1;

    public Torneo() {
        partidos = new ArrayList<>();
    }

    public Torneo(String nombre, Date fecha) {
        this.torneoID = torneoIDCounter++;
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = "activo";
        this.partidos = new ArrayList<>();
    }

    public int getTorneoID() {
        return torneoID;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public static void crearTorneo(Scanner scanner) {
        System.out.print("Ingrese el nombre del torneo: ");
        String nombre = scanner.nextLine();
        Date fecha = new Date(); // Nuevamente, se decide utilizar la fecha actual del sistema

        Torneo nuevoTorneo = new Torneo(nombre, fecha);
        torneos.add(nuevoTorneo);

        System.out.println("Torneo creado exitosamente. ID: " + nuevoTorneo.getTorneoID());
        generarLlave(nuevoTorneo);
    }

    private static void generarLlave(Torneo torneo) {
        ArrayList<Jugador> jugadores = Jugador.getJugadores();

        if (jugadores.size() < 16) {
            System.out.println("No hay suficientes jugadores para crear un torneo. Se requieren 16 jugadores.");
            torneos.remove(torneo); // Elimina el torneo si no se puede crear
            return;
        }

        // Selecciona los primeros 16 jugadores creados en el arraylist de la clase Jugadores
        for (int i = 0; i < 16; i += 2) {
            Jugador jugador1 = jugadores.get(i);
            Jugador jugador2 = jugadores.get(i + 1);

            Partido nuevoPartido = new Partido(jugador1, jugador2, torneo.fecha);
            torneo.partidos.add(nuevoPartido);
        }

        System.out.println("Llave de partidos generada para el torneo.");
    }

    public static void mostrarTorneos() {
        if (torneos.isEmpty()) {
            System.out.println("No hay torneos registrados.");
        } else {
            System.out.println("\nLista de torneos:");
            for (Torneo torneo : torneos) {
                System.out.println("Torneo ID: " + torneo.torneoID + ", Nombre: " + torneo.nombre + ", Estado: " + torneo.estado);
            }
        }
    }

    public void mostrarPartidos() {
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos registrados en este torneo.");
        } else {
            System.out.println("\nPartidos del torneo " + nombre + ":");
            for (Partido partido : partidos) {
                System.out.println("Partido ID: " + partido.getPartidoID() + ", Jugador 1: " +
                        partido.getJugador1().getNombre() + ", Jugador 2: " +
                        partido.getJugador2().getNombre() + ", Resultado: " + partido.getResultado());
            }
        }
    }
    public static ArrayList<Torneo> getTorneos() {
        return torneos;
    }

    public void cargarResultados(Scanner scanner) {
        mostrarPartidos();
        try {
            System.out.print("Ingrese el ID del partido para cargar el resultado: ");
            int partidoID = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el puntaje del jugador 1: ");
            int puntajeJugador1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el puntaje del jugador 2: ");
            int puntajeJugador2 = Integer.parseInt(scanner.nextLine());

            for (Partido partido : partidos) {
                if (partido.getPartidoID() == partidoID) {
                    partido.setPuntajeJugador1(puntajeJugador1);
                    partido.setPuntajeJugador2(puntajeJugador2);
                    partido.calcularResultado();
                    System.out.println("Resultado cargado exitosamente.");
                    return;
                }
            }
            System.out.println("Partido no encontrado.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Los puntajes deben ser números enteros.");
        }
    }
}

    