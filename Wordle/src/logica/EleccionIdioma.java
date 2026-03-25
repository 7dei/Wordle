package logica;

public enum EleccionIdioma {
	
	// lo escrito entre parentesis le indica a que archivo .txt acceder segun el respectivo
	// idioma
	
	INGLES("src/datos/words_en.txt"), //ingles
	ESPANOL("src/datos/words_es.txt"), //espanol
	PORTUGUES("src/datos/words_pt.txt"), //portugues
	ITALIANO("src/datos/words_it.txt"), //italiano
	FRANCES("src/datos/words_fr.txt");  //frances

	private String nombreArchivo;
	
	EleccionIdioma(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}
	
}
