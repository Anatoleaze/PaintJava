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
public class GamePaint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShapeModel s=new ShapeModel();
        ViewContainer v=new ViewContainer(s);
        PaintGUI p=new PaintGUI(v);
    }
    
}
