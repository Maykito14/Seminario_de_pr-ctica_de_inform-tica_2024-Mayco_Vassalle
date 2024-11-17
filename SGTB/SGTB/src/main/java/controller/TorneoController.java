package controller;

import model.DatabaseConnection;
import model.Torneo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TorneoController {

    // Método para agregar un torneo
    public boolean agregarTorneo(Torneo torneo) {
        String sql = "INSERT INTO torneos (nombre, fechaInicio, fechaFin, ubicacion) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, torneo.getNombre());
            stmt.setString(2, torneo.getFechaInicio());
            stmt.setString(3, torneo.getFechaFin());
            stmt.setString(4, torneo.getUbicacion());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Retorna true si se insertaron filas
        } catch (SQLException e) {
            System.err.println("Error al agregar el torneo: " + e.getMessage());
            return false;
        }
    }

    // Método para listar torneos
    public List<Torneo> listarTorneos() {
        List<Torneo> torneos = new ArrayList<>();
        String sql = "SELECT * FROM torneos";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Torneo torneo = new Torneo(
                        rs.getInt("torneoID"),
                        rs.getString("nombre"),
                        rs.getString("fechaInicio"),
                        rs.getString("fechaFin"),
                        rs.getString("ubicacion")
                );
                torneos.add(torneo);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar torneos: " + e.getMessage());
        }

        return torneos;
    }

    // Método para modificar un torneo
    public boolean modificarTorneo(Torneo torneo) {
        String sql = "UPDATE torneos SET nombre = ?, fechaInicio = ?, fechaFin = ?, ubicacion = ? WHERE torneoID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, torneo.getNombre());
            stmt.setString(2, torneo.getFechaInicio());
            stmt.setString(3, torneo.getFechaFin());
            stmt.setString(4, torneo.getUbicacion());
            stmt.setInt(5, torneo.getTorneoID());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Retorna true si se actualizaron filas
        } catch (SQLException e) {
            System.err.println("Error al modificar el torneo: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un torneo
    public boolean eliminarTorneo(int torneoID) {
        String sql = "DELETE FROM torneos WHERE torneoID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, torneoID);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0; // Retorna true si se eliminaron filas
        } catch (SQLException e) {
            System.err.println("Error al eliminar el torneo: " + e.getMessage());
            return false;
        }
    }
}
