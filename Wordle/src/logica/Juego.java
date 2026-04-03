package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import logica.Intento;
import logica.ResultadoIntento;
import logica.ResultadoLetra;

public class Juego {
	
    private String palabraSecreta;
    private int intentosRestantes;
    private List<Intento> intentos;
    private Set<String> palabrasIntentadas;
    private Diccionario diccionario; 
    private boolean juegoTerminado;	
	
    public Juego(//EleccionDificultad dificultad (Lo comente ahora, hasta que pensemos si
    		//agregar la dificultad o no.
    		EleccionIdioma idioma) throws IOException {
    	
 //       this.intentosRestantes = dificultad.getIntentosMaximos(); 
    	
        this.diccionario = new Diccionario(idioma);
        this.palabraSecreta = diccionario.obtenerPalabraAleatoria().toLowerCase();
        
        this.intentos = new ArrayList<>(); 
        this.palabrasIntentadas = new HashSet<>();
        this.juegoTerminado = false;
    }

    public ResultadoIntento ingresar(String palabra) {
        validarEstadoJuego();
        palabra = palabra.toLowerCase(); 
        validarPalabra(palabra);

        if (palabrasIntentadas.contains(palabra)) {
            throw new IllegalArgumentException("Ya ingresaste esa palabra");
        }

        palabrasIntentadas.add(palabra);

        List<ResultadoLetra> resultado = evaluarPalabra(palabra);

        Intento intento = new Intento(palabra, resultado);
        intentos.add(intento);
        intentosRestantes--;

        if (palabra.equals(palabraSecreta) || intentosRestantes == 0) {
            juegoTerminado = true;
        }

        return new ResultadoIntento(resultado);
    }
	    
    private void validarEstadoJuego() {
        if (juegoTerminado) {
            throw new IllegalStateException("El juego ya terminó");
        }
    }

    private void validarPalabra(String palabra) {
        if (palabra == null || palabra.length() != 5) {
            throw new IllegalArgumentException("La palabra debe tener 5 letras");
        }

        if (!diccionario.esValida(palabra)) {
        	throw new IllegalArgumentException("La palabra ingresada no existe en el diccionario");
        }
        }
  //  }

    private List<ResultadoLetra> evaluarPalabra(String palabra) {
        List<ResultadoLetra> resultado = new ArrayList<>();
        for (int i = 0; i < palabra.length(); i++) {
            resultado.add(null); 
        }

        char[] secreta = palabraSecreta.toCharArray();
        char[] intento = palabra.toCharArray();
        boolean[] usados = new boolean[5];

        for (int i = 0; i < 5; i++) {
            if (intento[i] == secreta[i]) {
                resultado.set(i, ResultadoLetra.CORRECTA);
                usados[i] = true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (resultado.get(i) == null) {
                boolean encontrada = false;
                for (int j = 0; j < 5; j++) {
                    if (!usados[j] && intento[i] == secreta[j]) {
                        encontrada = true;
                        usados[j] = true;
                        break;
                    }
                }

                if (encontrada) {
                    resultado.set(i, ResultadoLetra.PRESENTE);
                } else {
                    resultado.set(i, ResultadoLetra.AUSENTE);
                }
            }
        }
        return resultado;
    }

    public boolean gano() {
        if (intentos.isEmpty()) return false;
        Intento ultimo = intentos.get(intentos.size() - 1);
        return ultimo.getPalabra().equals(palabraSecreta);
    }

    public boolean perdio() {
        return juegoTerminado && !gano();
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public List<Intento> getIntentos() {
        return new ArrayList<>(intentos); 
    }

    public String getPalabraSecreta() {
        if (!juegoTerminado) {
            throw new IllegalStateException("El juego todavía no terminó");
        }
        return palabraSecreta;
    }
}