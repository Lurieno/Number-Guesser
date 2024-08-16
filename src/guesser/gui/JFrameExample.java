package guesser.gui;
// It is better to not extend JFrame and rather make a "private JFrame frame" in a frame class
// In this case you can choose what JFrame functions to offer
// java program to create a multiple  JWindow .( where one window is the owner of the other )< 
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

class solveit extends JFrame implements ActionListener { 
  
    // frame 
    static JFrame f; 
  
    // windows 
    JWindow w, w1; 
  
    // object of class 
    static solveit s; 
  
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame 
        f = new JFrame("frame"); 
  
        // create a object 
        s = new solveit(); 
  
        // create a panel 
        JPanel p = new JPanel(); 
  
        JButton b = new JButton("click"); 
  
        // add actionlistener to button 
        b.addActionListener(s); 
  
        // add button to panel 
        p.add(b); 
  
        f.add(p); 
  
        // set the size of frame 
        f.setSize(400, 400); 
  
        // center frame on screen
        f.setLocationRelativeTo(null);

        // make frame visible
        f.setVisible(true); 
    } 
  
    // if button is pressed 
    public void actionPerformed(ActionEvent e) 
    { 
        String s1 = e.getActionCommand(); 
        if (s1.equals("click")) { 
            // create a window 
            w = new JWindow(f); 
  
            // set panel 
            JPanel p = new JPanel(); 
  
            // create a label 
            JLabel l = new JLabel("this is first window"); 
  
            // create a button 
            JButton b = new JButton("Click me"); 
  
            // add Action listener 
            b.addActionListener(s); 
  
            // set border 
            p.setBorder(BorderFactory.createLineBorder(Color.black)); 
  
            p.add(l); 
            p.add(b); 
            w.add(p); 
  
            // set background 
            p.setBackground(Color.red); 
  
            // setsize of window 
            w.setSize(200, 100); 
  
            // set visibility of window 
            w.setVisible(true); 
  
            // set location of window 
            w.setLocation(100, 100); 
        } 
        else { 
            // create a window 
            w1 = new JWindow(w); 
  
            // set panel 
            JPanel p = new JPanel(); 
  
            // create a label 
            JLabel l = new JLabel("this is the second window"); 
  
            // set border 
            p.setBorder(BorderFactory.createLineBorder(Color.black)); 
  
            p.add(l); 
  
            w1.add(p); 
  
            // set background 
            p.setBackground(Color.blue); 
  
            // setsize of window 
            w1.setSize(200, 100); 
  
            // set visibility of window 
            w1.setVisible(true); 
  
            // set location of window 
            w1.setLocation(210, 210); 
        } 
    } 
} 
