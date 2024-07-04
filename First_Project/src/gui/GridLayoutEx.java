package gui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutEx extends JFrame {
	public GridLayoutEx() {

		setTitle("두번째 GUI");
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(4, 2);
		grid.setVgap(5);

		c.setLayout(grid);

		c.add(new JLabel("이름"));
		JTextField text = new JTextField();
		c.add(text);
		c.add(new JLabel("학번"));
		JTextField text1 = new JTextField();
		c.add(text1);
		c.add(new JLabel("학과"));
		JTextField text2 = new JTextField();
		c.add(text2);
		c.add(new JLabel("과목"));
		JTextField text3 = new JTextField();
		c.add(text3);

		
		

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridLayoutEx grid = new GridLayoutEx();

	}

}
