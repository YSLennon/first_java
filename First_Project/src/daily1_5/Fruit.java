package daily1_5;

public class Fruit {

	String name;
	private int price;

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

	void setPrice(int price) {
//		if (권한 == "관리자" || 권한 == "판매자") {

			if (price <= 0) {
				System.out.println("가격을 다시 확인해주세요.");
			} else {
				this.price = price;
			}

//		} else System.out.println("수정할 권한이 없습니다.");
	}

}
