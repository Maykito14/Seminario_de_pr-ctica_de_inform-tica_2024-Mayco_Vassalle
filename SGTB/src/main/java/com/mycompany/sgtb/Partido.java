package com.mycompany.sgtb;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Partido {
    private int partidoID;
    private Jugador jugador1;
    private Jugador jugador2;
    private Date fecha;
    private int puntajeJugador1;
    private int puntajeJugador2;
    private String resultado;

    private static ArrayList<Partido> partidos = new ArrayList<>();
    private static int partidoIDCounter = 1;

    public Partido() {}

    public Partido(Jugador jugador1, Jugador jugador2, Date fecha) {
        this.partidoID = partidoIDCounter++;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fecha = fecha;
        this.puntajeJugador1 = 0;
        this.puntajeJugador2 = 0;
        this.resultado = "Pendiente";
    }

    public int getPartidoID() {
        return partidoID;
    }

    public void setPartidoID(int partidoID) {
        this.partidoID = partidoID;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public static void crearPartido(Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del primer jugador: ");
            int jugador1ID = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el ID del segundo jugador: ");
            int jugador2ID = Integer.parseInt(scanner.nextLine());

            Jugador jugador1 = buscarJugadorPorID(jugador1ID);
            Jugador jugador2 = buscarJugadorPorID(jugador2ID);

            if (jugador1 != null && jugador2 != null) {
                Date fecha = new Date();  // Usamos la fecha actual
                Partido nuevoPartido = new Partido(jugador1, jugador2, fecha);
                partidos.add(nuevoPartido);
                System.out.println("Partido creado exitosamente.");
            } else {
                System.out.println("Uno o ambos jugadores no existen.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Los IDs deben ser números enteros.");
        }
    }

    public static void mostrarPartidos() {
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos registrados.");
        } else {
            System.out.println("\nLista de partidos:");
            for (Partido partido : partidos) {
                System.out.println("Partido ID: " + partido.partidoID + ", Jugador 1: " +
                        partido.jugador1.getNombre() + ", Jugador 2: " +
                        partido.jugador2.getNombre() + ", Fecha: " +
                        partido.fecha + ", Resultado: " + partido.resultado);
            }
        }
    }

    public static void cargarResultado(Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del partido: ");
            int partidoID = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el puntaje del jugador 1: ");
            int puntajeJugador1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el puntaje del jugador 2: ");
            int puntajeJugador2 = Integer.parseInt(scanner.nextLine());

            for (Partido partido : partidos) {
                if (partido.partidoID == partidoID) {
                    partido.puntajeJugador1 = puntajeJugador1;
                    partido.puntajeJugador2 = puntajeJugador2;
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

    private static Jugador buscarJugadorPorID(int jugadorID) {
        for (Jugador jugador : Jugador.getJugadores()) {
            if (jugador.getJugadorID() == jugadorID) {
                return jugador;
            }
        }
        return null;
    }

    public void calcularResultado() {
        if (puntajeJugador1 > puntajeJugador2) {
            resultado = "Ganador: " + jugador1.getNombre();
        } else if (puntajeJugador2 > puntajeJugador1) {
            resultado = "Ganador: " + jugador2.getNombre();
        } else {
            resultado = "Empate";
        }
    }
}

