/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Cassie
 */
public class GUI {
        
    String currentText;
    
    private JTextArea textEnterArea;
    private JTextArea textDisplayArea;
    private Icon image; 
    private JLabel j;
    private JProgressBar health;
    private JProgressBar enemyH;
    private JProgressBar timer;
    private Timer textRetrive;
    private int   retriveDelay = 500; 
    private int time; 
    private Timer updateTimer;

    private JFrame window;
    private JPanel tEnter;
    private JPanel tDisplay;
    private JPanel healthDisplay;
    private JPanel enemyHealthDisplay;
    private JPanel timerDisplay;
    private JPanel imageDisplay;

    public static void main(String[] args) {
        GUI gui = new GUI();
        
        
    }

    public GUI() {
        initFrame();
        initTextDisplay(150,300);
        initTextEnter(150, 420);
        initImage(330, 90); 
        healthBar(20, 20);
        enemyHealth(550,100);
       
    }
    
    public boolean setText(String text){
        currentText = text;
        //update the text field
        //repaint
        //clear previous time
        //start timer
        startRetriveTimer(); 
    return true;
    }
    
    private void startRetriveTimer(){
    //start testRetrive timer
        
    //which will run till user has entered word and save time
    
    }
    
    //will return user time 
    //will throw error if timer is still runing
    public int getUserTime(){
      if(textEnterArea.getText().length() == currentText.length())
           textRetrive.stop();
       time += retriveDelay;   
        
    return -1;
    }
    
    public String  getUserText(){
       String a = "test";
              
       return a;
         
    }
    
    /*
    returns the user string and time as an imput opject
    */
    public Input getInput(){
    Input i = new Input(getUserTime(), getUserText()); 
    return i; 
    
    }

    private void initFrame() {
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(800, 600);
        window.setLayout(null);
        window.setBackground(Color.blue);
       
    }

    private void initTextDisplay(int x, int y) {
        tDisplay = new JPanel();
        
        tDisplay.setLayout(null);
        tDisplay.setBackground(Color.blue);

        textDisplayArea = new JTextArea();
        textDisplayArea.setLayout(null);
        textDisplayArea.setBackground(Color.white);
        textDisplayArea.setEditable(false);
        textDisplayArea.setBounds(25, 5, 450, 80);
        textDisplayArea.setVisible(true);

        tDisplay.add(textDisplayArea);
        tDisplay.setVisible(true);
        
        
         tDisplay.setBounds(x, y, 500,90);
          window.add(tDisplay);
    }

    private void initTextEnter(int x, int y){
         tEnter = new JPanel();
        
        tEnter.setLayout(null);
        tEnter.setBackground(Color.blue);

        textEnterArea = new JTextArea();
        textEnterArea.setLayout(null);
        textEnterArea.setBackground(Color.white);
        textEnterArea.setEditable(true);
        textEnterArea.setBounds(25, 5, 450, 80);
        textEnterArea.setVisible(true);

        tEnter.add(textEnterArea);
        tEnter.setVisible(true); 
        tEnter.setBounds(x, y, 500,90);
        
          window.add(tEnter);
        
        
    }

    private void initImage(int x, int y) {
       j = new JLabel();
       j.setIcon(new ImageIcon(getClass().getResource("images/CostaRicanFrog.jpg")));
       j.setVisible(true);
       j.setLayout(null);
       j.setBounds(0,0,170,150);
        
        /*image.setLayout(null);
        image.setVisible(true);
        image.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader()
                        .getResource("Images/CostaRicanFrog.jpg")));
        image.setBounds(0,0, 170,150);*/
        
        imageDisplay = new JPanel();
        imageDisplay.setLayout(null);
        imageDisplay.setBounds(x, y, 180,160);
        imageDisplay.setVisible(true);
        
        imageDisplay.add(j); 
        window.add(imageDisplay);
    }

    private void healthBar(int x, int y) {
        //every incorrectt key stroke will degress health by one
        
        health = new JProgressBar();
        health.setLayout(null);
        health.setVisible(true);
        health.setMaximum(100);
        health.setMinimum(0);
        //value of 0 indicates full health 100 no health
        health.setValue(20);
        
        health.setForeground(Color.white);
        //bar moves from left to right 
        //inorder to give appearance of right to left backround color is set to 
        //red and repersnets current health
        health.setBackground(Color.red); 
        health.setBounds(0, 0, 80, 20);
        
        healthDisplay = new JPanel();
        healthDisplay.setLayout(null);
        healthDisplay.setVisible(true);
        healthDisplay.setBounds(x,y,90,30); 
        healthDisplay.add(health);
        window.add(healthDisplay); 
               
    
    
    }
    
    private void enemyHealth(int x, int y){
    //every correct key stroke will degress the enemies health by one
        
        enemyH = new JProgressBar();
        enemyH.setLayout(null);
        enemyH.setVisible(true);
        enemyH.setMaximum(100);
        enemyH.setMinimum(0);
        //value of 0 indicates full health 100 no health
        enemyH.setValue(40);
        
        enemyH.setForeground(Color.white);
        //bar moves from left to right 
        //inorder to give appearance of right to left backround color is set to 
        //red and repersnets current health
        enemyH.setBackground(Color.red); 
        enemyH.setBounds(0, 0, 80, 20);
        
        enemyHealthDisplay = new JPanel();
        enemyHealthDisplay.setLayout(null);
        enemyHealthDisplay.setVisible(true);
        enemyHealthDisplay.setBounds(x,y,90,30); 
        enemyHealthDisplay.add(enemyH);
        window.add(enemyHealthDisplay); 
        
        
    }

    private void setHealth(int a) {
        health.setValue(a);
        healthDisplay.remove(health);
        healthDisplay.add(health);
        healthDisplay.repaint();
    }
    
    
    
    private void setEnemyHealth(int b){
        enemyH.setValue(b);
        enemyHealthDisplay.remove(enemyH);
        enemyHealthDisplay.add(enemyH);
        enemyHealthDisplay.repaint();
    
    } 

    public void timer() {
    }

}
