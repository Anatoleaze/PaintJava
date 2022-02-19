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
public class Rectangle implements ShapeInterface {
    private int maxx;
    private int maxy;
    private int x;
    private int y;
    private int width;
    private int height;
    private int id;
    
    public Rectangle(int x1,int y1,int x2,int y2,int id){
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
        this.id=id;
       
    }
    @Override
    public void translation(int newX, int newY) {
        this.x=newX;
        this.y=newY;
    }

    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
     @Override
    public int getWidth() {
        return width;
    }
     @Override
    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getId(){
        return this.id;
    }

    @Override
    public boolean contains(int x, int y) {
        if((x >= this.x && x <= this.maxx) && (y >=this.y && y<= this.maxy)){
            return true;
        }else{
            return false;
        }
    }

    
    
    
}
