package logica;

import java.util.HashSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import datos.ImportarDiccionario;

public class Diccionario {
	private HashSet<String> palabras;
	private Random random;
	private EleccionIdioma idioma;

	public Diccionario(EleccionIdioma idioma) throws IOException {
		this.random = new Random();
		this.idioma = idioma;
		this.palabras = ImportarDiccionario.cargarDesdeArchivo(idioma.getNombreArchivo());
	}
    
	
	// genera una palabra aleatoria. aunque los hashset son muy rapidos para recorrer arreglos
	// no se puede acceder por indice. se pasa a arraylist y se le da un indice aleatorio.
	public String obtenerPalabraAleatoria() {
		List<String> listaTemporal = new ArrayList<>(this.palabras);
		int indice = random.nextInt(listaTemporal.size());
		return listaTemporal.get(indice);
	}
	
	// agrego el metodo para validar si una palabra existe en el diccionario, 
	// lo uso en el juego para validar que el usuario ingrese palabras validas.
	
	public boolean esValida(String palabraIngresada) {
		if (palabraIngresada == null || palabraIngresada.length() != 5) {
			return false;
		}
		return this.palabras.contains(palabraIngresada.toUpperCase());		
	}
}