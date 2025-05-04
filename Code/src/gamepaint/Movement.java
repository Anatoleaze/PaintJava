/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

/**
 *
 * @author 21507100
 */
public class Movement extends AbstractMode{

    public Movement(ViewContainer container) {
        super(container);
    }

    @Override
    public void action(int a) {
        if(a == 1){
            this.container.setMode(this);
        }
    }
    
}
