/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pong;

import org.lwjgl.opengl.Display;

/**
 *
 * @author Mikhail
 */
public class GOPlayer extends GameObject{
    
    public static final int SIZEX = 16;
    public static final int SIZEY = SIZEX * 7;
    public static final float SPEED = 4f;
    private GOBall ball;
    
    public GOPlayer(float x, float y, GOBall ball){
        this.x = x;
        this.y = y;
        this.width = SIZEX;
        this.height = SIZEY;
        this.ball = ball;
    }
    
    @Override
    public void update(){
        if(Physics.checkGoal(ball)){
            this.reset();
        }
        if(Physics.checkCollisions(this, ball)){
            ball.reverseX(getCenterY());
        }
    }
    
    public void move(float dist){
        if(!Physics.topWallCollision(this) && !Physics.bottomWallCollision(this)){        
            y += SPEED * dist;
        }
        else{
            if(Physics.topWallCollision(this)){
                y -= 1;
            }
            if(Physics.bottomWallCollision(this)){
                y += 1;
            }
        }
    }
    
    @Override
    public void reset(){
        this.x = 0;
        this.y = Display.getHeight()/2 - GOPlayer.SIZEY/2;
    }
}
