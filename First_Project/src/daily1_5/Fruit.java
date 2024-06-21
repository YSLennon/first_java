package daily1_5;

public class Fruit {

	String name;
	int price;

	Fruit() {

	}

	Fruit(String name) {
		this.name = name;

	}

	Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}

	int getPrice(int numb) {
		return price * numb;
	}

}
