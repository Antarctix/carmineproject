/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.carmine;

import dev.carmine.display.display;
import dev.carmine.gfx.Assets;
import dev.carmine.input.keyInput;
import dev.carmine.input.mouseInput;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import static java.awt.event.KeyEvent.VK_1;
import java.util.Random;

/**
 *
 * @author nate
 */
public class game implements Runnable {

    private display display;
    public static int width, height;
    public String title;

    private boolean running = false;

    private Graphics g;
    private mouseInput mouseInput;
    private keyInput keyInput;
    private int mouseX, mouseY;

    //Stat Variables
    public int health = 10;
    public int attack = 5;
    public int defense = 1;
    public int speed = 2;
    
    public game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        
        mouseInput = new mouseInput();
        keyInput = new keyInput();
    }

    //Intializes game
    private void init() {
        display = new display(title, width, height);
        Assets.init();
        g = display.getCanvas().getGraphics();

        //MouseInput
        display.getFrame().addMouseListener(mouseInput);
        display.getCanvas().addMouseListener(mouseInput);
        display.getFrame().addKeyListener(keyInput);
        display.getCanvas().addKeyListener(keyInput);
    }

    //Menu for selecting
    public void menu(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        //Draws logo and start/setting button
        g.drawImage(Assets.logo, 0, 0, null);
        g.setColor(Color.yellow);
        g.fillRect(175, 550, 150, 50);
        g.fillRect(175, 650, 150, 50);
        g.setColor(Color.BLACK);
        g.drawString(" Start ", 230, 580);
        g.drawString("Settings", 225, 680);
       
        
        mouseX = mouseInput.getX();
        mouseY = mouseInput.getY();
       while (true) {
            if (mouseX >= 175 && mouseX <= 325 && mouseY >= 550 && mouseY <= 600) {
                System.out.print(mouseX + ", " + mouseY);
                break;
            }
        }
    }
    
    //Renders the menu selection to grind mobs
    public void render(Graphics g){
        g.setFont(new Font("Palatino Linotype", Font.BOLD, 50));
        g.drawString("1. Pig", 10, 50);
        g.drawString("2. Bat", 10, 100);
        g.drawString("3. Neha", 10, 150);
        g.drawString("4. Ward", 10, 200);
        
        
        
    }
    
    

    //Renders images onto canvas
    public void battle(Graphics g) {
        //Battle Sequence
        //Draw Begins
        g.setColor(Color.BLACK);
        g.drawLine(0, height - 200, width, height - 200);
        g.fillRect(1, height - 200, width, height - 200);
        g.drawImage(Assets.sword, 500 / 3 - 150, height - 150, null);
        g.drawImage(Assets.bag, 200, height - 150, null);
        g.drawImage(Assets.spell, 375, height - 150, null);

        //End of Drawing
        pigB(g);
    }

    //Generic pig fight
    public void pigB(Graphics g) {
        int pigHealth = 5;
        int pigAttack = 1;
        int pigDefense = 1;
        int pigSpeed = 1;
        char c = 0;

        printHealth(health, pigHealth, g);

        //Continues to run as long as pigHealth and health are > 0
        while (pigHealth > 0 && health > 0) {
            c = 0;
            c = keyInput.getChar();
            if (speed > pigSpeed) {
                g.drawString("", 0, 0);

                //Basic attack occurs
                if (c == VK_1 || c == '1') {
                    pigHealth -= dmg(attack, pigDefense);

                    //Once pighealth reaches 0, the loop ends
                    if (pigHealth <= 0) {
                        pigHealth = 0;
                        printHealth(health, pigHealth, g);
                        break;
                    }
                    printHealth(health, pigHealth, g);
                    //Pig attacks
                    health -= dmg(pigAttack, defense);
                    printHealth(health, pigHealth, g);
                }
            }
        }
    }

    //Damage method
    public int dmg(int attack, int defense) {
        Random rand = new Random();

        //Maximum damage possible
        int max, total;

        //Sets maximum damage possible and error catches if defense and attack are equal (meaning it would do 1 dmg minimum);
        max = (attack - defense);
        if (max <= 0) {
            max = 1;
        }

        //Gets a random value within the parameters to deal damage
        total = rand.nextInt(max) + 1;
        System.out.println(total);

        return total;
    }

    //Reprint Health Function
    public void printHealth(int health, int mobHealth, Graphics g) {
        g.clearRect(0, 0, 400, 500);
        g.drawString("Pig's Health: " + mobHealth, 300, 100);
        g.drawString("Health: " + health, 100, 500);

    }

//Runs game
    public void run() {

        init();

        if (running) {
            render(g);
            //battle(g);
            //menu(g);
        }

        stop();
    }

    //Starts and stops threads
    public synchronized void start() {
        running = true;
        run();
    }

    public synchronized void stop() {
        running = false;
    }

    //Get height and width methods
    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

}
