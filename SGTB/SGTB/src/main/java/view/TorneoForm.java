package view;

import controller.TorneoController;
import model.Torneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TorneoForm extends JFrame {
    private JTextField nombreField;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JTextField ubicacionField;
    private JTextArea listadoArea;
    private TorneoController torneoController;

    public TorneoForm() {
        setTitle("Gestionar Torneos");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        torneoController = new TorneoController();

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.add(new JLabel("Nombre del Torneo:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Fecha Inicio (YYYY-MM-DD):"));
        fechaInicioField = new JTextField();
        formPanel.add(fechaInicioField);

        formPanel.add(new JLabel("Fecha Fin (YYYY-MM-DD):"));
        fechaFinField = new JTextField();
        formPanel.add(fechaFinField);

        formPanel.add(new JLabel("Ubicación:"));
        ubicacionField = new JTextField();
        formPanel.add(ubicacionField);

        JButton agregarButton = new JButton("Agregar Torneo");
        formPanel.add(agregarButton);

        JButton listarButton = new JButton("Listar Torneos");
        formPanel.add(listarButton);

        JButton modificarButton = new JButton("Modificar Torneo");
        formPanel.add(modificarButton);

        JButton eliminarButton = new JButton("Eliminar Torneo");
        formPanel.add(eliminarButton);

        listadoArea = new JTextArea();
        listadoArea.setEditable(false);
        add(new JScrollPane(listadoArea), BorderLayout.CENTER);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String fechaInicio = fechaInicioField.getText();
                String fechaFin = fechaFinField.getText();
                String ubicacion = ubicacionField.getText();

                if (!nombre.isEmpty() && !fechaInicio.isEmpty() && !fechaFin.isEmpty() && !ubicacion.isEmpty()) {
                    Torneo torneo = new Torneo(nombre, fechaInicio, fechaFin, ubicacion);
                    if (torneoController.agregarTorneo(torneo)) {
                        JOptionPane.showMessageDialog(null, "Torneo agregado exitosamente.");
                        nombreField.setText("");
                        fechaInicioField.setText("");
                        fechaFinField.setText("");
                        ubicacionField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar el torneo.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos.");
                }
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Torneo> torneos = torneoController.listarTorneos();
                listadoArea.setText("Torneos Registrados:\n");
                for (Torneo torneo : torneos) {
                    listadoArea.append(String.format(
                            "ID: %d - Nombre: %s, Inicio: %s, Fin: %s, Ubicación: %s\n",
                            torneo.getTorneoID(),
                            torneo.getNombre(),
                            torneo.getFechaInicio(),
                            torneo.getFechaFin(),
                            torneo.getUbicacion()
                    ));
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int torneoID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del torneo a modificar:"));
                    String nombre = nombreField.getText();
                    String fechaInicio = fechaInicioField.getText();
                    String fechaFin = fechaFinField.getText();
                    String ubicacion = ubicacionField.getText();

                    Torneo torneo = new Torneo(torneoID, nombre, fechaInicio, fechaFin, ubicacion);
                    if (torneoController.modificarTorneo(torneo)) {
                        JOptionPane.showMessageDialog(null, "Torneo modificado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al modificar el torneo.");
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
                    int torneoID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del torneo a eliminar:"));
                    if (torneoController.eliminarTorneo(torneoID)) {
                        JOptionPane.showMessageDialog(null, "Torneo eliminado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el torneo.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        add(formPanel, BorderLayout.NORTH);
    }
}

