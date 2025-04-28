/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Model;

/**
 *
 * @author 21507100
 */
public class Cercle implements ShapeInterface {
    private int centrex;
    private int centrey;
    private int x;
    private int y;
    private int width;
    private int height;
    
    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Cercle(int x1,int y1,int x2,int y2){
        this.centrex=x1;
        this.centrey=y1;
        
        this.height=(int) Math.sqrt(Math.pow(y2 - y1,2) + Math.pow(x2 - x1,2));
        this.width=this.height;
        
        this.x=x1-this.height;
        this.y=y1-this.height;
        
    }

    @Override
    public void translation(int newX, int newY) {
        
    }

    /**
     *
     * @return
     */
    @Override
    public int getX() {
        return this.centrex;
    }

    /**
     *
     * @param x
     */
    @Override
    public void setX(int x) {
        
        this.centrex=x;
        
                
    }

    /**
     *
     * @return
     */
    @Override
    public int getY() {
        return this.centrey;
    }

    /**
     *
     * @param y
     */
    @Override
    public void setY(int y) {
        
        this.centrey=y;
        
        
    }

    /**
     *
     * @return
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width =this.height;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean contains(int x, int y) {
        if( Math.sqrt(Math.pow(this.centrey - y,2) + Math.pow(this.centrex - x,2)) <=  this.height ){
            return true;
        }else{
            return false;
        }
        
        
    }
}
