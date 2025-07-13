package com.dombummel;

import java.awt.*;
import java.io.InputStream;

public class Fonterly {
	public static Font load(String path, float size) {
		try {
			InputStream stream = Fonterly.class.getResourceAsStream(path);
			if(stream == null) {
				System.err.println("Font not found: " + path);
				return new Font("SansSerif", Font.PLAIN, (int) size);
			}
			Font font = Font.createFont(Font.TRUETYPE_FONT, stream);
			return font.deriveFont(size);
		} catch(Exception e) {
			e.printStackTrace();
			return new Font("SansSerif", Font.PLAIN, (int) size);
		}
	}
}
