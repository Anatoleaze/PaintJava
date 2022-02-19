/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JPanel;

/**
 *
 * @author 21507100
 */
public class ViewContainer extends JPanel implements MouseListener, MouseMotionListener,Observer{
    
    private HashMap <Integer,ViewInterface> viewList ;
    private AbstractMode mode;
    private ShapeModel model;
    private int clic;
    private Point debut;
    private Point fin;
    
    
    
    public ViewContainer (ShapeModel model){
        debut = new Point();
        fin = new Point();
        addMouseListener(this);
        this.model=model;
        viewList=new HashMap();
        this.model.addObserver(this);
    }
    
    public void addView(Integer id,ViewInterface v){
        this.viewList.put(id,v);
    }
    public void removeView(ViewInterface v){
        
        this.viewList.remove(v.getIdShape());
    }
    
    public void addShapeModel(ShapeInterface s){
        this.model.addForme(s);
    }
    public void removeShapeModel(ShapeInterface s){
        this.model.removeShape(s);
        
    }
    
    public void paintComponent(Graphics g){
        //removeAll();
        //revalidate();
        
        
        for(Entry<Integer, ViewInterface> entry : this.viewList.entrySet()) {
            
            ViewInterface valeur = entry.getValue();
        
            valeur.Paint(g);
        }
        
        
        
                
        
        
    }
    
    public void deleteView(ViewInterface v){
        
        if(this.viewList.get(v.getIdShape()) != null){
            this.viewList.remove(v);
        }
    }
    
    public void setMode(AbstractMode mode){
        this.mode=mode;
    }

    @Override
    public void update(ShapeModel model,ShapeInterface s) {
        
        if(!model.map.contains(s)){
            this.viewList.get(s.getId()).delete(this.getGraphics());
            removeView(this.viewList.get(s.getId()));
            System.out.println(this.viewList);
        }else{
            
            ViewInterface v;
            if(s.getClass().getName().equals("gamepaint.Rectangle")){
                 v= new ViewRectangle(s);

            }else{

                 v= new ViewCircle(s);
            }
            
            addView(s.getId(),v);
        }
       // System.out.println(this.viewList);
        
        paintComponent(this.getGraphics());
        
    }
  
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p;
        
        if(this.debut.equals(  p=new Point(0,0))){
            this.debut.setLocation(e.getX(), e.getY());
            
        }else{
            this.fin.setLocation(e.getX(),e.getY());
            if(this.mode.getClass().getName().equals("gamepaint.CreationRectangle")){
                ShapeInterface rect;
                rect = (ShapeInterface) new Rectangle( (int) this.debut.getX(), (int)this.debut.getY(), (int)this.fin.getX(),(int)this.fin.getY(),2);
                this.addShapeModel(rect); 
                
            }
            if(this.mode.getClass().getName().equals("gamepaint.CreationCercle")){
                ShapeInterface cercle;
                cercle = (ShapeInterface) new Cercle( (int) this.debut.getX(), (int)this.debut.getY(), (int)this.fin.getX(),(int)this.fin.getY(),2);
                this.addShapeModel(cercle); 
                
            }
            if(this.mode.getClass().getName().equals("gamepaint.DeleteShape")){
                for(int i=0; i < this.model.getArrayList().size();i++){
                    ShapeInterface shape = (ShapeInterface) this.model.getArrayList().get(i);
                    if(shape.contains(e.getX(), e.getY())){
                        
                       this.removeShapeModel(shape);
                       
                    }
                }
            }
            this.clearPoints();
        }
        
        
            
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    public void clearPoints(){
        this.debut.setLocation(0, 0);
        this.fin.setLocation(0, 0);
    }

    
    
}
