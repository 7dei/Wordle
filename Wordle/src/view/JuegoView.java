package view;
//revisar los import
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.JuegoController;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.ResultadoIntento;
import logica.ResultadoLetra;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

public class JuegoView extends JFrame {
	
	
	private JTextField[][] casillas;
    private int filaActual = 0;
    private final int FILAS;
    private final int COLUMNAS = 5;

	private static final long serialVersionUID = 1L;
	private JPanel panelGeneral;
	private JTextField textField;

	private JuegoController controller;
	private JLabel lblMensaje;
	private JPanel panelGrilla;

	public void setController(JuegoController controller) {
	    this.controller = controller;
	}

	public JuegoView(int filas) {
		this.FILAS=filas;
		setTitle("Wordle Programacion III"); //agregado
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 463);

		panelGeneral = new JPanel();
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelGeneral);
		panelGeneral.setLayout(null);

		textField = new JTextField();
		textField.setBounds(81, 44, 86, 20);
		textField.setColumns(10);
		panelGeneral.add(textField);

		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setBounds(76, 94, 115, 23);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String intento = textField.getText();
				controller.ingresar(intento);
			}
		});
		panelGeneral.add(btnIngresar);
		
		lblMensaje = new JLabel("");
		lblMensaje.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMensaje.setToolTipText("");
		lblMensaje.setBackground(new Color(192, 192, 192));
		lblMensaje.setBounds(20, 240, 220, 24);
		panelGeneral.add(lblMensaje);
		
		
		panelGrilla = new JPanel(); //agregado
		panelGrilla.setBounds(268, 69, 268, 325);
		panelGeneral.add(panelGrilla);
		panelGrilla.setLayout(new GridLayout(FILAS, COLUMNAS, 5, 5));
		casillas = new JTextField[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                JTextField tf = new JTextField();
                tf.setHorizontalAlignment(JTextField.CENTER);
                tf.setFont(new Font("Arial", Font.BOLD, 20));
                casillas[i][j] = tf;
                panelGrilla.add(tf);
            }
        }
		
		
	}

	// ------------------------------- METODOS PARA EL CONTROLLER ---------------------------------

	public void mostrar() {
		this.setVisible(true);
	}

	
	public void mostrarResultado(ResultadoIntento resultado, char[] letrasPalabra, String palabra) {
		
		
		int cont=0;
		for (ResultadoLetra res : resultado.getResultado()) {
			switch (res) {
			case CORRECTA:
				casillas[filaActual][cont].setBackground(Color.green);
				casillas[filaActual][cont].setText(letrasPalabra[cont]+"");	// VERDE
				break;
			case PRESENTE:
				casillas[filaActual][cont].setBackground(Color.yellow);
				casillas[filaActual][cont].setText(letrasPalabra[cont]+"");	// AMARILLO
				break;
			case AUSENTE:
				casillas[filaActual][cont].setBackground(Color.gray);
				casillas[filaActual][cont].setText(letrasPalabra[cont]+"");	// GRIS
				break;
			}
			cont++;
			
	        }
		filaActual++;

      
	}

	public void mostrarMensaje(String mensaje) {
		lblMensaje.setText(mensaje);
	}
}