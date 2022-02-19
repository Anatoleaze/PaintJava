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
public class CreationRectangle extends AbstractMode{

    public CreationRectangle(ViewContainer container) {
        super(container);
    }

    @Override
    public void action(int a) {
        if(a == 3){
            this.container.setMode(this);
        }
    }
    
}
