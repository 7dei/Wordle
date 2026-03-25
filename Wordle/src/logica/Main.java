package logica;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// esta hecho ahora exclusivamente para testear por consola los outputs.
		Diccionario diccionario = new Diccionario(EleccionIdioma.INGLES);
		System.out.print(diccionario.obtenerPalabraAleatoria());
	}
}
