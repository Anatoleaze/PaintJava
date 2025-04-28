/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Model;

import gamepaint.Controller.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 21507100
 */
public class ShapeModel implements Observable{

    /**
     *
     */
    public ArrayList<ShapeInterface> map;
    private List<Observer<ShapeModel>> listObserver = new ArrayList<Observer<ShapeModel>>();
    private ShapeInterface s;

    /**
     *
     */
    public ShapeModel(){
        this.map=new ArrayList();
        
    }
    
    /**
     *
     * @param s
     */
    public void addForme(ShapeInterface s){
        this.map.add(s);
        this.s=s;
        this.notifyAllObserver();
    }

    /**
     *
     * @param s
     */
    public void removeShape(ShapeInterface s){
        
        this.s=s;
        System.out.print(this.s+" bblabla");
        this.map.remove(s);
        this.notifyAllObserver();
        
    }
    
    public void removeAllShapes(){
        
        
        boolean flag=true;
        
        while(flag){
            removeShape(this.map.get(0));
            
            if(this.map.size()==0){
                flag=false;
            }
        }
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList getArrayList(){
        return this.map;
    }
    
    /**
     *
     * @param obs
     */
    @Override
    public void addObserver(Observer obs){
        this.listObserver.add(obs);
    }

    

    /**
     *
     * @param o
     */
    @Override
    public void notifyObserver(Observer o) {
        o.update((ShapeModel) this, this.s);
    }

    /**
     *
     */
    @Override
    public void notifyAllObserver() {
        
        for(Observer<ShapeModel> o : this.listObserver){
            notifyObserver(o);
        }
    }
    
    /**
     *
     * @return
     */
    public ShapeInterface getShape(){
        return this.s;
    }

    /**
     *
     * @param s
     */
    public void setShape(ShapeInterface s){
        this.s=s;
    }
}
