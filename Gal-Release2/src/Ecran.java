import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Ecran extends JPanel implements Runnable{

	Thread fir = new Thread(this);
	
	public int x,x2;
	public int y,y2;
	public static int coloana = 5;
	public static int rand = 3;
	public byte contor;
	public byte contorCastig = 0;
	
	public Obiect matrice[][] = new Obiect[coloana][coloana];
	
	public Image background_image;
	public Image button_image;
	
	public static byte tura=1;
	
	public boolean odata=true;
	public boolean conditieOdata=true;
	public boolean turaOdata = false;
	public boolean turaIncaOdata = true;
	
	public static final byte marimeCerc=60;
	public static final byte spatiuButon = 30;
	public static final int lungimeButon = 150 , latimeButon = 35;
	
	public String jucator = "Player 1";
	
	public void instantiereMatrice(){
		background_image = new ImageIcon("res/background.png").getImage();
		button_image = new ImageIcon("res/button.png").getImage();
		for(int j=0;j<coloana;j++){
			for(int i=0;i<coloana;i++){
				matrice[i][j]=new Obiect(i*marimeCerc,j*marimeCerc,marimeCerc,marimeCerc,0);
				}
			}
	}
	
	
	public void conditie(){
		if(contor==1){
			if(conditieOdata==true){
			int z=3;
			for(int j=0;j<3;j++){
				for(int i=0;i<z;i++){
						matrice[i][j].bifabil=false;
					}
				z++;
				}
			conditieOdata=false;
		}else if(matrice[x][y].bifat==true){
			if(x<coloana-1)
			matrice[x+1][y].bifabil=true;
			if(y<rand-1)
			matrice[x][y+1].bifabil=true;
		}
			
	}else if(contor==2){
		if(x!=0 & x<coloana-1 && matrice[x][y].bifat==true && matrice[x-1][y].bifat==true){
			matrice[x-1][y+1].bifabil=false;
		}else if(y<rand && matrice[x][y].bifat==true && matrice[x][y-1].bifat==true){
						matrice[x+1][y-1].bifabil=false;
		}
		contor++;
		}else if(contor>2){
			if(x!=0 & x<coloana-1 && matrice[x][y].bifat==true && matrice[x-1][y].bifat==true){
				matrice[x+1][y].bifabil=true;
			}else if(y<rand && matrice[x][y].bifat==true && matrice[x][y-1].bifat==true){
				matrice[x][y+1].bifabil=true;
			}
		}			
}
	
	public Ecran(){
		fir.start();
		addMouseListener(new Click());
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(background_image, 0, 0,getWidth(),getHeight(),null);
		g.drawRect(marimeCerc * coloana + spatiuButon,spatiuButon,lungimeButon,latimeButon);
		g.drawImage(button_image,marimeCerc * coloana + spatiuButon,spatiuButon,lungimeButon,latimeButon,null);
		g.setFont(new Font("Courier New",Font.BOLD,12));
		g.drawString("End turn of " + jucator ,marimeCerc * coloana + spatiuButon + 10,spatiuButon + 20);
		g.drawRect(marimeCerc * coloana + spatiuButon,spatiuButon*2+10,lungimeButon,latimeButon);
		g.drawImage(button_image,marimeCerc * coloana + spatiuButon,spatiuButon*2+10,lungimeButon,latimeButon,null);
		g.drawString("Reset Game",marimeCerc * coloana + spatiuButon + 40,spatiuButon*2 + 30);
		g.drawRect(marimeCerc * coloana + spatiuButon,spatiuButon*3+20,lungimeButon,latimeButon);
		g.drawImage(button_image,marimeCerc * coloana + spatiuButon,spatiuButon*3+20,lungimeButon,latimeButon,null);
		g.drawString("Reset Turn",marimeCerc * coloana + spatiuButon + 40,spatiuButon*3 + 40);
	if((Click.x<rand && Click.y<rand) || (Click.x==rand && Click.y==1) || (Click.x==rand && Click.y==2) || (Click.x==rand+1 && Click.y==2) ){
		x=Click.x;
		y=Click.y;
	}	
	x2=Click.x2;
	y2=Click.y2;
	if(odata==true){
			odata=false;
			instantiereMatrice();
	}
	
	if(Click.odata==false){
		if((x<rand && y<rand) || (x==rand && y==1) || (x==rand && y==2) || (x==rand+1 && y==2) ){
			if(matrice[x][y].bifabil && matrice[x][y].id==0){
				matrice[x][y].id=tura;
				matrice[x][y].bifabil=false;
				matrice[x][y].bifat=true;
				contor++;
				turaOdata = true;
				Click.odata = true;
				contorCastig++;
			}
		}
	}
	
	if(( turaOdata && x2>coloana * marimeCerc && y2 > spatiuButon && x2<coloana * marimeCerc + lungimeButon && y2<spatiuButon + latimeButon)){
		x = 6;
		y = 6;
		if(turaIncaOdata){
		turaUrmatoare();
		}
		Click.x2=0;
		
	}
	if(turaOdata && x2>coloana * marimeCerc && y2 > spatiuButon + latimeButon + 10 && x2<coloana * marimeCerc + lungimeButon && y2<spatiuButon + latimeButon*2 +20){
		x = 6;
		y = 6;
		instantiereMatrice();
		conditieOdata = true;
		contor=0;
		Click.x2 = 0;
		contorCastig = 0;
	}
	if(turaOdata && x2>coloana * marimeCerc && y2 > spatiuButon + latimeButon*2 + 20 && x2<coloana * marimeCerc + lungimeButon && y2<spatiuButon + latimeButon*3 +30){
		x = 6;
		y = 6;
		resetareTura();
		Click.x2=0;
		
	}
		
		
		int z=3;
		for(int j=0;j<3;j++){
			for(int i=0;i<z;i++){
				matrice[i][j].draw(g);
				
				
				if(matrice[i][j].id==1 || matrice[i][j].id ==-1){
					g.setColor(Color.RED);
					g.fillOval(i*marimeCerc, j*marimeCerc, marimeCerc, marimeCerc);
				}else if(matrice[i][j].id==2 || matrice[i][j].id == -2){
					g.setColor(Color.BLUE);
					g.fillOval(i*marimeCerc, j*marimeCerc, marimeCerc, marimeCerc);
				}
				
			}
			z++;
		}
		conditie();
	}
	
	public void turaUrmatoare(){
		turaIncaOdata = true;
		if(tura == 1){
			jucator = "Player 1";
			tura = 2;
		}else if(tura ==2){
			jucator = "Player 2";
			tura = 1;
		}
		contor=0;
		conditieOdata=true;
		for(int j=0;j<coloana;j++){
			for(int i=0;i<coloana;i++){
				matrice[i][j].bifabil=true;
			}
		}
		for(int j=0;j<coloana;j++){
			for(int i=0;i<coloana;i++){
				if(matrice[i][j].bifat){
					matrice[i][j].bifabil=false;
				}
			}
		}
		for(int j=0;j<coloana;j++){
			for(int i=0;i<coloana;i++){
				matrice[i][j].bifat = false;
			}
		}
		for(int j=0;j<coloana;j++){
			for(int i=0;i<coloana;i++){
				if(matrice[i][j].id == 1){
					matrice[i][j].id=-1;
				}if(matrice[i][j].id == 2){
					matrice[i][j].id=-2;
				}
			}
		}
	}

	public void resetareTura(){
		for(int j=0;j<coloana;j++){
			for(int i=0;i<coloana;i++){
					if(matrice[i][j].id == 1 || matrice[i][j].id == 2){
						matrice[i][j] = new Obiect(i*marimeCerc,j*marimeCerc,marimeCerc,marimeCerc,0);
						contorCastig--;
					}
				}
			}
		for(int j=0;j<coloana;j++){
			for(int i=0;i<coloana;i++){
					matrice[i][j].bifabil=true;
					
				}
			}
		contor = 0;
		conditieOdata = true;
	}
	
	public void run() {
		while(true){
			repaint();
			if(contorCastig == 12){
				if(tura == 1){
					System.out.println(jucator + " a castigat");
				}else if(tura == 2){
					System.out.println(jucator  + " a castigat");
				}
			}
		}
		
	}

}
