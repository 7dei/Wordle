package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import logica.EleccionDificultad;
import logica.EleccionIdioma;
import logica.Juego;
import logica.ResultadoIntento;
import view.JuegoView;

public class JuegoController {

    private Juego juego;
    private JuegoView view;

    public JuegoController(EleccionDificultad dificultad, EleccionIdioma idioma) {
    	
        
    	try {
    		this.juego = new Juego(dificultad, idioma);
    		this.view = new JuegoView(juego.getIntentosRestantes());
    		view.setController(this);
    		iniciar();
    	}catch (IOException e) {
    		e.printStackTrace();
    	    JOptionPane.showMessageDialog(null, "Error al iniciar el juego");//esto es correcto? que el controller conozca joptionPane?
        }
    }

    public void iniciar() {
        view.mostrar();
    }

    // recibe el input, actualiza la vista y maneja errores
    public void ingresar(String palabra) {
        try {
        	
        	ResultadoIntento res = juego.ingresar(palabra);
        	
        	view.mostrarResultado(res, palabra.toCharArray(), juego.getPalabraSecreta());
        	
            if (juego.gano()) {
                view.mostrarMensaje("Ganaste");
            } else if (juego.perdio()) {
                view.mostrarMensaje("Perdiste. La palabra era: " + juego.getPalabraSecreta());
            }

        } catch (IllegalArgumentException e) {
            view.mostrarMensaje(e.getMessage());
        }
    }
}