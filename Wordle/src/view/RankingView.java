package view;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import logica.Ranking;

public class RankingView extends JFrame {

    public RankingView() {
        setTitle("Ranking");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel mejorTiempo = new JLabel("Mejor tiempo: " + Ranking.obtenerMejorTiempo());
        add(mejorTiempo, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        JButton btnVolver = new JButton("VOLVER");

        btnVolver.addActionListener(e -> {
            new MenuView().setVisible(true); // abre menu
            dispose();                       // cierra ranking
        });

        add(btnVolver, BorderLayout.SOUTH);

        try (BufferedReader br = new BufferedReader(new FileReader("ranking.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                textArea.append(linea + "\n");
            }
        } catch (IOException e) {
            textArea.setText("No hay ranking aún");
        }

        add(new JScrollPane(textArea));
    }
}