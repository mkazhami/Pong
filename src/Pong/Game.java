/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pong;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Mikhail
 */
public class Game {
    public static int P1Score = 0;
    public static int P2Score = 0;
    private ArrayList<GameObject> objects; 
    private GOPlayer player;
    
    public Game(){
        Display.setTitle("PONG");
        objects = new ArrayList<GameObject>();        
        GOBall ball = new GOBall(Display.getWidth() / 2 - GOBall.SIZE / 2, Display.getHeight() / 2 - GOBall.SIZE / 2);
        player = new GOPlayer(0,Display.getHeight()/2 - GOPlayer.SIZEY/2, ball);
        GOEnemy enemy = new GOEnemy(Display.getWidth() - GOEnemy.SIZEX, Display.getHeight() / 2 - GOPlayer.SIZEY / 2, ball);
        objects.add(ball);
        objects.add(player);
        objects.add(enemy);
    }
    
    public void getInput(){
        if(Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W)){
            player.move(1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S)){
            player.move(-1);
        }
    }
    
    public void update(){
        for(GameObject go : objects){
            go.update();
        }
    }
    
    public void render(){
        
        for(GameObject go : objects){
            go.render();
        }
    }
}
