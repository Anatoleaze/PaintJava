/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Mode;

import gamepaint.Mode.AbstractMode;
import gamepaint.Controller.ViewController;

/**
 *
 * @author 21507100
 */
public class DeleteShape extends AbstractMode{

    /**
     *
     * @param container
     */
    public DeleteShape(ViewController container) {
        super(container);
    }

    /**
     *
     * @param a
     */
    @Override
    public void action(int a) {
        if(a == 4){
            this.container.setMode(this);
        }
    }
    
}
