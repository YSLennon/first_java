package day10;

public class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof MyPoint) {
			MyPoint p = (MyPoint) obj;
			return this.x == p.x && this.y == p.y;
		} else {
			System.out.println("다른 타입의 값은 비교가 불가능합니다.");
			return false;
		}
		
		
	}

	@Override
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}
}
