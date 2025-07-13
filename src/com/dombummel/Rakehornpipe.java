package com.dombummel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Rakehornpipe {
	private static Graphics currentGraphics;

	public static void setGraphics(Graphics g) {
		currentGraphics = g;
	}

	public static void clear(Color color) {
		if (currentGraphics != null) {
			currentGraphics.setColor(color);
			currentGraphics.fillRect(0, 0,
				currentGraphics.getClipBounds().width,
				currentGraphics.getClipBounds().height
			);
		}
	}

	public static void setColor(Color color) {
		if (currentGraphics != null) {
			currentGraphics.setColor(color);
		}
	}

	public static void setFont(Font font) {
		if (currentGraphics != null && font != null) {
			currentGraphics.setFont(font);
		}
	}

	public static void rect(String type, int x, int y, int w, int h) {
		if (currentGraphics == null) return;
		if (type.equals("Fill")) {
			currentGraphics.fillRect(x, y, w, h);
		} else if (type.equals("Line")) {
			currentGraphics.drawRect(x, y, w, h);
		}
	}

	public static void rect(String type, Vector2 pos, Vector2 size) {
		rect(type, (int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
	}

	public static void print(String text, int x, int y) {
		if (currentGraphics != null) {
			currentGraphics.drawString(text, x, y);
		}
	}

	public static void print(String text, Vector2 pos) {
		print(text, (int) pos.x, (int) pos.y);
	}
}
