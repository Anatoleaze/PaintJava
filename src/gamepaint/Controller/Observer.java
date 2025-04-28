/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Controller;

import gamepaint.Model.ShapeInterface;
import gamepaint.Model.ShapeModel;

/**
 *
 * @author 21507100
 * @param <M>
 */
public interface Observer <M extends ShapeModel> {

    /**
     *
     * @param observable
     * @param s
     */
    public void update(M observable,ShapeInterface s);
    
}
