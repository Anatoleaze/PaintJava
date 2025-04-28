/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Tools;

import gamepaint.Model.Rectangle;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Thomas Piel
 */
public class Cluster {
    Point centroïde;
    ArrayList listPoint;
    
    /**
     *
     * @param centroïde
     * @param listPoint
     */
    public Cluster(Point centroïde, ArrayList<Point> listPoint){
        this.centroïde=centroïde;
        this.listPoint=listPoint;
        addPoint(this.centroïde);
        
    }
    
    /**
     *
     */
    public void initCentralize(){
        int newX=0;
        int newY=0;
        
        for(int i=0;i <this.listPoint.size();i++){
            Point p=(Point) this.listPoint.get(i);
            newX+=(int) p.getX();
            newY+=(int) p.getY();
            
        }
        
        newX=newX/this.listPoint.size();
        newY=newY/this.listPoint.size();
        Point newCentroïde= new Point(newX,newY);
        
        setCentroïde(newCentroïde);
    }
    
    /**
     *
     * @param p
     */
    public void addPoint(Point p){
        this.listPoint.add(p);
    }
    
    /**
     *
     * @return
     */
    public Point getCentroïde(){
        return this.centroïde;
    }

    /**
     *
     * @param centroïde
     */
    public void setCentroïde(Point centroïde){
        this.centroïde=centroïde;
    }
    
    public String toString(){
        return this.centroïde+" le centre "+this.listPoint;
    }
    
    /**
     *
     * @return
     */
    public Rectangle getClustertoRectangle(){
        int min_x = 0;
        int min_y=0;
        int max_x=0;
        int max_y=0;
        Point p;
        for(int i=0; i < listPoint.size(); i++){
            p=(Point) this.listPoint.get(i);
            if(i == 0){
                min_x=(int) p.getX();
                min_y=(int) p.getY();
                max_x=(int) p.getX();
                max_y=(int) p.getY();
            }
            
            if(p.getX() < min_x){
                min_x=(int) p.getX();
                
            }
            if(p.getX() > max_x){
                max_x=(int) p.getX();
            }
            if(p.getY() < min_y){
                min_y=(int) p.getY();
                
            }
            if(p.getY() > max_y){
                max_y=(int) p.getY();
            }
            
        }
        Rectangle shape = new Rectangle( min_x, min_y, max_x,max_y);
        return shape;
    }
    
}
