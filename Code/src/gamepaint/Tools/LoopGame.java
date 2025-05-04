/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Tools;

import gamepaint.Model.ShapeInterface;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author Thomas Piel
 */
public class LoopGame {
    ArrayList<Point> listPoint = null;
    Dimension dim_screen= Toolkit.getDefaultToolkit().getScreenSize() ;

    /**
     *
     * @param n
     */
    public LoopGame (Integer n){
        this.listPoint=new ArrayList();
        
        
        
        for(int i=0; i < n;i++){
          int random_x = 50 + (int)(Math.random() * (((dim_screen.getWidth()-50) - 50) + 1)); 
          int random_y = 50 + (int)(Math.random() * (((dim_screen.getHeight()-150) - 50) + 1));
          
          Point p= new Point(random_x,random_y);
          
          this.listPoint.add(p);
        }
     
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList getListPoint(){
        return this.listPoint;
    }
    
    /**
     *
     * @param listeShape
     * @return
     */
    public boolean shapeContainPoints(ArrayList<ShapeInterface> listeShape){
        ArrayList tmp=(ArrayList) this.listPoint.clone();
        int taille=tmp.size();
       
     
        for (int i =0; i < listeShape.size(); i++){
            
            for (int j =0; j < taille; j++){
                
                Point p= (Point) this.listPoint.get(j);
                
                if(listeShape.get(i).contains((int) p.getX(),(int) p.getY())){
                    tmp.remove(p);
                    
                }
                if(tmp.size()==0){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    /**
     *
     * @return
     */
    public Integer sizeScreen(){
        int size_x=(int) dim_screen.getWidth();
        int size_y=(int) dim_screen.getHeight();
        
        return size_x*size_y;
    }
    
}
