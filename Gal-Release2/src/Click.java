import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Click implements MouseListener{
	
	public static int x=0;
	public static int y=0;
	public static int x2,y2;
	public static boolean odata = true;
	
	

	
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	
	public void mousePressed(MouseEvent e) {
		
		x=e.getX()/Ecran.marimeCerc;
		y=e.getY()/Ecran.marimeCerc;
		x2=e.getX();
		y2=e.getY();
		
		
		System.out.println(x + " " + y);
		
		if((x<Ecran.rand && y<Ecran.rand) || (x==Ecran.rand && y==1) || (x==Ecran.rand && y==2) || (x==Ecran.rand+1 && y==2) ){
			odata = false;
		}
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

}
