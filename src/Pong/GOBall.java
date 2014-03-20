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
public class GOBall extends GameObject {
    
    public static final int SIZE = 16;
    public static final float MAX_SPEEDX = 4f;
    public static final float MAX_SPEEDY = 5f;
    public static final float DAMPING = 0.05f;
    public float velX;
    public float velY;
    
    public GOBall(float x, float y){
        this.x = x;
        this.y = y;
        this.height = SIZE;
        this.width = SIZE;
        
        velX = -MAX_SPEEDX;
        velY = 0;
    }
    
    @Override
    public void update(){
        if(Physics.checkGoal(this)){
            if(this.x <= 0){
                Game.P2Score++;
            }
            if(this.x >= Display.getWidth()){
                Game.P1Score++;
            }
            this.x = Display.getWidth() / 2 - GOBall.SIZE / 2;
            this.y = Display.getHeight() / 2 - GOBall.SIZE / 2;
            this.velX = -MAX_SPEEDX;
            this.velY = 0;
        }
        x += velX;
        y += velY;
        if(Physics.topWallCollision(this) || Physics.bottomWallCollision(this)){
              reverseY();
        }
    }
    
    public void reverseX(float center){
        velX *= -1;
        velY += (getCenterY() - center) * DAMPING;
        if(velY > MAX_SPEEDY){
            velY = MAX_SPEEDY;
        }
        if(velY < -MAX_SPEEDY){
            velY = -MAX_SPEEDY;
        }
    }
    
    public void reverseY(){
        velY *= -1;
    }
}
