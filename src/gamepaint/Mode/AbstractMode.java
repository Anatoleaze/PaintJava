/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Mode;

import gamepaint.Controller.ViewController;
import java.util.ArrayList;

/**
 *
 * @author 21507100
 */
public abstract class AbstractMode {

    /**
     *
     */
    public ViewController container;

    /**
     *
     * @param container
     */
    public AbstractMode (ViewController container){
        this.container=container;
        
    }

    /**
     *
     * @param a
     */
    public  abstract void action(int a);
}
