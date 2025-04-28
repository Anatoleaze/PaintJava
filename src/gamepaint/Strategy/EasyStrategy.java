/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Strategy;

import gamepaint.Strategy.Strategy;
import gamepaint.Model.Rectangle;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Thomas Piel
 */
public class EasyStrategy implements Strategy {

    /**
     *
     * @param listPoint
     * @return
     */
    @Override
    public ArrayList action(ArrayList<Point> listPoint) {
        
        int min_x = 0;
        int min_y=0;
        int max_x=0;
        int max_y=0;
        Point p;
        for(int i=0; i < listPoint.size(); i++){
            p=listPoint.get(i);
            if(i == 0){
                min_x=(int) listPoint.get(i).getX();
                min_y=(int) listPoint.get(i).getY();
                max_x=(int) listPoint.get(i).getX();
                max_y=(int) listPoint.get(i).getY();
            }
            
            if(listPoint.get(i).getX() < min_x){
                min_x=(int) listPoint.get(i).getX();
                
            }
            if(listPoint.get(i).getX() > max_x){
                max_x=(int) listPoint.get(i).getX();
            }
            if(listPoint.get(i).getY() < min_y){
                min_y=(int) listPoint.get(i).getY();
                
            }
            if(listPoint.get(i).getY() > max_y){
                max_y=(int) listPoint.get(i).getY();
            }
            
        }
        Rectangle shape = new Rectangle( min_x, min_y, max_x,max_y);
        ArrayList list=new ArrayList();
        list.add(shape);
        return list;
        
        
        
    }
    
}
