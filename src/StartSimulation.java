package src;

import javax.swing.JFrame;

import src.Enviornment.*;

public class StartSimulation {
    public static final int width = 1600;
    public static final int height = 1000;
    
    public static void main(String[] args) {
        JFrame simulation = new JFrame();
        simulation.setTitle("Physics Engine");
        simulation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simulation.add(new Environment());
        simulation.pack();
        simulation.setVisible(true);
    }
}


