package lib.resources;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	public static synchronized void playTitleMusic() {

		try {
			Clip clip = AudioSystem.getClip();
			InputStream audioSrc = Sound.class.getClassLoader().getResourceAsStream("media/title.wav");
			InputStream bufferIn = new BufferedInputStream(audioSrc);
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferIn);
			clip.open(inputStream);
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}