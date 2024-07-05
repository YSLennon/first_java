package gui;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LocationChange extends JFrame {
	Container c;
	JLabel message;
	JLabel monster;
	final int CHANGE_LOCATION = 10;

	int x;
	int y;

	public LocationChange() {
		setTitle("상,하,좌,우 키를 이용하여 텍스트 이동");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		c = getContentPane();
		c.setLayout(null);

		x = 50;
		y = 50;
		message = new JLabel("HELLO");
		message.setSize(50, 50);
		message.setLocation(x, y);

		monster = new JLabel("@");
		monster.setLocation(400, 400);
		monster.setSize(50, 50);
		c.add(monster);

		c.add(message);

		c.setFocusable(true);
		c.requestFocus();
		c.addKeyListener(new ChangeLocationKey());

	}

	class ChangeLocationKey extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			Container c = (Container) e.getSource();

			int keyCode = e.getKeyCode();

			if (keyCode == KeyEvent.VK_UP) {
				y -= CHANGE_LOCATION;
				message.setLocation(x, y);
			}
			if (keyCode == KeyEvent.VK_DOWN) {
				y += CHANGE_LOCATION;
				message.setLocation(x, y);
			}
			if (keyCode == KeyEvent.VK_RIGHT) {
				x += CHANGE_LOCATION;
				message.setLocation(x, y);
			}
			if (keyCode == KeyEvent.VK_LEFT) {
				x -= CHANGE_LOCATION;
				message.setLocation(x, y);
			}



			if (message.getLocation().x == monster.getLocation().x &&message.getLocation().y == monster.getLocation().y ) {
				monster.setText("You Win!!!");
				monster.setSize(100, 100);
			}

		}
	}

	public static void main(String[] args) {
		LocationChange location = new LocationChange();

	}

}
