import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Exer11 extends JFrame implements ActionListener {
	JTextField resField = new JTextField(20);
	JTextArea textArea = new JTextArea(10,20);
	JScrollPane scrollPane = new JScrollPane(textArea);
	JButton lot1Button = new JButton("6/45");
	JButton lot2Button = new JButton("6/48");
	JButton lot3Button = new JButton("6/49");
	public static void main(String args[]){
		new Exer11();
	}
	
	
	public Exer11(){
		Container con = getContentPane();
		Color color = new Color(02,53,79);
		con.setLayout(new FlowLayout());
		con.setBackground(color);
		con.add(resField);
		con.add(scrollPane);
		con.add(lot1Button);
		con.add(lot2Button);
		con.add(lot3Button);
		lot1Button.addActionListener(this);
		lot2Button.addActionListener(this);
		lot3Button.addActionListener(this);
		setVisible(true);
		setResizable(false);
		setTitle("Lotto");
		setLocation(600,350);
		setSize(250,270);
	}
	public void actionPerformed(ActionEvent e){
		int sel=0;
		String s ="",t="6/45\n";
		if(e.getSource()==lot2Button) {
			sel=1; 
			t="6/48\n";
		}
		else if(e.getSource()==lot3Button) {
			sel=2; 
			t="6/49\n";
		}	
		s = append(results(sel));	 
		resField.setText(s);
		textArea.append(s+" : "+t);
	}

	public static int[] results(int lot){
		int[] ran = new int[6];
		int max=44;
			switch(lot){
				case 0:max=44; break;
				case 1:max=47; break;
				case 2:max=48; break;		
				}
			for(int i=0;i<ran.length;i++){
				ran[i] = 1+(int)(Math.random()*max);
				for(int a=i;a>=0;a--){
					if(ran[i]==ran[a]&&a!=i) {
						a=-1;
						i--;
					}
				}
			}
		return ran;
	}
	public static String append(int[] random){
		String s ="";
		for(int i=0;i<random.length;i++) s+=random[i] +"     ";
		return s;
	}
}