

import javax.swing.JFrame;


public class Main {
	
	public Main(){
		
		Panel panel = new Panel();
		
		JFrame frame = new JFrame("Tic tac toe");
		// make and name frame
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//when exit close the program
		
		frame.add(panel);
		
		//add panel
		
		frame.pack();
		//pack it up so it shows only the panel
		
		frame.addMouseListener(panel);
		//pack it up so it only shows the panel
		
		frame.setVisible(true);
		//show the frame
		
		
		frame.setResizable(false);
		//no resezible
		
		frame.setLocationRelativeTo(null);
		//set it to center
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main();

	}

}
