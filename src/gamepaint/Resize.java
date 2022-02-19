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
public class Resize extends AbstractMode {

    public Resize(ViewContainer container) {
        super(container);
    }

    @Override
    public void action(int a) {
        if(a == 0){
            this.container.setMode(this);
        }
    }
    
}
