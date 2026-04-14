package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Juego;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;

public class InfoMenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public InfoMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuView().setVisible(true);  //vuelve a MenuView
				dispose();
			}
		});
		btnNewButton.setBounds(171, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblLabelTitulo = new JLabel("INFORMACION WORDLE\n");
		lblLabelTitulo.setFont(new Font("Dialog", Font.BOLD, 21));
		lblLabelTitulo.setBounds(60, 0, 364, 17);
		contentPane.add(lblLabelTitulo);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 11));
		textArea.setBackground(contentPane.getBackground());
		textArea.setBounds(12, 27, 426, 196);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setText(Juego.informacion());
		contentPane.add(textArea);
		
	}
}
