/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 21507100
 */
public class ShapeModel implements Observable{
    public ArrayList<ShapeInterface> map;
    private List<Observer<ShapeModel>> listObserver = new ArrayList<Observer<ShapeModel>>();
    private ShapeInterface s;
    public ShapeModel(){
        this.map=new ArrayList();
        
    }
    
    public void addForme(ShapeInterface s){
        this.map.add(s);
        this.s=s;
        this.notifyAllObserver();
    }
    public void removeShape(ShapeInterface s){
        this.map.remove(s);
        //this.s=s;
        this.notifyAllObserver();
        
    }
    
    public ArrayList getArrayList(){
        return this.map;
    }
    

   @Override
    public void addObserver(Observer obs){
        this.listObserver.add(obs);
    }

    @Override
    public void removeObserver() {
        this.listObserver=new ArrayList<Observer<ShapeModel>>();
    }

    @Override
    public void notifyObserver(Observer o) {
        o.update((ShapeModel) this, this.s);
    }

    @Override
    public void notifyAllObserver() {
        
        for(Observer<ShapeModel> o : this.listObserver){
            notifyObserver(o);
        }
    }
}
