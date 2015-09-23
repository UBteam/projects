import java.awt.Color;
import java.awt.Graphics;


public class Obiect {

	public int id;
	public int x;
	public int y;
	public int w;
	public int h;
	
	public boolean bifat;
	public boolean bifabil;
	
	

	
	
	public Obiect(int x, int y,int w,int h,int id){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.id=id;
		bifat=false;
		bifabil=true;
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.drawOval(x, y, w, h);
	}
	
}
