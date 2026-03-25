package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logica.Diccionario;

public class Juego {
	
	private String palabraSecreta;
	private int intentosMaximos;
	private List<String> intentosPrevios;
	private Diccionario diccionario;
	private boolean victoria;
	
	public Juego(EleccionDificultad dificultad, EleccionIdioma idioma) throws IOException {
		this.intentosMaximos = dificultad.getIntentosMaximos();
		this.diccionario = new Diccionario(idioma);
		this.palabraSecreta = diccionario.obtenerPalabraAleatoria();
		this.intentosPrevios = new ArrayList<>();
		this.victoria = false;
	}
	
}
