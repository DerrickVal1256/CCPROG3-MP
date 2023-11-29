package Model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Objects;

/**
 * This class is responsible for playing sound effects in the game.
 */
public class Sound {

    private static Sound instance;
    private MediaPlayer mediaPlayer;

    private Sound() {
        this.mediaPlayer = null;
    }

    public static synchronized Sound getInstance() {
        if (instance == null) {
            instance = new Sound();
        }
        return instance;
    }

    /**
     * Plays a sound effect.
     *
     * @param strFileName The name of the sound effect to play.
     * @param nCycleCount The number of cycles to play the sound (use -1 for indefinite).
     */
    public void play(String strFileName, int nCycleCount) {
        String strPath = Objects.requireNonNull(getClass().getResource(strFileName)).getPath();
        Media media = new Media(new File(strPath).toURI().toString());

        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        mediaPlayer = new MediaPlayer(media);

        if (nCycleCount == -1) {
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        } else {
            mediaPlayer.setCycleCount(nCycleCount);
        }

        mediaPlayer.play();
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    /**
     * Stops the current sound effect.
     */
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
