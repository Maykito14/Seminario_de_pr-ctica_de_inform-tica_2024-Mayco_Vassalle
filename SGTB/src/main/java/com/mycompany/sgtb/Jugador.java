package com.mycompany.sgtb;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    private int jugadorID;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private int puntaje;

    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static int jugadorIDCounter = 1;

    public Jugador() {}

    public Jugador(int jugadorID, String nombre, String apellido, int edad, String email, int puntaje) {
        this.jugadorID = jugadorID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.puntaje = puntaje;
    }

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

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public static void agregarJugador(Scanner scanner) {
        try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese la edad del jugador: ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el email del jugador: ");
            String email = scanner.nextLine();

            System.out.print("Ingrese el puntaje del jugador: ");
            int puntaje = Integer.parseInt(scanner.nextLine());

            Jugador nuevoJugador = new Jugador(jugadorIDCounter++, nombre, apellido, edad, email, puntaje);
            jugadores.add(nuevoJugador);
            System.out.println("Jugador agregado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. La edad y el puntaje deben ser números enteros.");
        }
    }

    public static void mostrarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            System.out.println("\nLista de jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "ID=" + jugadorID +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Edad=" + edad +
                ", Email='" + email + '\'' +
                ", Puntaje=" + puntaje +
                '}';
    }
}

