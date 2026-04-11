package logica;

public enum EleccionIdioma {
	
	// lo escrito entre parentesis le indica a que archivo .txt acceder segun el respectivo
	// idioma
	
	
	ESPANOL("words_es.txt"), //espanol
	PORTUGUES("words_pt.txt"), //portugues
	INGLES("words_en.txt");//ingles
	
	private String nombreArchivo;
	
	EleccionIdioma(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}
}
