/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

import java.util.ArrayList;

/**
 *
 * @author 21507100
 */
public abstract class AbstractMode {
    public ViewContainer container;
    public AbstractMode (ViewContainer container){
        this.container=container;
        
    }
    public  abstract void action(int a);
}
