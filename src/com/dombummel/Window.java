package com.dombummel;

import javax.swing.*;

import com.dombummel.*;

import java.awt.*;

@SuppressWarnings("unused")
public class Window extends JFrame {
    private static final long serialVersionUID = 1L;
    private static Painterly drawCallback;
    private static GameLoop updateCallback;

    public Window(int width, int height, String title) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Rakehornpipe.setGraphics(g);
                if (drawCallback != null) {
                    drawCallback.draw(g);
                }
            }
        };

        Input.register(panel);
        setContentPane(panel);
        setVisible(true);

        new Timer(1000 / 60, e -> {
            Input.update();

            if (updateCallback != null) {
                updateCallback.update();
            }

            repaint();
        }).start();
    }

    public static void setDrawCallback(Painterly d) {
        drawCallback = d;
    }

    public static void setUpdateCallback(GameLoop u) {
        updateCallback = u;
    }
}
