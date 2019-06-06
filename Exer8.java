import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
public class Exer8{
	static int ran1,ran2;
	public static void main(String args[]){
		Exer8 ran = new Exer8();
		JTextArea text = new JTextArea(10,20);
		JScrollPane pane = new JScrollPane(text);
		int lvl,ans,pro,slvl=1,score=0,menuSel,ranSel,sel,con=0;
	while (con==0){
		score =0;
		text.setText("");
		menuSel = displayMenu();
		slvl=selectLevel();
		lvl = (int)Math.pow(10,slvl);
		
		for(int i =1; i<=(slvl*5);i++){
				ranSel = (int)(Math.random()*4);
				if(menuSel!=4) sel = menuSel;
				else sel = ranSel;
				ran.random(sel,lvl);
				ans = askAnswer(sel,ran1,ran2);
				pro = process(sel,ran1,ran2,ans);
				JOptionPane.showMessageDialog(null,generateResponse(pro));
				text.append("No. "+i+": "+ran1+operator(sel)+ran2+" = "+ans+((pro==1)?": Correct":": Wrong")+"\n");
				score =score +pro;
		}
		text.append("\nYour Score is: "+score+" out of "+(slvl*5));
		JOptionPane.showMessageDialog(null,pane,"Math Wizard Meme Edition",JOptionPane.PLAIN_MESSAGE);
		con = JOptionPane.showConfirmDialog(null,"Do want to try again?","Math Wizard Meme Edition",JOptionPane.YES_NO_OPTION);
	}
	System.exit(0);
	}
	public static String operator(int op){
		String s="";
		switch(op){
			case 0: s=" + "; break;
			case 1: s=" - "; break;	
			case 2: s=" * "; break;
			case 3: s=" / "; break;
		}	
			return s;
	}
	public static int process(int sel,int n1,int n2,int ans){
		int proc =0;
		switch(sel){
			case 0: proc=(n1+n2==ans)? 1:0; break;
			case 1: proc=(n1-n2==ans)? 1:0; break;
			case 2: proc=(n1*n2==ans)? 1:0; break;
			case 3: proc=(n1/n2==ans)? 1:0; break;
		}
		return proc;
	}
	public static int askAnswer(int sel,int n1,int n2){
		String ask ="Evaluate:\n \n";
		String s="";
		switch(sel){
			case 0: ask += n1+" + "+n2; 	break;
			case 1: ask += n1+" - "+n2;	break;
			case 2: ask += n1+" * "+n2;	break;
			case 3: ask += n1+" / "+n2;	break;	
		}
		s= JOptionPane.showInputDialog(ask+"\n");
		if(s==null||s.isEmpty())System.exit(0);
		return Integer.parseInt(s);
	}
	public static String generateResponse(int state){
		int r1 = (int)(Math.random()*4);
		String response ="";
		if(state==1){
			switch(r1){
				case 0: response= "You sir are a legend"; break;
				case 1: response= "Advance ka mag-isip!"; break;
				case 2: response= "Keep it up brudda!"; break;
				case 3: response= "That's my boi!"; break;
			}
		}else{
			switch(r1){
				case 0: response= "Agik! Anu ginagawa mu?"; break;
				case 1: response= "Do u know da wae??"; break;
				case 2: response= "Omae wa mou shindeiru"; break;
				case 3: response= "Weakness disgusts me"; break;
			}				
		}
		return response;
	}
	public static int displayMenu(){
		int response =0;
		String s=""; 
		while(response<1||response>5){
			s= JOptionPane.showInputDialog("Math Wizard Meme Edition\n \nType [1] - Addition \nType [2] - Subtraction \nType [3] - Multiplication \nType [4] - Division \nType [5] - Mixed Operations \nCancel to Exit \n ");
			if (s==null||s.isEmpty()) System.exit(0);
			response = Integer.parseInt(s);
		}
		return response-1;
	}
	public static int selectLevel(){
		int level =0;
		String s=""; 
		while(level<1||level>3){
			s= JOptionPane.showInputDialog("Select Level (1-3)");
			if (s==null||s.isEmpty()) System.exit(0);
			level = Integer.parseInt(s);
		}
		return level;
	}
	public void random(int x,int lvl){
		ran1=0;
		ran2=0;
		switch(x){
			case 0: {
			while((ran1==0)||(ran2==0)){
				ran1 = (int)(Math.random()*(lvl));
				ran2 = (int)(Math.random()*(lvl));
			}
				break;
			}
			case 1: {
			while((ran1==0)||(ran2==0)||ran1<ran2){
				ran1 = (int)(Math.random()*(lvl));
				ran2 = (int)(Math.random()*(lvl));
			}
				break;
			}
			case 2: {
			while((ran1==0)||(ran2==0)){
				ran1 = (int)(Math.random()*(lvl));
				ran2 = (int)(Math.random()*(lvl));
			}
				break;
			}
			case 3: {
			while((ran1==0)||(ran2==0)||(ran1==ran2)||((ran1%ran2)!=0)){
				ran1 = (int)(Math.random()*(lvl));
				ran2 = (int)(Math.random()*(lvl));
			}
				break;
			}
		}
			
	}
	
}