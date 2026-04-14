package logica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ranking {

    private static final String ARCHIVO = "ranking.txt";

    public static void guardarJugador(String nombre, int intentosUsados, long tiempo) {
    	// FileWriter en modo append para no sobrescribir datos
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO, true))) {
        	pw.println(nombre + " - " + intentosUsados + " intentos - " + formatearTiempo(tiempo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String obtenerMejorTiempo() {
        long mejor = Long.MAX_VALUE;
        String mejorJugador = "";

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" - ");

                long tiempo = Long.parseLong(partes[2].replace("s", "").replace(".", ""));

                if (tiempo < mejor) {
                    mejor = tiempo;
                    mejorJugador = partes[0];
                }
            }

        } catch (Exception e) {
            return "Sin datos";
        }

        return mejorJugador + " con " + mejor + " ms";
    }
    
    // traduce el tiempo en segundos (no en ms)
    private static String formatearTiempo(long ms) {
        long segundos = ms / 1000;
        long restoMs = ms % 1000;

        return segundos + "." + (restoMs / 100) + "s";
    }
}