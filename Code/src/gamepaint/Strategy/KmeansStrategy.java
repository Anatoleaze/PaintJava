/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Strategy;

import gamepaint.Tools.Cluster;
import gamepaint.Model.ShapeInterface;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Thomas Piel
 */
public class KmeansStrategy implements Strategy {
    ArrayList copyList=new ArrayList();

    /**
     *
     * @param listPoint
     * @return
     */
    @Override
    public ArrayList<ShapeInterface> action(ArrayList<Point> listPoint) {
        this.copyList=(ArrayList< Point>) listPoint.clone();
        Point p=getRandomPoint(this.copyList);
        
        Point newP=getFurthestPoint(this.copyList,p);
        
        Point newP2=getHighMinimalDistancePoint(this.copyList,p,newP);
       
        Cluster c1= new Cluster(p,new ArrayList());
        Cluster c2= new Cluster(newP, new ArrayList());
        Cluster c3= new Cluster(newP2,new ArrayList());
        
        setPointstoCluster(this.copyList,c1,c2,c3);
        
        
        c1.initCentralize();
        c2.initCentralize();
        c3.initCentralize();
        setPointstoCluster(this.copyList,c1,c2,c3);
        
        ArrayList res=new ArrayList();
        res.add(c1.getClustertoRectangle());
        res.add(c2.getClustertoRectangle());
        res.add(c3.getClustertoRectangle());
        
        return res;
    }
    
    /**
     *
     * @param list
     * @return
     */
    public Point getRandomPoint(ArrayList<Point> list){
        int  nombreAleatoire =  (int)(Math.random() * ((list.size())));
        Point p=list.get(nombreAleatoire);
        list.remove(p);
        return p;
   }
    
    /**
     *
     * @param list
     * @param p
     * @return
     */
    public Point getFurthestPoint(ArrayList<Point> list,Point p){
       
       int distanceFinale=0;
       Point newP=null;
        for(int i=0; i < list.size();i++){
            Point tmpP=(Point) list.get(i);
            int distance=(int) Math.sqrt(Math.pow(p.getY() - tmpP.getY(),2) + Math.pow(p.getX() - tmpP.getX(),2));
            if(distance > distanceFinale){
                distanceFinale=distance;
                newP=(Point) tmpP.clone();
            }
        }
        list.remove(newP);
        return newP;
       
   }
   
    /**
     *
     * @param list
     * @param p
     * @param p2
     * @return
     */
    public Point getHighMinimalDistancePoint(ArrayList<Point> list, Point p, Point p2){
       
        int distanceFinale=0;
        int distanceTmp=0;
        int distance1=0;
        int distance2=0;
        Point newP2=null;
        for(int j=0; j < list.size();j++){
            Point tmpP=(Point) list.get(j);
            distance1=(int) Math.sqrt(Math.pow(p.getY() - tmpP.getY(),2) + Math.pow(p.getX() - tmpP.getX(),2));
            distance2=(int) Math.sqrt(Math.pow(p2.getY() - tmpP.getY(),2) + Math.pow(p2.getX() - tmpP.getX(),2));
            if(distance1 < distance2){
                distanceTmp=distance1;
            }else{
                distanceTmp=distance2;
            }
            
            if(distanceTmp > distanceFinale){
                distanceFinale=distanceTmp;
                newP2=(Point) tmpP.clone();
            }
        }
        list.remove(newP2);
        return newP2;
       
   }
   
    /**
     *
     * @param list
     * @param c1
     * @param c2
     * @param c3
     */
    public void setPointstoCluster(ArrayList<Point> list, Cluster c1, Cluster c2, Cluster c3){
       int distance1=0;
       int distance2=0;
       int distance3=0;
       for (int i=0;i < list.size();i++){
            Point tmpP=(Point) list.get(i);
            distance1=(int) Math.sqrt(Math.pow(c1.getCentroïde().getY() - tmpP.getY(),2) + Math.pow(c1.getCentroïde().getX() - tmpP.getX(),2));
            distance2=(int) Math.sqrt(Math.pow(c2.getCentroïde().getY() - tmpP.getY(),2) + Math.pow(c2.getCentroïde().getX() - tmpP.getX(),2));
            distance3=(int) Math.sqrt(Math.pow(c3.getCentroïde().getY() - tmpP.getY(),2) + Math.pow(c3.getCentroïde().getX() - tmpP.getX(),2));
            if(Math.min(distance1, distance2)==distance1){
                if(Math.min(distance1, distance3)==distance1){
                    c1.addPoint(tmpP);
                }else{
                    c3.addPoint(tmpP);
                }
                
            }else if(Math.min(distance2, distance3) == distance2){
                c2.addPoint(tmpP);
            }else{
                c3.addPoint(tmpP);
            }
          
        }
       
   }
}
