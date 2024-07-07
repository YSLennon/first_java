package Solution.BearAndFish;

import java.awt.event.KeyEvent;

public class Bear extends GameObject {

	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}

	@Override
	protected void move(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) y -= distance;
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) y += distance;
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) x += distance;
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) x -= distance;

		if(x >= 450) x = 450;
		if(y >= 450) y = 450;
		if(x < 0) x = 0;
		if(y < 0) y =0;

	}

	@Override
	protected String getShape() {
		return "B";
	}

}
