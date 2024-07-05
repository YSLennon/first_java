package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAdapterEx extends JFrame {
	Container c;
	JLabel lb;
	JLabel lb2;
	boolean isPointer;
	final int POINTER_LOCATION = -10;

	public MouseAdapterEx() {
		setTitle("MouseAdapter");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		lb = new JLabel("No Mouse Event");
		lb.setSize(200, 30);
		lb.setLocation(150, 5);
		
		lb2 = new JLabel("");
		lb2.setSize(200,30);
		lb2.setLocation(0, 0);
		isPointer = false;
		lb2.setVisible(false);

		MouseAdapterEx1 adapter = new MouseAdapterEx1();
		c = getContentPane();
		c.setLayout(null);
		c.add(lb);
		c.add(lb2);

		c.addMouseListener(adapter);
		c.addMouseMotionListener(adapter);

		c.setFocusable(true);
		c.requestFocus();

	}

	class MouseAdapterEx1 extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {

			Container c = (Container) e.getSource();
			c.setBackground(Color.cyan);
		}

		public void mousePressed(MouseEvent e) {
			lb.setText("MousePressed(" + e.getX() + "," + e.getY() + ")");
			lb2.setText("MousePressed(" + e.getX() + "," + e.getY() + ")");
			lb2.setLocation(e.getX()-POINTER_LOCATION, e.getY()+POINTER_LOCATION);

		}
		public void mouseClicked(MouseEvent e) {
			isPointer = !isPointer;
			lb2.setVisible(isPointer);
		}

		public void mouseReleased(MouseEvent e) {
			lb.setText("MouseReleased(" + e.getX() + "," + e.getY() + ")");
			lb2.setText("mouseReleased(" + e.getX() + "," + e.getY() + ")");
			lb2.setLocation(e.getX()-POINTER_LOCATION, e.getY()+POINTER_LOCATION);

		}

		public void mouseDragged(MouseEvent e) {
			lb.setText("MouseDragged(" + e.getX() + "," + e.getY() + ")");
			lb2.setText("mouseDragged(" + e.getX() + "," + e.getY() + ")");
			lb2.setLocation(e.getX()-POINTER_LOCATION, e.getY()+POINTER_LOCATION);

		}

		public void mouseMoved(MouseEvent e) {
			lb.setText("MouseMoved(" + e.getX() + "," + e.getY() + ")");
			lb2.setText("mouseMoved(" + e.getX() + "," + e.getY() + ")");
			lb2.setLocation(e.getX()-POINTER_LOCATION, e.getY()+POINTER_LOCATION);

		}

		public void mouseExited(MouseEvent e) {
			Container c = (Container) e.getSource();
			c.setBackground(Color.yellow);
			lb2.setLocation(e.getX()-POINTER_LOCATION, e.getY()+POINTER_LOCATION);
		}

	}

	public static void main(String[] args) {
		MouseAdapterEx m = new MouseAdapterEx();
	}

}
