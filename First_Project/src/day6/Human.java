package day6;

class Human {

	String name;
	int age;
	String addr;
	static int publicMoney ; //회비!

	Human() {
		name = "홍길동";
		age = 10;
		addr = "인천";
	}

	Human(String name, int age, String addr) {
		this.age = age;
		this.name = name;
		this.addr = addr;

	}

	void eat(String str) {
		System.out.println(str + "밥을 먹었다!");
	};

	void study() {
		System.out.println("자바 진짜 재밌다! ㄹㅇㅋㅋ");
	};

}