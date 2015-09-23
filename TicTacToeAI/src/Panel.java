import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;



public class Panel extends JPanel implements MouseListener{
	public static Grid [][] grid = new Grid[3][3];
	public boolean xturn = false;
	public boolean win = false;
	public static int x,y;
    public boolean first=true;
    public int counting=0;
    

	

	// it's 0 turn now;
	public Panel(){
		
		
		this.setPreferredSize(new Dimension(290,290));
		//size to 300x300
		define();
	
		
		
	}
	
	
	

	
	public void define(){
		
		for(int x=0;x<3;x++){
			for(int y=0;y<3;y++){
				grid[x][y]=new Grid(0);
				
			}
		}
	}
	
	
	

	public void EndGame(){ //castiga sau blocheaza
		
		if(counting==8){
			for(int x=0; x<3;x++){
				for(int y=0;y<3;y++){
					if(grid[x][y].ID==0){
						grid[x][y].ID=2;
					}
				}
			}
		}
	
	}

	
	
	public void paintComponent(Graphics g){

		for(int x=0; x<3; x++){
			for(int y=0;y<3;y++){
				//gridul
				
				g.drawRect(x*100,y*100,100,100);
				
				
						
						
						if(grid[x][y].ID==1){
							
							g.setColor(Color.RED);
							g.fillRect(x*100,y*100,100,100);
							
							//randul
						}else if(grid[x][y].ID==2 ){
							g.setColor(Color.BLUE);
							g.fillRect(x*100,y*100,100,100);
						}
						
					}
			
					
				grid[0][0].ID =2;//aici incepe calculatorul
		
	
	                      EndGame();//blocheaza sau castiga
		System.out.println(counting);
		
	repaint();
	}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// when the mouse is pressed
		
		
		 x = (int)e.getX()/100;
		 y = (int)e.getY()/100;
		
		System.out.println(x +""+ y + " " + grid[x][y].ID );
		//convert the mouse coords in 0-3 range instead of 0-300
		
	
		
			if(grid[x][y].ID == 0) {
				if(xturn==false){
					xturn=true;
					grid[x][y].ID=1;
					counting++;
				
				
				}
				counting++;
				computerturn();
			}
		
	}
	
	public int []  winningsituation(int color){
		int [] em = {};	
		////////////////////////line cheking number 1///////////////////////////
		if(grid[0][0].ID==color && grid[1][0].ID==color && grid[2][0].ID==0){
			grid[2][0].ID=color;
			int [] variabila = {2,0};
			return variabila;
			
		}else 	if(grid[0][0].ID==color && grid[1][0].ID==0 && grid[2][0].ID==color){
			grid[1][0].ID=color;
			int [] variabila = {1,0};
			return variabila;
			
			
		}else 	if(grid[0][0].ID==0 && grid[1][0].ID==color && grid[2][0].ID==color){
			grid[0][0].ID=color;
			int [] variabila = {0,0};
			return variabila;
			
			
		}
		
		////////////////////////end line cheking number 1///////////////////////////
		////////////////////////line cheking number 2///////////////////////////
		if(grid[2][1].ID==color && grid[1][1].ID==color && grid[0][1].ID==0){
			grid[0][1].ID=color;
			int [] variabila = {0,1};
			return variabila;
			
		}else 	if(grid[1][1].ID==color && grid[0][1].ID==color && grid[2][1].ID==0){
			grid[2][1].ID=color;
			int [] variabila = {2,1};
			return variabila;
			
			
		}else 	if(grid[0][1].ID==color && grid[2][1].ID==color && grid[1][1].ID==0){
			grid[1][1].ID=color;
			int [] variabila = {1,1};
			return variabila;
			
			
		}
		
		
		////////////////////////end line cheking number 2///////////////////////////
		///////////////////////line cheking number 3///////////////////////////
		if(grid[1][0].ID==color && grid[1][1].ID==color && grid[1][2].ID==0){
			grid[1][2].ID=color;
			int [] variabila = {1,2};
			return variabila;
			
		}else 	if(grid[1][0].ID==color && grid[1][2].ID==color && grid[1][1].ID==0){
			grid[1][1].ID=color;
			int [] variabila = {1,1};
			return variabila;
			
			
		}else 	if(grid[1][1].ID==color && grid[1][2].ID==color && grid[1][0].ID==0){
			grid[1][0].ID=color;
			int [] variabila = {1,0};
			return variabila;
			
			
		}
		
		////////////////////////line cheking number 4///////////////////////////
		if(grid[0][2].ID==color && grid[1][2].ID==color && grid[2][2].ID==0){
		grid[2][2].ID=color;
		int [] variabila = {2,2};
		return variabila;
		
		}else 	if(grid[2][2].ID==color && grid[0][2].ID==color && grid[1][2].ID==0){
		grid[1][2].ID=color;
		int [] variabila = {1,2};
		return variabila;
		
		
		}else 	if(grid[1][2].ID==color && grid[2][2].ID==color && grid[0][2].ID==0){
		grid[0][2].ID=color;
		int [] variabila = {0,2};
		return variabila;
		
		
		}
		///////////////////////line cheking number 4///////////////////////////
		
		
		////////////////////////line cheking number 5///////////////////////////
		if(grid[0][0].ID==color && grid[0][1].ID==color && grid[0][2].ID==0){
		grid[0][2].ID=color;
		int [] variabila = {0,2};
		return variabila;
		
		}else 	if(grid[0][0].ID==color && grid[0][2].ID==color && grid[0][1].ID==0){
		grid[0][1].ID=color;
		int [] variabila = {0,1};
		return variabila;
		
		
		}else 	if(grid[0][2].ID==color && grid[0][1].ID==color && grid[0][0].ID==0){
		grid[0][0].ID=color;
		int [] variabila = {0,0};
		return variabila;
		
		
		}
		///////////////////////line cheking number 5///////////////////////////
		
		////////////////////////line cheking number 6///////////////////////////
		if(grid[2][0].ID==color && grid[2][1].ID==color && grid[2][2].ID==0){
		grid[2][2].ID=color;
		int [] variabila = {2,2};
		return variabila;
		
		}else 	if(grid[2][0].ID==color && grid[2][2].ID==color && grid[2][1].ID==0){
		grid[2][1].ID=color;
		int [] variabila = {2,1};
		return variabila;
		
		
		}else 	if(grid[2][2].ID==color && grid[2][1].ID==color && grid[2][0].ID==0){
		grid[2][0].ID=color;
		int [] variabila = {2,0};
		return variabila;
		
		
		}
		///////////////////////line cheking number 6///////////////////////////
		
		////////////////////////line cheking number 7///////////////////////////
		if(grid[2][2].ID==color && grid[1][1].ID==color && grid[0][0].ID==0){
		grid[0][0].ID=color;
		int [] variabila = {0,0};
		return variabila;
		
		}else 	if(grid[2][2].ID==color && grid[0][0].ID==color && grid[1][1].ID==0){
		grid[1][1].ID=color;
		int [] variabila = {1,1};
		return variabila;
		
		
		}else 	if(grid[0][0].ID==color && grid[1][1].ID==color && grid[2][2].ID==0){
		grid[2][2].ID=color;
		int [] variabila = {2,2};
		return variabila;
		
		
		}
		///////////////////////line cheking number 7///////////////////////////
		
		////////////////////////line cheking number 8///////////////////////////
		if(grid[2][0].ID==color && grid[1][1].ID==color && grid[0][2].ID==0){
		grid[0][2].ID=color;
		int [] variabila = {0,2};
		return variabila;
		
		}else 	if(grid[2][0].ID==color && grid[0][2].ID==color && grid[1][1].ID==0){
		grid[1][1].ID=color;
		int [] variabila = {1,1};
		return variabila;
		
		
		}else 	if(grid[0][2].ID==color && grid[1][1].ID==color && grid[2][0].ID==0){
		grid[2][0].ID=color;
		int [] variabila = {2,0};
		return variabila;
		
		
		}
		///////////////////////line cheking number 8///////////////////////////
		
		// de facut pt toate liniile si diagonalele si coloanele si toate astea intr-o functie
	return em;
	}
	

	private void computerturn() {
		
		if(xturn==true){
			xturn=false;
			int [] rezult= winningsituation(2);//for player
			
			if(rezult.length>0){//block the player
				grid[rezult[0]][rezult[1]].ID=2;
			
				
				return;
				
			}else{
				rezult=winningsituation(1);//for computer
				if(rezult.length>0){//win for computer
					grid[rezult[0]][rezult[1]].ID=2;
					win=true;
					
					return;
				}
				
			}
		     
			//mereu o sa puna dreapta jos iar daca e ocupat o sa puna dreapta sus 
			
				if(grid[2][2].ID==0){
					grid[2][2].ID=2;
					return;
				}else if(grid[2][0].ID==0){
					grid[2][0].ID=2;
					return;
				}else if(grid[0][2].ID==0){
					grid[0][2].ID=2;
				}
							
		}
		
	}





	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
