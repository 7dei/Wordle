package datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ImportarDiccionario {

	//Recibe el .txt, lo lee, lo filtra,limpia cada linea y lo devuelve en forma de set.
	public static HashSet<String> cargarDesdeArchivo(String rutaArchivo) throws IOException {
		
		HashSet<String> palabras = new HashSet<>();		
		String linea;
		FileReader archivo = new FileReader(rutaArchivo);
		
		try (BufferedReader br = new BufferedReader(archivo)) {
			
			while ((linea = br.readLine()) != null) {
				String palabra = linea.trim().toUpperCase();
				if (palabra.length() == 5){palabras.add(palabra);}
			}
			
		}
		catch (IOException e) {
			System.err.println("Error al cargar el documento." + e.getMessage());
		}
		return palabras; 
	}
}
