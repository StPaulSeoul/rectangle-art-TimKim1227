import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Shell extends JPanel{
	public static Dimension size;
	
	public Shell(){
		super();
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		double domain = 5000;
		double range = 5000;
		
		for(int i=0;i<domain;i++){
				Rectangle2D r = new Rectangle2D.Double(1,(size.getHeight()/range) * function(i),1000,1);
				g2.fill(r);
		}
		
	}
	
	public void setupDisplay(){
		JFrame application = new JFrame();
		application.add(this);
		application.setSize(1366,768);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true);
		application.setVisible(true);
		size = application.getSize();
	}
	
	public static void main(String[] ARGS){
		Shell program = new Shell();
		program.setupDisplay();
		program.repaint();
	}
	
	public static double function(double x){
		x = Math.pow(Math.E,x*0.15);
		return x;
	}
}
