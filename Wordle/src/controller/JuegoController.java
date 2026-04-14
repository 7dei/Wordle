package controller;

import logica.Juego;
import logica.ResultadoIntento;
import view.JuegoView;

import logica.Ranking;

import util.SoundPlayer;

public class JuegoController {

    private Juego juego;
    private JuegoView view;

    public JuegoController(Juego juego, JuegoView view) {
        this.juego = juego;
        this.view = view;
        this.view.setController(this);
    }

    public void iniciar() {
    	SoundPlayer.reproducir("/sonidos/start.wav");
        view.mostrar();
    }

    public void ingresar(String palabra) {
        try {
        	SoundPlayer.reproducir("/sonidos/click.wav");
        	
            ResultadoIntento res = juego.ingresar(palabra);

            view.mostrarResultado(res, palabra.toCharArray());

            if (juego.gano()) {
            	SoundPlayer.reproducir("/sonidos/win.wav");
                view.mostrarMensaje("Ganaste");

                String nombre = view.pedirNombre();

                if (nombre != null && !nombre.isEmpty()) {
                    int intentosUsados = juego.getIntentos().size();
                    long tiempo = juego.getTiempoPartida();

                    Ranking.guardarJugador(nombre, intentosUsados, tiempo);
                }

                view.deshabilitarEntrada();
            } else if (juego.perdio()) {
            	SoundPlayer.reproducir("/sonidos/lose.wav");
                view.mostrarMensaje("Perdiste. La palabra era: " + juego.getPalabraSecreta());
                view.deshabilitarEntrada();
            }

        } catch (IllegalArgumentException e) {
            view.mostrarMensaje(e.getMessage());
        }
    }
    
    public void volverAlMenu() {
        view.dispose();              			// cierra la ventana actual
        new view.MenuView().setVisible(true); 	// abre el menu principal
    }
}