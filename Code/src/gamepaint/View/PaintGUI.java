/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepaint.View;

import gamepaint.Controller.ViewController;
import gamepaint.Mode.Resize;
import gamepaint.Mode.Movement;
import gamepaint.Mode.DeleteShape;
import gamepaint.Mode.CreationRectangle;
import gamepaint.Mode.CreationCercle;
import gamepaint.Mode.AbstractMode;
import gamepaint.Strategy.EasyStrategy;
import gamepaint.Strategy.Strategy;
import gamepaint.Strategy.KmeansStrategy;
import gamepaint.Model.ShapeInterface;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 21507100
 */
public class PaintGUI extends JFrame {
    private ViewController container;
    Strategy strategy;

    /**
     *
     * @param container
     */
    public PaintGUI(ViewController container){
        Component component= this.getComponent(0);
        Graphics g= this.getGraphics();
    	this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.container=container;
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.setTitle("GamePaint");
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.container.setBackground(Color.white);
        Dimension dim_screen= Toolkit.getDefaultToolkit().getScreenSize() ;
        
        dim_screen.setSize(dim_screen.getWidth(), dim_screen.getHeight());
        this.setSize(dim_screen);
        
        
        
        this.container.setPreferredSize(dim_screen);
        
        
        
        JButton rectangle_button =new JButton("Rectangle",new ImageIcon(getClass().getResource("/Ressources/rectangle.png")));
        JButton circle_button=new JButton("Cercle", new ImageIcon(getClass().getResource("/Ressources/circle.png")));
        JButton delete_shape= new JButton("Effacer",new ImageIcon(getClass().getResource("/Ressources/erased.png")));
        JButton move_shape= new JButton("Déplacement",new ImageIcon(getClass().getResource("/Ressources/arrows.png")));
        JButton resize_shape= new JButton("Resize", new ImageIcon(getClass().getResource("/Ressources/resize.png")));
        JButton easy_strategy= new JButton("Stratégie Facile",new ImageIcon(getClass().getResource("/Ressources/easy.png")));
        JButton kmeans_strategy= new JButton("Stratégie K-Means",new ImageIcon(getClass().getResource("/Ressources/cluster.png")));
        JButton validate_button= new JButton("Valider",new ImageIcon(getClass().getResource("/Ressources/check.png")));
        
        rectangle_button.setBounds(0, 0, 200, 100);
        circle_button.setBounds(rectangle_button.getX()+200, rectangle_button.getY(), 200, 100);
        delete_shape.setBounds(circle_button.getX()+200, circle_button.getY(), 200, 100);
        validate_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message=container.messageEndGame();
                Integer pourcentage=container.pourcentageShapeScreen();
                
                String string_pourcentage=pourcentage.toString();
                message+=string_pourcentage+"% de l'écran";
                JOptionPane.showMessageDialog(component,message,"Information",JOptionPane.INFORMATION_MESSAGE);
                
            }
        });
        kmeans_strategy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAllShapesModel();
                strategy= new KmeansStrategy();
                ArrayList<ShapeInterface> shapeStrategy = (ArrayList<ShapeInterface>)  strategy.action(container.getLoopGame().getListPoint() );
                for(int i=0; i < shapeStrategy.size();i++){
                    ShapeInterface s=shapeStrategy.get(i);
                    container.addShapeModel(s);
                    
                    
                }
                
            }
        });
        easy_strategy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAllShapesModel();
                strategy= new EasyStrategy();
                ArrayList<ShapeInterface> shapeStrategy = (ArrayList<ShapeInterface>)  strategy.action(container.getLoopGame().getListPoint() );
                ShapeInterface shape = shapeStrategy.get(0);
                container.addShapeModel(shape);
                
            }
        });
        move_shape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractMode mode= new Movement(container);
                mode.action(1);
                container.clearPoints();
            }
        });
        
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
        resize_shape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractMode mode= new Resize(container);
                mode.action(0);
                container.clearPoints();
            }
        });
       
        
        this.getContentPane().add(rectangle_button);
        this.getContentPane().add(circle_button);
        this.getContentPane().add(delete_shape);
        this.getContentPane().add(move_shape);
        this.getContentPane().add(resize_shape);
        this.getContentPane().add(easy_strategy);
        this.getContentPane().add(kmeans_strategy);
        this.getContentPane().add(validate_button);
        this.getContentPane().add(this.container);
        
        
        
        
        this.setVisible(true);
        
    }
    
}