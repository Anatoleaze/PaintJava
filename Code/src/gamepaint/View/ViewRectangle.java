/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.View;



import gamepaint.View.ViewInterface;
import gamepaint.Model.ShapeInterface;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author 21507100
 */
public class ViewRectangle implements ViewInterface{
    private ShapeInterface s;
    
    /**
     *
     * @param s
     */
    public ViewRectangle (ShapeInterface s){
        this.s=s;
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void Paint(Graphics g) {
       
        g.setColor(new Color( 255, 59, 59, (int) 50));
            g.fillRect((int)s.getX(), (int)s.getY(), (int)s.getWidth(), (int)s.getHeight());
        
    }

    /**
     *
     * @param g
     */
    @Override
    public void delete(Graphics g){
        g.clearRect((int)s.getX(), (int)s.getY(), (int)s.getWidth(), (int)s.getHeight());
        
    }

    
    
}
