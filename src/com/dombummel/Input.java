package com.dombummel;

import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

public class Input {
	private static final Set<Integer> keysDown = new HashSet<>();
	private static final Set<Integer> mouseButtonsDown = new HashSet<>();
	private static final Set<Integer> justPressedKeys = new HashSet<>();

	private static int mouseX = 0;
	private static int mouseY = 0;

	public static void register(JComponent component) {
		component.setFocusable(true);

		component.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (!keysDown.contains(code)) {
					justPressedKeys.add(code);
				}
				keysDown.add(code);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				keysDown.remove(e.getKeyCode());
			}
		});

		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseButtonsDown.add(e.getButton());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseButtonsDown.remove(e.getButton());
			}
		});

		component.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
	}

	public static boolean isKeyDown(int keyCode) {
		return keysDown.contains(keyCode);
	}

	public static boolean isMouseDown(int button) {
		return mouseButtonsDown.contains(button);
	}
	
	public static void update() {
		justPressedKeys.clear();
	}
	
	public static boolean isKeyJustPressed(int keyCode) {
		return justPressedKeys.contains(keyCode);
	}

	public static int getMouseX() {
		return mouseX;
	}

	public static int getMouseY() {
		return mouseY;
	}
}
