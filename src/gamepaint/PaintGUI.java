/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author 21507100
 */
public class PaintGUI extends JFrame {
    private ViewContainer container;
    public PaintGUI(ViewContainer container){
        this.container=container;
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        this.setTitle("feu");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.container.setBackground(Color.white);
        this.container.setPreferredSize(new Dimension(800,800));
        
        JButton rectangle_button =new JButton("Rectangle");
        JButton circle_button=new JButton("Cercle");
        JButton delete_shape= new JButton("Suppression");
        
        rectangle_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractMode mode= new CreationRectangle(container);
                mode.action(3);
                container.clearPoints();
                
                
                
            }
        });
        
        circle_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractMode mode= new CreationCercle(container);
                mode.action(2);
                container.clearPoints();
                
            }
        });
        
        delete_shape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractMode mode= new DeleteShape(container);
                mode.action(4);
                container.clearPoints();
            }
        });
        //this.getContentPane().removeAll();
        //this.getContentPane().repaint();
        
        this.getContentPane().add(rectangle_button);
        this.getContentPane().add(circle_button);
        this.getContentPane().add(delete_shape);
        this.getContentPane().add(this.container);
        
        
        
        this.setVisible(true);
        
    }
    
}
