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
public class ViewRectangle implements ViewInterface{
    private ShapeInterface s;
    
    public ViewRectangle (ShapeInterface s){
        this.s=s;
    }
    
    
    @Override
    public void Paint(Graphics g) {
        g.fillRect((int)s.getX(), (int)s.getY(), (int)s.getWidth(), (int)s.getHeight());
    }
    public void delete(Graphics g){
        g.clearRect((int)s.getX(), (int)s.getY(), (int)s.getWidth(), (int)s.getHeight());
       
    }

    @Override
    public int getIdShape() {
        return this.s.getId();
    }
    
}
