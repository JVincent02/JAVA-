import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Exer13c extends JFrame implements ActionListener{
	JMenuBar menubar = new JMenuBar();
	JMenu salesmenu = new JMenu("Sales Report");
	JMenu invenmenu = new JMenu("Inventory");
	JTextArea text = new JTextArea();
	JScrollPane pane = new JScrollPane(text);
	JButton returnB = new JButton("<-Return to Menu");
	public static void main(String args[]){
		new Exer13c();
	}
	public Exer13c(){
		setJMenuBar(menubar);
		menubar.add(salesmenu);
		menubar.add(invenmenu);
		invenmenu.addActionListener(this);
		salesmenu.addActionListener(this);
		add(pane,BorderLayout.CENTER);
		add(returnB,BorderLayout.SOUTH);
		setVisible(true);
		setSize(400,400);
		text.setEditable(false);
	}
	public void actionPerformed(ActionEvent e){
		
	}
}