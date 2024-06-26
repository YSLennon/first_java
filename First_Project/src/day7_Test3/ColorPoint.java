package day7_Test3;

public class ColorPoint extends Point {
	private String color;
	ColorPoint(){
		super(0,0);
		color = "BLACK";
	}

	ColorPoint(int x, int y) {

		super(x, y);
		color = "BLACK";
		
	}
	ColorPoint(int x, int y, String color) {

		super(x, y);
		this.color = color;
		
	}
	@Override
	public String toString() {
		return color + "색의 ("+ getX() + "," + getY()+ ")의 점";
	}
	void setColor(String color) {
		this.color = color;
	}
	
	void setXY(int x, int y) {
		move(x, y);
	}
}