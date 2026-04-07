package controller;

import logica.Juego;
import logica.ResultadoIntento;
import view.JuegoView;

public class JuegoController {

    private Juego juego;
    private JuegoView view;

    public JuegoController(Juego juego, JuegoView view) {
        this.juego = juego;
        this.view = view;
        view.setController(this);
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