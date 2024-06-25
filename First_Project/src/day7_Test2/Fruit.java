package day7_Test2;

public class Fruit {
	String name;
	String color;
	int price;

	Fruit(String name, String color, int price) {
		this.name = name;
		this.color = color;
		this.price = price;

	}
	public String toString() {
		return name;
	}

	void getPrice() {
		System.out.println(name + " (은)는 " + price + "원 입니다.");
	}
}

class Banana extends Fruit {
	Banana(String name, String color, int price){
		super(name, color, price);
	}
}
class Orange extends Fruit {
	Orange(String name, String color, int price){
		super(name, color, price);
	}
}
class Apple extends Fruit {
	Apple (String name, String color, int price){
		super(name, color, price);
	}
}