import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Exer14 extends JFrame implements KeyListener{
	int x=20,y=20;
	int tx=350,ty=340;
	int fx =0;
	int keycode=-1;
	public static void main(String args[]){
		new Exer14();
	}
	public Exer14(){
		Container c = getContentPane();
		setVisible(true);
		setSize(400,400);
		Color col = new Color(0,0,0);
		c.setBackground(col);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.white);
		g.fillOval(125,150,150,200);
		g.fillOval(150,75,100,100);
		g.drawLine(200,340,tx,ty);
		g.drawLine(180,90,fx+140,50);
		g.drawLine(160,100,fx+140,50);
		g.drawLine(220,90,fx+260,50);
		g.drawLine(240,100,fx+260,50);
		g.setColor(Color.black);
		g.fillOval(fx+170,110,15-((fx<0)?fx*-1:fx),15);
		g.fillOval(fx+210,110,15-((fx<0)?fx*-1:fx),15);
		g.fillOval(fx+190,130,15,15);
		g.setColor(Color.blue);
		g.fillOval(x,y,10,10);
	}
	public void keyPressed(KeyEvent e){	
		int key = e.getKeyCode();
		if(keycode!=key){
			keycode = key;	
			switch(key){
				case 38:tx=320;ty=240;break;
			//	case 40:y+=10;break;
				case 37:fx-=10;break;
				case 39:fx+=10;break;
			}
			repaint();
		}
	}

	public void keyReleased(KeyEvent e){
					System.out.println(e.getKeyCode());
	if(e.getKeyCode()==38){
		tx=350;
		ty=340;
	}
	if(e.getKeyCode()==37||e.getKeyCode()==39)
		fx=0;
		keycode=-1;
		repaint();
	}
	public void keyTyped(KeyEvent e){
		
	}
}

