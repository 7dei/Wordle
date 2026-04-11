package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.JuegoController;
import logica.EleccionDificultad;
import logica.EleccionIdioma;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuSecundarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public MenuSecundarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<EleccionIdioma> idiomaComboBox = new JComboBox(EleccionIdioma.values());
		idiomaComboBox.setBounds(151, 58, 115, 22);
		contentPane.add(idiomaComboBox);
		
		JComboBox<EleccionDificultad> dificultadComboBox = new JComboBox(EleccionDificultad.values());
		dificultadComboBox.setBounds(151, 111, 115, 22);
		contentPane.add(dificultadComboBox);
		
		JButton volver = new JButton("volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new MenuView().setVisible(true);  //vuelve a MenuView
				 dispose();
			}
		});
		volver.setBounds(166, 195, 89, 23);
		contentPane.add(volver);
		
		JButton Jugar = new JButton("Jugar");
		Jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EleccionDificultad dificultad = (EleccionDificultad) dificultadComboBox.getSelectedItem();
				EleccionIdioma idioma = (EleccionIdioma) idiomaComboBox.getSelectedItem();
				
				new JuegoController(dificultad, idioma);

			    dispose();
			}
		});
		Jugar.setBounds(166, 161, 89, 23);
		contentPane.add(Jugar);

	}
	

}
