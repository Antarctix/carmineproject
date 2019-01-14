/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.carmine.input;

import dev.carmine.game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author nate
 */
public class keyInput extends KeyAdapter {

    private char c;
    private boolean key = false;

    public char getChar() {  
        
        return c;
    }
    
    public boolean getKey(){
        return key;
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        c = e.getKeyChar();
        key = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        c = 0;
        key = false;
    }

}
