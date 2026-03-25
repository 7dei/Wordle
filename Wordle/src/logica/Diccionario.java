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
	private String idiomaActual;

	public Diccionario() throws IOException {
		this.random = new Random();
		this.idiomaActual = "ingles";
		this.palabras = ImportarDiccionario.cargarDesdeArchivo("src/datos/words.txt");
	}
    
}