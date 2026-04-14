package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Diccionario {
 
 private HashSet<String> palabras;
 private Random random;
 private EleccionIdioma idioma;

 public Diccionario(EleccionIdioma idioma) throws IOException {
  this.random = new Random();
  this.setIdioma(idioma);
  this.palabras = cargarDesdeArchivo(idioma.getNombreArchivo());
 }
    
 // valida si una palabra existe en el diccionario.
  public boolean esValida(String palabraIngresada) {
   if (palabraIngresada == null || palabraIngresada.length() != 5) {
    return false;
   }
   return this.palabras.contains(palabraIngresada.toUpperCase());  
  }

 public String obtenerPalabraAleatoria() {
  List<String> listaTemporal = new ArrayList<>(this.palabras);
  int indice = random.nextInt(listaTemporal.size());
  return listaTemporal.get(indice);
 }
 
 // importa las palabras de los archivos .txt y los guarda en un hashset para
 // un acceso rapido, ademas evitando duplicados. 
 public HashSet<String> cargarDesdeArchivo(String rutaArchivo) throws IOException {
  HashSet<String> palabrasCargadas = new HashSet<>();  
  String linea;
  
  try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
   while ((linea = br.readLine()) != null) {
    
    String palabra = linea.trim().toUpperCase();
    if (palabra.length() == 5) {
     palabrasCargadas.add(palabra);
    }
   }
  } catch (IOException e) {
   System.err.println("Error al cargar el documento: " + e.getMessage());
  }
  return palabrasCargadas; 
 }

public EleccionIdioma getIdioma() {
	return idioma;
}

public void setIdioma(EleccionIdioma idioma) {
	this.idioma = idioma;
}
}