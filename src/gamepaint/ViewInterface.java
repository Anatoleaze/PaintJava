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
interface ViewInterface {
    public void Paint(Graphics g);
    public void delete(Graphics g);
    public int getIdShape();
    
}
