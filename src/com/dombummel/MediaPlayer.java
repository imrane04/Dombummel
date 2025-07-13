package com.dombummel;

import javax.sound.sampled.*;
import java.io.InputStream;
import java.util.HashMap;

public class MediaPlayer {

	private static final HashMap<String, Clip> cache = new HashMap<>();

	public static void play(String path) {
		try {
			Clip clip = loadClip(path);
			if (clip != null) {
				clip.setFramePosition(0);
				clip.start();
			}
		} catch (Exception e) {
			System.err.println("Failed to play sound: " + path);
			e.printStackTrace();
		}
	}

	public static Clip loop(String path) {
		try {
			Clip clip = loadClip(path);
			if (clip != null) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				return clip;
			}
		} catch (Exception e) {
			System.err.println("Failed to loop sound: " + path);
			e.printStackTrace();
		}
		return null;
	}

	public static void stop(Clip clip) {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.setFramePosition(0);
		}
	}

	private static Clip loadClip(String path) throws Exception {
		if (cache.containsKey(path)) return cache.get(path);

		InputStream in = MediaPlayer.class.getResourceAsStream(path);
		if (in == null) {
			System.err.println("Missing sound file: " + path);
			return null;
		}

		AudioInputStream audio = AudioSystem.getAudioInputStream(in);
		Clip clip = AudioSystem.getClip();
		clip.open(audio);
		cache.put(path, clip);
		return clip;
	}
}
