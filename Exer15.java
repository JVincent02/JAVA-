import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exer15 extends JFrame implements KeyListener  {
	Color[] ranGreen = {new Color(0,170,0),
						new Color(0,130,0),new Color(0,70,0),new Color(0,100,0)};
						
	int px=530,py=650,px1=730,py1=650,keycode=-1;
    public static void main(String args[]){
    	new Exer15();	
    }  

    public Exer15() {
		Container c = getContentPane();
    	Color col = new Color(0,170,0);
		c.setBackground(col);
    	setVisible(true);
    	setSize(1280,768);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	addKeyListener(this);
    }

    public void paint(Graphics g){
    	super.paint(g);	
    	/*
    	for(int x=0;x<=1280;x+=5){
    		for(int y=0;y<=768;y+=5){
    		g.setColor(ranGreen[(int)(Math.random()*4)]);
    		g.fillRect(x,y,5,5);
    		}
    	}
    	*/
    	generateTrees(g,100,100);	
    	generateTrees(g,300,250);
    	generateTrees(g,200,450);
    	generateTrees(g,900,100);	
    	generateTrees(g,1100,250);
    	generateTrees(g,950,450);
    	g.setColor(Color.gray);
    	g.fillRect(425,0,425,768);
    	g.setColor(Color.white);
    	g.fillRect(430,0,20,768);
    	g.fillRect(825,0,20,768);
    	for(int p=0;p<768;p+=100)
    	g.fillRect(630,p,20,70);
    	g.setColor(Color.black);
    	g.fillRect(px,py,40,70);
    	g.setColor(Color.red);
    	g.fillRect(px1,py1,40,70);
    	
    }
    public void generateTrees(Graphics g,int x,int y){
    	g.setColor(ranGreen[2]);
    for(int t=0;t<100;t+=10){
    	for(int t1=0;t1<t;t1+=10){
    		g.fillRect(x+50+t1,y+t,10,10);
    		g.fillRect(x+50-t1,y+t,10,10);
    	//	g.fillRect(x+50+t1,y+190-t,10,10);
    		//g.fillRect(x+50-t1,y+190-t,10,10);
    	}
    }
    g.setColor(new Color(139,69,19));
    g.fillRect(x+40,y+100,30,100);
    }
    
	public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
		if(keycode!=key){
			keycode = key;	
			switch(key){
				case 87:py-=10;break;
				case 38:py1-=10;break;
			}
				repaint();
		}
		if(py<=30) JOptionPane.showMessageDialog(null,"Player 1 wins");
		else if (py1<=30)JOptionPane.showMessageDialog(null,"Player 2 wins");
	}
	public void keyReleased(KeyEvent e){
		keycode=-1;
	}
	public void keyTyped(KeyEvent e){
		
	}

}