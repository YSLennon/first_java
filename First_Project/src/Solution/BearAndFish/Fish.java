package Solution.BearAndFish;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Fish extends GameObject {

	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}

	@Override
	protected void move(KeyEvent e) {
		Random ran = new Random();
		if(ran.nextInt(2)==1){
			int ranNumb = ran.nextInt(39)+1;
			switch(ranNumb/10) {
				case 3:
					y = (ranNumb%2 == 1)? y + distance*2 : y + distance ;
					break;
				case 2:
					y = (ranNumb%2 == 1)? y - distance*2 : y - distance ;
					break;
				case 1:
					x = (ranNumb%2 == 1)? x + distance*2 : x + distance ;
					break;
				case 0:
					x = (ranNumb%2 == 1)? x - distance*2 : x - distance ;
					break;
			}
			if(x >= 450) x = 450;
			if(y >= 450) y = 450;
			if(x < 0) x = 0;
			if(y < 0) y =0;
		}
		
		
		
		
	}

	@Override
	protected String getShape() {
		return "@";
	}

}
