package view;

import controller.PartidoController;
import model.Partido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PartidoForm extends JFrame {
    private JTextField jugador1Field;
    private JTextField jugador2Field;
    private JTextField fechaField;
    private JTextField puntajeJugador1Field;
    private JTextField puntajeJugador2Field;
    private JTextField resultadoField;
    private JTextArea listadoArea;
    private PartidoController partidoController;

    public PartidoForm() {
        setTitle("Gestionar Partidos");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        partidoController = new PartidoController();

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(8, 2));
        formPanel.add(new JLabel("Jugador 1 ID:"));
        jugador1Field = new JTextField();
        formPanel.add(jugador1Field);

        formPanel.add(new JLabel("Jugador 2 ID:"));
        jugador2Field = new JTextField();
        formPanel.add(jugador2Field);

        formPanel.add(new JLabel("Fecha (YYYY-MM-DD):"));
        fechaField = new JTextField();
        formPanel.add(fechaField);

        formPanel.add(new JLabel("Puntaje Jugador 1:"));
        puntajeJugador1Field = new JTextField();
        formPanel.add(puntajeJugador1Field);

        formPanel.add(new JLabel("Puntaje Jugador 2:"));
        puntajeJugador2Field = new JTextField();
        formPanel.add(puntajeJugador2Field);

        formPanel.add(new JLabel("Resultado:"));
        resultadoField = new JTextField();
        formPanel.add(resultadoField);

        JButton agregarButton = new JButton("Agregar Partido");
        formPanel.add(agregarButton);

        JButton listarButton = new JButton("Listar Partidos");
        formPanel.add(listarButton);

        JButton modificarButton = new JButton("Modificar Partido");
        formPanel.add(modificarButton);

        JButton eliminarButton = new JButton("Eliminar Partido");
        formPanel.add(eliminarButton);

        listadoArea = new JTextArea();
        listadoArea.setEditable(false);
        add(new JScrollPane(listadoArea), BorderLayout.CENTER);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int jugador1 = Integer.parseInt(jugador1Field.getText());
                    int jugador2 = Integer.parseInt(jugador2Field.getText());
                    String fecha = fechaField.getText();
                    int puntajeJugador1 = Integer.parseInt(puntajeJugador1Field.getText());
                    int puntajeJugador2 = Integer.parseInt(puntajeJugador2Field.getText());
                    String resultado = resultadoField.getText();

                    Partido partido = new Partido(jugador1, jugador2, fecha, puntajeJugador1, puntajeJugador2, resultado);
                    if (partidoController.agregarPartido(partido)) {
                        JOptionPane.showMessageDialog(null, "Partido agregado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar el partido.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Partido> partidos = partidoController.listarPartidos();
                listadoArea.setText("Partidos Registrados:\n");
                for (Partido partido : partidos) {
                    listadoArea.append(String.format(
                            "ID: %d - Jugador 1: %d, Jugador 2: %d, Fecha: %s, Puntaje1: %d, Puntaje2: %d, Resultado: %s\n",
                            partido.getPartidoID(),
                            partido.getJugador1ID(),
                            partido.getJugador2ID(),
                            partido.getFecha(),
                            partido.getPuntajeJugador1(),
                            partido.getPuntajeJugador2(),
                            partido.getResultado()
                    ));
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int partidoID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del partido a modificar:"));
                    int jugador1 = Integer.parseInt(jugador1Field.getText());
                    int jugador2 = Integer.parseInt(jugador2Field.getText());
                    String fecha = fechaField.getText();
                    int puntajeJugador1 = Integer.parseInt(puntajeJugador1Field.getText());
                    int puntajeJugador2 = Integer.parseInt(puntajeJugador2Field.getText());
                    String resultado = resultadoField.getText();

                    Partido partido = new Partido(partidoID, jugador1, jugador2, fecha, puntajeJugador1, puntajeJugador2, resultado);
                    if (partidoController.modificarPartido(partido)) {
                        JOptionPane.showMessageDialog(null, "Partido modificado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al modificar el partido.");
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
                    int partidoID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del partido a eliminar:"));
                    if (partidoController.eliminarPartido(partidoID)) {
                        JOptionPane.showMessageDialog(null, "Partido eliminado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el partido.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        add(formPanel, BorderLayout.NORTH);
    }
}
