import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class Sound {
    private URL CUrl;
    private Clip CClip;

    public Sound(String strRequestedSound) {
        CUrl = this.getClass().getResource(strRequestedSound);
        if(CUrl != null) {
            try {
               AudioInputStream audioInput = AudioSystem.getAudioInputStream(CUrl);
            CClip = AudioSystem.getClip();
            CClip.open(audioInput); 
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void play(){
        this.CClip.setFramePosition(0);
        this.CClip.start();
    }
}
