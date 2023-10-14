import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class Sound {
    private URL CUrl;
    private Clip CClip;

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

    public void stop(){
        this.CClip.stop();
    }
}