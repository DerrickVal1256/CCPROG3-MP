import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

/**
* This class is responsible for playing sound effects in the game.
*/
public class Sound {
    private URL CUrl;
    private Clip CClip;

    /**
     * Plays a sound effect.
     * @param strRequestedSound The name of the sound effect to play.
     */
    public void play(String strRequestedSound){
        this.CUrl = this.getClass().getResource(strRequestedSound);
        if(this.CUrl != null) {
            try {
               AudioInputStream audioInput = AudioSystem.getAudioInputStream(CUrl);
                this.CClip = AudioSystem.getClip();
                this.CClip.open(audioInput); 
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }
        this.CClip.start(); 
    }

    /**
     * Returns the current Clip.
     * @return The current Clip.
     */
    public Clip getClip() {
        return this.CClip;
    }

    /**
     * Stops the current sound effect.
     */
    public void stop(){
        this.CClip.stop();
    }
}