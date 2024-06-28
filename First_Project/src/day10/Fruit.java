package day10;



public class Fruit {
	String name;
	String color;
	int price;

	Fruit(String name, String color, int price) {
		this.name = name;
		this.color = color;
		this.price = price;

	}
	@Override
	public boolean equals(Object obj) {
		Fruit f = (Fruit) obj;
		if(this.name == f.name) return true; else return false;
		// classCastException 발생하니까 instanceof를 통해서 조건분기를 잡아줘야함. 안그럼 Object에 다른 객체가 들어왔을 때 에러 발생.
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
	void print() {
		System.out.println("과일은 맛있다");
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
	@Override
	public String toString() {
		
		
		return name+" Class";
		
	}
	@Override
	void print() {
		System.out.println("사과 비싸네;");
	}
}