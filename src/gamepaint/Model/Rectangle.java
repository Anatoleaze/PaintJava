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
public class Rectangle implements ShapeInterface {
    private int maxx;
    private int maxy;
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
    public Rectangle(int x1,int y1,int x2,int y2){
        this.x=x1;
        this.y=y1;
        if(x1 > x2){
            this.width=x1-x2;
            this.x=x2;
            this.maxx=x1;
        }else{
            this.width=x2-x1;
            this.maxx=x2;
        }
        
        if(y1 > y2){
            this.height=y1-y2;
            this.y=y2;
            this.maxy=y1;
        }else{
            this.height=y2-y1;
            this.maxy=y2;
        }
        
       
    }
    @Override
    public void translation(int newX, int newY) {
        this.x=newX;
        this.y=newY;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    @Override
    public int getY() {
        return y;
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
     * @return
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param x
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @param width
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @param height
     */
    @Override
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
        if((x >= this.x && x <= this.x+this.width) && (y >=this.y && y<= this.y+this.height)){
            return true;
        }else{
            return false;
        }
    }

    
    
    
}
