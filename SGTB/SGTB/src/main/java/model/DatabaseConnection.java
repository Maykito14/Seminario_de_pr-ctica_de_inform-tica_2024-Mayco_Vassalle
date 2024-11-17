package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sgtb?useSSL=false&serverTimezone=America/Argentina/Buenos_Aires";
    private static final String USER = "root";
    private static final String PASSWORD = "4440544405";

    public static Connection getConnection() throws SQLException {
        try {
            // Asegúrate de que el controlador esté registrado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador MySQL: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

