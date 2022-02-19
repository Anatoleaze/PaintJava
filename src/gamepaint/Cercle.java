/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

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
    private int id;

    
    
    public Cercle(int x1,int y1,int x2,int y2,int id){
        this.centrex=x1;
        this.centrey=y1;
        if(x1 > x2){
            this.width=x1-x2;
        }else{
            this.width=x2-x1;
        }
        this.height=this.width;
        this.id=id;
        this.x=x1-this.height;
        this.y=y1-this.height;
        
    }

    @Override
    public void translation(int newX, int newY) {
        
    }
    @Override
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
     @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
     @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
     @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getId(){
        return this.id;
    }

    @Override
    public boolean contains(int x, int y) {
        if((x >= this.centrex-this.height && x <= this.centrex+this.height) && (y >=this.centrey-this.height && y<= this.centrey+this.height)){
            return true;
        }else{
            return false;
        }
        
    }
}
