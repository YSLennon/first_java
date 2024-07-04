package gui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FreeContentLayout extends JFrame {
	
	public FreeContentLayout() {


		setTitle("new title");
		Container c = getContentPane();
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel l = new JLabel("Hello Java!");
		l.setLocation(500,300);
		l.setSize(200,50);
		c.add(l);
		for(int i =1 ;i<9 ; i++ ) {

			JButton b = new JButton("Button " + String.valueOf(i));
			b.setSize(100,50);
			b.setLocation(i*100,i*50);
			c.add(b);
				
		}
		
		setSize(900,900);
		setVisible(true);
		
		
		
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		FreeContentLayout c = new FreeContentLayout();
	}

}
