////////
//Wayne Mattis
//
////////

//The JPanel used in the SaucerDriver class to present a flying saucer as it lands on a black strip.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SaucerLander extends JPanel implements ActionListener{
  JButton fast=new JButton("Fast");
  JButton slow=new JButton("Slow");
  JButton reverse=new JButton("Reverse");
  JButton quit=new JButton("Quit");
  private int xpos=0,ypos=0,width=75,height=25,fontSize=8;
  
  public SaucerLander(){
    setPreferredSize(new Dimension(500,500));
    setBackground(Color.white);
    this.add(fast);
    fast.addActionListener(this);
    this.add(slow);
    slow.addActionListener(this);
    this.add(reverse);
    reverse.addActionListener(this);
    this.add(quit);
    quit.addActionListener(this);
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    paintPrimary(g);//Paints the ground and the body of the ship
    paintSecondary(g);//Paints the name of the ship and the windows on its side
  }
  
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==quit)
      System.exit(0);
    else
      if (e.getSource()==fast)
        moveFast();
    else
      if (e.getSource()==slow)
        moveSlow();
    else
      if (e.getSource()==reverse)
        moveBack();
    repaint();
  }
  
  public void moveFast(){
    xpos+=100;
    ypos+=100;
    width*=3;
    height*=3;
  }
  
  public void moveSlow(){
    xpos+=50;
    ypos+=50;
    width*=2;
    height*=2;
  }
  
  public void moveBack(){
    xpos-=50;
    ypos-=50;
    if (width>=2){width/=2;}//Integer division could reduce the width to 0 if it was set to 1/2, so the smallest possible width and height must be 1 (that is, 2/2)
    if (height>=2){height/=2;}
  }
  
  public void paintPrimary(Graphics g){
    g.setColor(Color.green);
    g.fillRect(0,400,500,100);//Paints the green ground
    if (ypos+height>400){//Checks to see whether the ship is covering the ground--if it is, the color changes from pink to red
      g.setColor(Color.black);
      g.fillRect(400,400,100,100);//A landing strip also appears when the ship is covering the ground area
      g.setColor(Color.red);
    }
    else{g.setColor(Color.pink);}//Otherwise, the ship is drawn pink without the landing strip
    g.fillOval(xpos,ypos,width,height);
  }
  
  public void paintSecondary(Graphics g){
    fontSize=8*(width*height)/15000;//Font size must be dependent on the size of the ship
    g.setColor(Color.black);
    g.setFont(new Font("TimesRoman",Font.PLAIN,fontSize));
    g.drawString("Serenity",xpos+2*(width/3),ypos+height/3);//draws the ship name on the side of the ship
    for (int i=10;i>0;i--){//draws 5 windows on the side of the ship
      g.fillRect((xpos+2*(width/3))-((width/20)*i), ypos+height/3,width/50,height/25);
    }
  }
  
  }