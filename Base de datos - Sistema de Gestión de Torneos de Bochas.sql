CREATE DATABASE IF NOT EXISTS sgtb;
USE sgtb;

CREATE TABLE IF NOT EXISTS jugadores (
    jugadorID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    puntaje INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS partidos (
    partidoID INT AUTO_INCREMENT PRIMARY KEY,
    jugador1ID INT NOT NULL,
    jugador2ID INT NOT NULL,
    fecha DATE NOT NULL,
    puntajeJugador1 INT NOT NULL,
    puntajeJugador2 INT NOT NULL,
    resultado VARCHAR(50) NOT NULL,
    FOREIGN KEY (jugador1ID) REFERENCES jugadores(jugadorID) ON DELETE CASCADE,
    FOREIGN KEY (jugador2ID) REFERENCES jugadores(jugadorID) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS torneos (
    torneoID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    ubicacion VARCHAR(100) NOT NULL
);
