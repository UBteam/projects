import javax.swing.JFrame;


public class Main {
	
	public final int LUNGIME_FEREASTRA=500;
	public final int LATIME_FEREASTRA=300;

	public Main() {
		JFrame fereastra = new JFrame();
		Ecran ecran = new Ecran();
		
		
		fereastra.add(ecran);
		fereastra.setSize(LUNGIME_FEREASTRA, LATIME_FEREASTRA);
		fereastra.setVisible(true);
		fereastra.setDefaultCloseOperation(fereastra.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		Main main = new Main();

	}

}
