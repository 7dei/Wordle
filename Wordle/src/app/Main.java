package app;


import logica.Juego;
import logica.Diccionario;
import logica.EleccionIdioma;

import view.JuegoView;
import controller.JuegoController;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// esta hecho ahora exclusivamente para testear por consola los outputs.
		Diccionario diccionario = new Diccionario(EleccionIdioma.INGLES);
		System.out.print(diccionario.obtenerPalabraAleatoria());
		
        Juego juego = new Juego(EleccionIdioma.INGLES);
        JuegoView view = new JuegoView();
        JuegoController controller = new JuegoController(juego, view);
        
        controller.iniciar();
	}
}
