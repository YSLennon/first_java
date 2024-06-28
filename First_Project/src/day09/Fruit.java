package day09;



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
	static void fruitBox(Fruit f) {
		if(f instanceof Orange) System.out.println("오렌지는 맛있다.");
		if(f instanceof Banana) System.out.println("바나나는 길다");
		if(f instanceof Apple) System.out.println("사과는 비싸다");
//		System.out.println(f + " " + numb + "개를 상자에 담았습니다.");
		
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