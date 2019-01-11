/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.carmine.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author nate
 */
public class mouseInput extends MouseAdapter {

    private int mouseX, mouseY;
    public boolean clicked = false;

    public int getX() {
        return mouseX;
    }

    public int getY() {
        return mouseY;
    }

    public boolean clicked() {
        return clicked;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clicked = true;
        System.out.println(e.getX() + ", " + e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}
