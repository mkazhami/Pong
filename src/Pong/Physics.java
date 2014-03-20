/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pong;

import java.awt.Rectangle;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Mikhail
 */
public class Physics {
    
    public static boolean checkCollisions(GameObject go1, GameObject go2){
        Rectangle r1 = new Rectangle((int)go1.getX(),(int) go1.getY(),(int) go1.getWidth(),(int) go1.getHeight());
        Rectangle r2 = new Rectangle((int)go2.getX(),(int) go2.getY(),(int) go2.getWidth(),(int) go2.getHeight());
        return r1.intersects(r2);
    }
    
    public static boolean topWallCollision(GameObject go){
        return (go.getCenterY() + go.height/2) >= Display.getHeight();
    }
    
    public static boolean bottomWallCollision(GameObject go){
        return (go.getCenterY() - go.height/2) <= 0;
    }
    
    public static boolean checkGoal(GameObject go){
        return (go.x <= 0 || go.x >= Display.getWidth());
    }
}
