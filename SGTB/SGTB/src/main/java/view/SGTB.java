package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SGTB extends JFrame {
    public SGTB() {
        setTitle("Sistema de Gestión de Torneos de Bochas");
        setSize(430, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton jugadoresButton = new JButton("Gestionar Jugadores");
        jugadoresButton.setBounds(100, 50, 200, 30);
        add(jugadoresButton);

        JButton partidosButton = new JButton("Gestionar Partidos");
        partidosButton.setBounds(100, 100, 200, 30);
        add(partidosButton);

        JButton torneosButton = new JButton("Gestionar Torneos");
        torneosButton.setBounds(100, 150, 200, 30);
        add(torneosButton);

        jugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JugadorForm().setVisible(true);
            }
        });

        partidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartidoForm().setVisible(true);
            }
        });

        torneosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TorneoForm().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SGTB().setVisible(true));
    }
}
