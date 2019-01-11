/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.carmine.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author nate
 */
public class Assets {

    public static BufferedImage sword, spell, bag, logo;

    public static void init() {
    //Images Loading

        sword = ImageLoader.loadImage("/textures/sword.png");
        spell = ImageLoader.loadImage("/textures/spell.png");
        bag = ImageLoader.loadImage("/textures/bag.png");
        logo = ImageLoader.loadImage("/textures/logo.png");

    }

}
