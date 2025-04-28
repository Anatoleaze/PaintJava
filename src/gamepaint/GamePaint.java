/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

import gamepaint.View.PaintGUI;
import gamepaint.Tools.LoopGame;
import gamepaint.Controller.ViewController;
import gamepaint.Model.ShapeModel;

/**
 *
 * @author 21507100
 */
public class GamePaint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShapeModel s=new ShapeModel();
        LoopGame l= new LoopGame(20);
        ViewController v=new ViewController(s,l);
        PaintGUI p=new PaintGUI(v);
        
    }
    
}
