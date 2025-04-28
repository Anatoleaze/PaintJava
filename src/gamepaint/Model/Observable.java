/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Model;

import gamepaint.Controller.Observer;
import gamepaint.Model.ShapeModel;

/**
 *
 * @author 21507100
 */
public interface Observable {

    /**
     *
     * @param obs
     */
    public void addObserver(Observer<ShapeModel> obs);

    

    /**
     *
     * @param str
     */
    public void notifyObserver(Observer<ShapeModel> str);

    /**
     *
     */
    public void notifyAllObserver();
}
