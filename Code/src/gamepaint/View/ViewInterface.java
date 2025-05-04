/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.View;

import java.awt.Graphics;

/**
 *
 * @author 21507100
 */
public interface ViewInterface {

    /**
     *
     * @param g
     */
    public void Paint(Graphics g);

    /**
     *
     * @param g
     */
    public void delete(Graphics g);
    
    
}
