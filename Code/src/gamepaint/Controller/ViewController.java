/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Controller;

import gamepaint.Tools.LoopGame;
import gamepaint.Mode.Resize;
import gamepaint.Mode.Movement;
import gamepaint.Mode.DeleteShape;
import gamepaint.Mode.CreationRectangle;
import gamepaint.Mode.CreationCercle;
import gamepaint.Mode.AbstractMode;
import gamepaint.View.ViewRectangle;
import gamepaint.View.ViewInterface;
import gamepaint.View.ViewCircle;
import gamepaint.Model.Rectangle;
import gamepaint.Model.ShapeInterface;
import gamepaint.Model.Cercle;
import gamepaint.Model.ShapeModel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JPanel;

/**
 *
 * @author 21507100
 */
public class ViewController extends JPanel implements MouseWheelListener,MouseListener, MouseMotionListener,Observer{
    private LoopGame loopGame;
    private HashMap <ShapeInterface,ViewInterface> viewList ;
    private AbstractMode mode;
    private ShapeModel model;
    private int clic;
    private Point debut;
    private Point fin;
    private Point tmp;
    private ShapeInterface shape=null;
    private ViewInterface view=null;
    
    /**
     *
     * @param model
     * @param l
     */
    public ViewController (ShapeModel model, LoopGame l){
        debut = new Point();
        fin = new Point();
        tmp= new Point();
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        this.model=model;
        viewList=new HashMap();
        this.model.addObserver(this);
        this.loopGame=l;
    }
    
    /**
     *
     * @param s
     * @param v
     */
    public void addView(ShapeInterface s,ViewInterface v){
        this.viewList.put(s,v);
    }

    /**
     *
     * @param s
     */
    public void removeView(ShapeInterface s){
        
        this.viewList.remove(s);
    }
    
    /**
     *
     * @param s
     */
    public void addShapeModel(ShapeInterface s){
        this.model.addForme(s);
    }

    /**
     *
     * @param s
     */
    public void removeShapeModel(ShapeInterface s){
        this.model.removeShape(s);
        
    }
    
    public void removeAllShapesModel(){
        this.model.removeAllShapes();
    }
    
    /**
     *
     * @return
     */
    public LoopGame getLoopGame(){
        return this.loopGame;
    }

    /**
     *
     * @return
     */
    public String messageEndGame(){
        if(this.loopGame.shapeContainPoints(this.model.getArrayList())){
            return "Vous avez réussi ! Vos formes prennent ";
        }
        else{
            return "il reste des points non contenus dans une forme !";
        }
    }
    
    /**
     *
     * @return
     */
    public int pourcentageShapeScreen(){
        int width=0;
        int height=0;
        for(int i=0; i < this.model.getArrayList().size();i++){
            ShapeInterface s=(ShapeInterface) this.model.getArrayList().get(i);
            width+=s.getWidth();
            height+=s.getHeight();
            
        }
        int total=width*height;
        int sizeScreen=this.loopGame.sizeScreen();
        
        
        return (total/sizeScreen)*100;
    }

    /**
     *
     * @return
     */
    public Integer getSizeViewList(){
        return this.viewList.size();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i =0; i < this.loopGame.getListPoint().size(); i++){
            Point p= (Point) this.loopGame.getListPoint().get(i);
            g.drawLine((int) p.getX()-10, (int) p.getY(), (int) p.getX()+10, (int) p.getY());
            g.drawLine((int) p.getX(), (int) p.getY()-10, (int) p.getX(), (int) p.getY()+10);
        }
        
        
        for(Entry<ShapeInterface, ViewInterface> entry : this.viewList.entrySet()) {
            
            ViewInterface valeur = entry.getValue();
        
            valeur.Paint(g);
        }

    
    }
 
    /**
     *
     * @param mode
     */
    public void setMode(AbstractMode mode){
        this.mode=mode;
    }

    /**
     *
     * @param model
     * @param s
     */
    @Override
    public void update(ShapeModel model,ShapeInterface s) {
        
        
        if(!model.map.contains(s)){
            
            
            removeView(s);
            repaint();
            
        }else{
            
            ViewInterface v;
            if(s instanceof Rectangle){
                 v= new ViewRectangle(s);

            }else{

                 v= new ViewCircle(s);
            }
            
            addView(s,v);
            repaint();
            
        }
        //System.out.println(this.viewList);
    }
  
    
    @Override
    public void mouseClicked(MouseEvent e) {
   
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
        Point p;
        
        if(this.mode instanceof Resize ){
            for(int i=0; i < this.model.getArrayList().size();i++){
                    ShapeInterface shape = (ShapeInterface) this.model.getArrayList().get(i);
                    
                    if(shape.contains(e.getX(), e.getY())){
                        
                       this.shape=shape;
                       
                       this.debut.setLocation(e.getX(), e.getY());
                       
                    }
            }
            
        }
        
        if(this.mode instanceof Movement){
            
            for(int i=0; i < this.model.getArrayList().size();i++){
                    ShapeInterface shape = (ShapeInterface) this.model.getArrayList().get(i);
                    
                    if(shape.contains(e.getX(), e.getY())){
                       this.shape=shape;
                       
                       this.debut.setLocation(e.getX(), e.getY());
                       
                    }
            }
            
            
        }
        
        if(this.mode instanceof CreationRectangle){
            
            this.debut.setLocation(e.getX(), e.getY());
            this.tmp.setLocation(e.getX(), e.getY());
            
            this.fin.setLocation(e.getX(),e.getY());
              
             
            this.shape= (ShapeInterface) new Rectangle( (int) this.debut.getX(), (int)this.debut.getY(), (int)this.fin.getX(),(int)this.fin.getY());
            this.addShapeModel(this.shape);
        }
        
        if(this.mode instanceof CreationCercle){
            if(this.debut.equals(  p=new Point(0,0))){
            this.debut.setLocation(e.getX(), e.getY());
            
            }else{
                this.fin.setLocation(e.getX(),e.getY());
                ShapeInterface cercle;
                cercle = (ShapeInterface) new Cercle( (int) this.debut.getX(), (int)this.debut.getY(), (int)this.fin.getX(),(int)this.fin.getY());
                
                this.addShapeModel(cercle); 
                this.clearPoints();
            }
        }
        
        if(this.mode instanceof DeleteShape){
                for(int i=0; i < this.model.getArrayList().size();i++){
                    ShapeInterface shape = (ShapeInterface) this.model.getArrayList().get(i);
                 
                    if(shape.contains(e.getX(), e.getY())){
                        
                       this.removeShapeModel(shape);
                    }
                }
     
        }
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        if(this.mode instanceof Movement){
            
        }
        
        if(this.mode instanceof CreationRectangle){
            
            if(this.shape.getHeight() < 0 && this.shape.getWidth() < 0){
                this.shape.setX((int) this.fin.getX());
                this.shape.setY((int) this.fin.getY());
                this.shape.setWidth(-this.shape.getWidth());
                this.shape.setHeight(-this.shape.getHeight());
            }
            if(this.shape.getWidth() < 0){
                    this.shape.setWidth(-this.shape.getWidth());
                    this.shape.setX((int) this.fin.getX());
                    this.shape.setY((int) this.debut.getY());
            }
            if(this.shape.getHeight() < 0){
                this.shape.setHeight(-this.shape.getHeight());
                this.shape.setX((int) this.debut.getX());
                this.shape.setY((int) this.fin.getY());
            }
            
            repaint();
            this.clearPoints();
            
        }
        
        if(this.mode instanceof Resize){
            if(this.shape.getHeight() < 0 && this.shape.getWidth() < 0){
                
                this.shape.setX((int) this.shape.getX()+this.shape.getWidth());
                this.shape.setY((int) this.shape.getY()+this.shape.getHeight());
                this.shape.setWidth(-this.shape.getWidth());
                this.shape.setHeight(-this.shape.getHeight());
            }
            if(this.shape.getWidth() < 0){
                
                    this.shape.setX((int) this.shape.getX() + this.shape.getWidth());
                    this.shape.setWidth(-this.shape.getWidth());
                    
                    
            }
            if(this.shape.getHeight() < 0){
                
                
                this.shape.setY((int) this.shape.getY()+ this.shape.getHeight());
                this.shape.setHeight(-this.shape.getHeight());
            }
            
            repaint();
            this.clearPoints();
            this.shape=null;
            
            
            
        }
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(this.mode instanceof Movement){
            
            
            
            this.fin.setLocation(e.getX(), e.getY());
            
            
            
            int x=(int) (this.debut.getX()-this.fin.getX());
                    
            int y =(int) (this.debut.getY()-this.fin.getY());
            
                    
                      
            this.shape.setX(shape.getX()-x);
            this.shape.setY(shape.getY()-y);
            
            this.debut.setLocation(e.getX(), e.getY());
            repaint(); 
        }
        if(this.mode instanceof Resize){
            
            if(this.shape instanceof Rectangle){
                this.fin.setLocation(e.getX(), e.getY());

                int x=(int) (this.debut.getX()-this.fin.getX());

                int y =(int) (this.debut.getY()-this.fin.getY());

                this.shape.setHeight(shape.getHeight()-y);
                this.shape.setWidth(shape.getWidth()-x); 
                this.debut.setLocation(e.getX(), e.getY());
                
                repaint();
            }
            
        }
        
        if(this.mode instanceof CreationRectangle){
                
                this.fin.setLocation(e.getX(),e.getY());
                int x=(int) (this.tmp.getX()-this.fin.getX());

                int y =(int) (this.tmp.getY()-this.fin.getY());



                this.shape.setWidth(shape.getWidth()-x);
                this.shape.setHeight(shape.getHeight()-y);
                this.tmp.setLocation(e.getX(), e.getY());
           
                repaint();
              
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    /**
     *
     */
    public void clearPoints(){
        this.debut.setLocation(0, 0);
        this.fin.setLocation(0, 0);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(this.mode instanceof Resize){
            if(this.shape instanceof Cercle){
                int rotation=e.getWheelRotation();
                
                this.shape.setHeight(this.shape.getHeight()+rotation*5);
                this.shape.setWidth(rotation+5);
                repaint();
            }
            
        }
    }

}
