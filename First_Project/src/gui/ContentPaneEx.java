package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame{
	
	ContentPaneEx(){
		setTitle("두번째 GUI");
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setBackground(Color.DARK_GRAY);
		// FlowLayout(정렬기준, marginSide, marginTopBottom)
//		c.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		// BorderLayout
		c.setLayout(new BorderLayout(40,40));
		
		// Flow
//		c.add(new JButton("버튼1"));
//		c.add(new JButton("버튼1"));
//		c.add(new JButton("버튼2"));
//		c.add(new JButton("버튼3"));
		
		//Border
		c.add(new JButton("버튼1"), BorderLayout.WEST);
		c.add(new JButton("버튼2"), BorderLayout.CENTER);
		c.add(new JButton("버튼3"), BorderLayout.SOUTH);
		c.add(new JButton("버튼4"), BorderLayout.NORTH);
		c.add(new JButton("버튼5"), BorderLayout.EAST);

		
		
		
		
		setSize(300,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ContentPaneEx();
		
	}
	

}
