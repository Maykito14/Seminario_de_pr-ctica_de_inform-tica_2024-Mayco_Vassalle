package com.mycompany.sgtb;

import java.util.Scanner;

public class SGTB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("--------------------------------------------------------");
            System.out.println("BIENVENIDOS AL SISTEMA DE GESTION DE TORNEOS DE BOCHAS");
            System.out.println("--------------------------------------------------------");
            System.out.println("\nMenú de Gestión:");
            System.out.println("Por favor, elija una opción del menú para continuar.");
            System.out.println("\n1. Dar de alta un nuevo jugador");
            System.out.println("2. Consultar jugadores");
            System.out.println("3. Crear un nuevo partido");
            System.out.println("4. Consultar partidos");
            System.out.println("5. Cargar resultado de un partido");
            System.out.println("6. Crear un nuevo torneo");
            System.out.println("7. Consultar torneos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        Jugador.agregarJugador(scanner);
                        break;
                    case 2:
                        Jugador.mostrarJugadores();
                        break;
                    case 3:
                        Partido.crearPartido(scanner);
                        break;
                    case 4:
                        Partido.mostrarPartidos();
                        break;
                    case 5:
                        Partido.cargarResultado(scanner);
                        break;
                    case 6:
                        Torneo.crearTorneo(scanner);
                        break;
                    case 7:
                        Torneo.mostrarTorneos();
                        break;
                    case 8:
                        System.out.println("Gracias por utilizar el sistema! Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo con una de las opciones del menú.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}

