package controller;

import model.DatabaseConnection;
import model.Partido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidoController {
    // Agregar un partido
    public boolean agregarPartido(Partido partido) {
        String query = "INSERT INTO partidos (jugador1ID, jugador2ID, fecha, puntajeJugador1, puntajeJugador2, resultado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, partido.getJugador1ID());
            stmt.setInt(2, partido.getJugador2ID());
            stmt.setString(3, partido.getFecha());
            stmt.setInt(4, partido.getPuntajeJugador1());
            stmt.setInt(5, partido.getPuntajeJugador2());
            stmt.setString(6, partido.getResultado());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar el partido: " + e.getMessage());
            return false;
        }
    }

    // Listar todos los partidos
    public List<Partido> listarPartidos() {
        String query = "SELECT * FROM partidos";
        List<Partido> partidos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                partidos.add(new Partido(
                        rs.getInt("partidoID"),
                        rs.getInt("jugador1ID"),
                        rs.getInt("jugador2ID"),
                        rs.getString("fecha"),
                        rs.getInt("puntajeJugador1"),
                        rs.getInt("puntajeJugador2"),
                        rs.getString("resultado")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los partidos: " + e.getMessage());
        }
        return partidos;
    }

    // Modificar un partido
    public boolean modificarPartido(Partido partido) {
        String query = "UPDATE partidos SET jugador1ID = ?, jugador2ID = ?, fecha = ?, puntajeJugador1 = ?, puntajeJugador2 = ?, resultado = ? WHERE partidoID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, partido.getJugador1ID());
            stmt.setInt(2, partido.getJugador2ID());
            stmt.setString(3, partido.getFecha());
            stmt.setInt(4, partido.getPuntajeJugador1());
            stmt.setInt(5, partido.getPuntajeJugador2());
            stmt.setString(6, partido.getResultado());
            stmt.setInt(7, partido.getPartidoID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar el partido: " + e.getMessage());
            return false;
        }
    }

    // Eliminar un partido
    public boolean eliminarPartido(int partidoID) {
        String query = "DELETE FROM partidos WHERE partidoID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, partidoID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el partido: " + e.getMessage());
            return false;
        }
    }
}
