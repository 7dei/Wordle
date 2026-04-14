package logica;

public enum EleccionDificultad {
	
	
	// lo escrito entre parentesis indica cuantos intentos hay segun dificultad
	
	FACIL(6),
	INTERMEDIO(5),
	DIFICIL(4);
	
	private int intentosMaximos;
	
	EleccionDificultad(int intentosMaximos) {
		this.intentosMaximos = intentosMaximos;
	}
	
	public int getIntentosMaximos() {
		return this.intentosMaximos;
	}
	
}
