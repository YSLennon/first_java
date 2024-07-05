package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyCodeEx extends JFrame {
	Container c;
	JLabel message;

	public KeyCodeEx() {
		setTitle("Key Code 예제: 키에 따른 색 변화");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		message = new JLabel("key입력");

		message.setSize(100, 200);

		c = getContentPane();
		c.setBackground(Color.green);
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.add(message);

		c.setFocusable(true);
		c.requestFocus();

		c.addKeyListener(new KeyAdapter() {

			boolean isUnicode;

			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int keyChar = e.getKeyChar();
				message.setOpaque(false);
				isUnicode = false;

				if (!isUnicode)
					c.setBackground(Color.green);

				if (keyCode == e.VK_CONTROL) {
					message.setOpaque(true);
					message.setBackground(Color.cyan);
				}
				message.setText(e.getKeyText(keyCode) + " 키가 입력되었음");
			}

			// TODO 왜 space키에서는 keyTyped가 실행되지?
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();

				isUnicode = true;
				c.setBackground(Color.white);

				if (keyChar == '5')
					c.setBackground(Color.yellow);

			}

		});

	}

	public static void main(String[] args) {

		KeyCodeEx keyCode = new KeyCodeEx();
	}

}
