/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.Model;

import java.awt.Polygon;


/**
 *
 * @author 21507100
 */
 public interface ShapeInterface {

    /**
     *
     * @param newX
     * @param newY
     */
    public  void translation(int newX,int newY);

    /**
     *
     * @return
     */
    public  int getX();

    /**
     *
     * @return
     */
    public  int getY();

    /**
     *
     * @return
     */
    public  int getWidth();

    /**
     *
     * @return
     */
    public  int getHeight();

    /**
     *
     * @param x
     */
    public void setX(int x);

    /**
     *
     * @param y
     */
    public void setY(int y);

    /**
     *
     * @param width
     */
    public void setWidth(int width);

    /**
     *
     * @param height
     */
    public void setHeight(int height);

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean contains(int x, int y);
    
}
