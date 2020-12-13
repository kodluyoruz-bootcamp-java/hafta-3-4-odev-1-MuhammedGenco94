package com.kodluyoruz.homework3.utils.models;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LocalKeyListener implements KeyListener {

    private boolean isPressed;

    private JFrame frame = new JFrame();

    public LocalKeyListener() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public boolean isPressed() {
        return isPressed;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X) {
            System.exit(-1);
            isPressed= true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
