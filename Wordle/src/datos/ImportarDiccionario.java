package datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ImportarDiccionario {

	public HashSet<String> cargar(String rutaArchivo) throws IOException {
		
		HashSet<String> palabras = new HashSet<>();		
		String linea;
		FileReader archivo = new FileReader(rutaArchivo);
		
		try (BufferedReader br = new BufferedReader(archivo)) {
			while ((linea = br.readLine()) != null) {
				String palabra = linea.trim().toUpperCase();
				palabras.add(palabra);
			} 	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return palabras; 
	}
}
