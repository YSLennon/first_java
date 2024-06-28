package day07_Test3;

public class PositivePoint extends Point {

	PositivePoint() {
		super(0, 0);
	}

	PositivePoint(int x, int y) {
		super(x, y);

		int i = (x<0)? 0 : x;
		int j = (y<0)? 0 : y;
		super.move(i, j);

	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")의 점";
	}

	@Override
	protected void move(int x, int y) {
		if (x >= 0 && y >= 0)
			super.move(x, y);

	}

}
