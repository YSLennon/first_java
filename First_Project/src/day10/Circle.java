package day10;

public class Circle {
	int x;
	int y;
	int radius;

	Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle(" + x + "," + y + ")반지름 " + radius;
	}
	@Override public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle c = (Circle) obj;
			return this.x == c.x && this.y == c.y ;
		} else {
			System.out.println("다른 타입의 값은 비교할 수 없습니다.");
			return false;	
		}
	
		 
	}

}
