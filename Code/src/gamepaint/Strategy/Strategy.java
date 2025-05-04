/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Strategy;

import gamepaint.Model.ShapeInterface;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Thomas Piel
 */
public interface Strategy {

    /**
     *
     * @param listPoint
     * @return
     */
    public ArrayList<ShapeInterface> action(ArrayList<Point>listPoint);
    
}
