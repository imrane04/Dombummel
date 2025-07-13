package com.dombummel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Winclip {
	public static BufferedImage load(String path) {
		try {
			var stream = Winclip.class.getResourceAsStream(path);
			if (stream == null) {
				System.err.println("Image not found: " + path);
				return null;
			}
			return javax.imageio.ImageIO.read(stream);
		} catch (Exception e) {
			System.err.println("Failed to load image: " + path);
			e.printStackTrace();
			return null;
		}
	}

	public static void draw(Graphics g, BufferedImage img, int x, int y) {
		if (g != null && img != null) {
			g.drawImage(img, x, y, null);
		}
	}
}
