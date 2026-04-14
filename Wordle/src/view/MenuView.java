package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}///BORRAR

	/**
	 * Create the frame.
	 */
	public MenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton empezar = new JButton("Empezar");
		empezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuSecundarioView().setVisible(true); // abre la menuSecundarioView
			    dispose();                                 // cierra la actual
			}
		});
		empezar.setBounds(161, 60, 89, 23);
		contentPane.add(empezar);
		
		JButton ranking = new JButton("Ranking");
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RankingView().setVisible(true);
				dispose();
			}
		});
		ranking.setBounds(161, 104, 89, 23);
		contentPane.add(ranking);
		
		JButton info = new JButton("Info");
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InfoMenuView().setVisible(true); // abre la info como jugar
			    dispose();                           // cierra la actual
			}
		});
		info.setBounds(161, 149, 89, 23);
		contentPane.add(info);

	}
}
