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
interface Observable {
    public void addObserver(Observer<ShapeModel> obs);
    public void removeObserver();
    public void notifyObserver(Observer<ShapeModel> str);
    public void notifyAllObserver();
}
