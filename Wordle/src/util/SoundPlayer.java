package util;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {

    public static void reproducir(String ruta) {
        try {
            URL url = SoundPlayer.class.getResource(ruta);

            if (url == null) {
                System.out.println("No se encontró el sonido: " + ruta);
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}