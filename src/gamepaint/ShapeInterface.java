/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

import java.awt.Polygon;


/**
 *
 * @author 21507100
 */
 interface ShapeInterface {

    /**
     *
     * @param newX
     * @param newY
     */
    public  void translation(int newX,int newY);
    public  int getId();
    public  int getX();
    public  int getY();
    public  int getWidth();
    public  int getHeight();
    public boolean contains(int x, int y);
    
}
