package view;

import controller.JugadorController;
import model.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JugadorForm extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JTextField emailField;
    private JTextArea listadoArea;
    private JugadorController jugadorController;

    public JugadorForm() {
        setTitle("Gestionar Jugadores");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        jugadorController = new JugadorController();

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        formPanel.add(apellidoField);

        formPanel.add(new JLabel("Edad:"));
        edadField = new JTextField();
        formPanel.add(edadField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        JButton agregarButton = new JButton("Agregar Jugador");
        formPanel.add(agregarButton);

        JButton listarButton = new JButton("Listar Jugadores");
        formPanel.add(listarButton);

        JButton modificarButton = new JButton("Modificar Jugador");
        formPanel.add(modificarButton);

        JButton eliminarButton = new JButton("Eliminar Jugador");
        formPanel.add(eliminarButton);

        listadoArea = new JTextArea();
        listadoArea.setEditable(false);
        add(new JScrollPane(listadoArea), BorderLayout.CENTER);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String edadTexto = edadField.getText();
                String email = emailField.getText();

                if (!nombre.isEmpty() && !apellido.isEmpty() && !edadTexto.isEmpty() && !email.isEmpty()) {
                    try {
                        int edad = Integer.parseInt(edadTexto);
                        Jugador jugador = new Jugador(nombre, apellido, edad, email);
                        if (jugadorController.agregarJugador(jugador)) {
                            JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente.");
                            nombreField.setText("");
                            apellidoField.setText("");
                            edadField.setText("");
                            emailField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al agregar el jugador.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Edad debe ser un número.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos.");
                }
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Jugador> jugadores = jugadorController.listarJugadores();
                listadoArea.setText("Jugadores Registrados:\n");
                for (Jugador jugador : jugadores) {
                    listadoArea.append(String.format("ID: %d - %s %s, Edad: %d, Email: %s, Puntaje: %d\n",
                            jugador.getJugadorID(),
                            jugador.getNombre(),
                            jugador.getApellido(),
                            jugador.getEdad(),
                            jugador.getEmail(),
                            jugador.getPuntaje()));
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int jugadorID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del jugador a modificar:"));
                    String nombre = nombreField.getText();
                    String apellido = apellidoField.getText();
                    int edad = Integer.parseInt(edadField.getText());
                    String email = emailField.getText();
                    int puntaje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo puntaje:"));

                    Jugador jugador = new Jugador(jugadorID, nombre, apellido, edad, email, puntaje);
                    if (jugadorController.modificarJugador(jugador)) {
                        JOptionPane.showMessageDialog(null, "Jugador modificado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al modificar el jugador.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int jugadorID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del jugador a eliminar:"));
                    if (jugadorController.eliminarJugador(jugadorID)) {
                        JOptionPane.showMessageDialog(null, "Jugador eliminado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el jugador.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        add(formPanel, BorderLayout.NORTH);
    }
}
