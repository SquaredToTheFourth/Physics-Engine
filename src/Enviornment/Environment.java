package src.Enviornment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import src.StartSimulation;
import src.ObjectProperites.*;


public class Environment extends JPanel implements ActionListener{
    private Timer deltaTimer;
    private Timer realTimer;
    private TestObject testObject;
    
    private JLabel yVelocityDisp;
    
    public static final double coefFriction = .5;
    
    public static final double globalYVelocity = 9.81;
    
    public static final double scale = 1;
    
    private static long time = System.currentTimeMillis();
    public static long timerDelay = 1;
    
    
    public Environment() {
        testObject = new TestObject(350, 400, 350, 400, 10);
        
        this.setPreferredSize(new Dimension(StartSimulation.width, StartSimulation.height));
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
        
        yVelocityDisp = new JLabel();
        yVelocityDisp.setBounds(25,25, 500, 50);
        yVelocityDisp.setText("Y Velocity: 0");
        yVelocityDisp.setForeground(Color.white);
        yVelocityDisp.setVisible(true);
        
        this.add(yVelocityDisp);
        
        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "jump");
        this.getActionMap().put("jump", new ActionLibrary.Jump((int)KeyEvent.VK_W, testObject));
        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "moveLeft");
        this.getActionMap().put("moveLeft", new ActionLibrary.MoveLeft((int)KeyEvent.VK_A, testObject));
        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "moveRight");
        this.getActionMap().put("moveRight", new ActionLibrary.MoveRight((int)KeyEvent.VK_D, testObject));
        
        
        deltaTimer = new Timer(8, this);
        deltaTimer.start();
        deltaTimer.setActionCommand("Delta Timer");
        
        realTimer = new Timer(1,this);
        realTimer.start();
        realTimer.setActionCommand("Real Timer");
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Real Timer")) {
        testObject.updateGlobalVelocity();
        timerDelay = -(time - System.currentTimeMillis());
        time = System.currentTimeMillis();
        yVelocityDisp.setText("Y Velocity: " + String.format("%.3f", testObject.getYVelocity()) + "     X Velocity: " + String.format("%.3f", testObject.getXVelocity()) +"     Left X: " + testObject.getLeftX() +"     Right X: " + testObject.getRightX()   );
        }
        
        
        if(e.getActionCommand().equals("Delta Timer")) {
            repaint();
        }
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.fillRect(testObject.getLeftX(), testObject.getTopY() ,testObject.getRightX()- testObject.getLeftX(), testObject.getBottomY()-testObject.getTopY());
    }

}


