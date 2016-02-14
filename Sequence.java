package package1;

import javax.swing.JFrame;

public class Sequence{
	
	

	public static void main (String[] args){
		
		Sequence game = new Sequence();
		
		JFrame frame = new JFrame ("Sequence");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false);
				
		frame.setSize(600, 600);
		frame.setVisible(true);
		
	}

}
