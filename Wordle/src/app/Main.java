package app;


import logica.Juego;
import logica.Diccionario;
import logica.EleccionDificultad;
import logica.EleccionIdioma;

import view.JuegoView;
import view.MenuView;
import controller.JuegoController;

import java.awt.EventQueue;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// esta hecho ahora exclusivamente para testear por consola los outputs.
		//Diccionario diccionario = new Diccionario(EleccionIdioma.INGLES);
		//System.out.print(diccionario.obtenerPalabraAleatoria());
		
        /*Juego juego = new Juego(EleccionDificultad.DIFICIL,EleccionIdioma.INGLES);
       
        JuegoView view = new JuegoView(juego.getIntentosRestantes());
        JuegoController controller = new JuegoController(juego, view);
        
        controller.iniciar();*/
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
	}
}
