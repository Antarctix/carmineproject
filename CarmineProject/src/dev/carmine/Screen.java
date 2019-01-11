/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.carmine;

import java.awt.Graphics;

/**
 *
 * @author nate
 */
public abstract class Screen {
    
    private static Screen currentScreen = null;
    
    public static void setScreen(Screen screen){
        currentScreen = screen;
    }
    
    public static Screen getScreen(){
        return currentScreen;
    }
    
    
    
    
    //Render sections
    protected game game;
    
    public Screen(game game){
        this.game = game;
    }

    public abstract void render(Graphics g);
 
}
