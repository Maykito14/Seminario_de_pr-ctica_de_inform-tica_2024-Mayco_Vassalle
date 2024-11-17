package controller;

import model.DatabaseConnection;
import model.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorController {

    public boolean agregarJugador(Jugador jugador) {
        String query = "INSERT INTO jugadores (nombre, apellido, edad, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getApellido());
            stmt.setInt(3, jugador.getEdad());
            stmt.setString(4, jugador.getEmail());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Jugador> listarJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM jugadores";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                jugadores.add(new Jugador(
                        rs.getInt("jugadorID"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("email"),
                        rs.getInt("puntaje")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }
    
    public boolean modificarJugador(Jugador jugador) {
    String query = "UPDATE jugadores SET nombre = ?, apellido = ?, edad = ?, email = ?, puntaje = ? WHERE jugadorID = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, jugador.getNombre());
        stmt.setString(2, jugador.getApellido());
        stmt.setInt(3, jugador.getEdad());
        stmt.setString(4, jugador.getEmail());
        stmt.setInt(5, jugador.getPuntaje());
        stmt.setInt(6, jugador.getJugadorID());
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean eliminarJugador(int jugadorID) {
    String query = "DELETE FROM jugadores WHERE jugadorID = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, jugadorID);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    
}
