package day8_Test4;

public class Bear extends GameObject{

	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void move(String str) {
		if(str.equals("w")) y += distance;
		else if(str.equals("s")) y -= distance;
		else if(str.equals("d")) x += distance;
		else if(str.equals("a")) x -= distance;
		
		if(x >= 20) x = 19;
		if(y >= 10) y = 9;
		if(x < 0) x = 0;
		if(y < 0) y =0;
	}

	@Override
	protected char getShape() {
		// TODO Auto-generated method stub
		return 'B';
	}

}
