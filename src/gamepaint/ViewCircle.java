/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

import java.awt.Graphics;

/**
 *
 * @author 21507100
 */
public class ViewCircle implements ViewInterface{
    
    private ShapeInterface s;
    
    public ViewCircle (ShapeInterface s){
        this.s=s;
    }

    @Override
    public void Paint(Graphics g) {
        
        g.fillOval((int)s.getX(), (int)s.getY(), (int)s.getWidth()*2, (int)s.getHeight()*2);
    }

    @Override
    public int getIdShape() {
       return this.s.getId();
    }

    @Override
    public void delete(Graphics g) {
        g.clearRect((int)s.getX(), (int)s.getY(), (int)s.getWidth()*2, (int)s.getHeight()*2);
    }
    
}
