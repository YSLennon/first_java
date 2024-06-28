package day08_Test5;

public class Car_Test {
	private String name;
	private String color;
	private int speed;

	Car_Test() {
		name = "기본차";
		color = "하얀색";
		speed = 0;

	}
	Car_Test(String name, String color, int speed){
		this.name = name;
		this.color = color;
		this.speed = speed;
	}

	void carInfo() {
		System.out.println("자동차의 이름은 " + name + ", 색상은 " + color + " 입니다.");
	}

	void setInfo(String name, String color, int speed) {
		this.name = name;
		this.color = color;
		this.speed = speed;
	}

	void speedUp(int addedSpeed) {
		if (speed + addedSpeed >= 200) {
			System.out.println("200 이상의 속도는 불가합니다. 200으로 변경됩니다.");
			speed = 200;
		}else speed += addedSpeed;

	}
	void speedDown(int subSpeed) {
		if (speed - subSpeed < 0) {
			System.out.println("0 미만의 속도는 불가합니다. 0으로 변경됩니다.");
			speed = 0;
		}else speed -= subSpeed;
		
	}

	int getSpeed() {
		return speed;
	}
}
