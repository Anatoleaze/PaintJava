/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.View;

import gamepaint.Model.ShapeInterface;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 21507100
 */
public class ViewCircle implements ViewInterface{
    
    private ShapeInterface s;
    
    /**
     *
     * @param s
     */
    public ViewCircle (ShapeInterface s){
        this.s=s;
    }

    /**
     *
     * @param g
     */
    @Override
    public void Paint(Graphics g) {
        g.setColor(new Color( 59, 255, 59, (int) 50));
        g.fillOval((int)s.getX()-this.s.getHeight(), (int)s.getY()-this.s.getHeight(), (int)s.getWidth()*2, (int)s.getHeight()*2);
    }

    /**
     *
     * @param g
     */
    @Override
    public void delete(Graphics g) {
        g.clearRect((int)s.getX(), (int)s.getY(), (int)s.getWidth()*2, (int)s.getHeight()*2);
    }
    
}
