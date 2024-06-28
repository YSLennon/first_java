package day08_Test4;

import java.util.Random;

public class Fish extends GameObject{

	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void move(String str) {
		Random ran = new Random();
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
		if(x >= 20) x = 19;
		if(y >= 10) y = 9;
		if(x < 0) x = 0;
		if(y < 0) y =0;
		
		
		
		
	}

	@Override
	protected char getShape() {
		// TODO Auto-generated method stub
		return '@';
	}

}
