package day09;

public class Dog extends Animal {
	private String category;

	Dog() {
		super("정보없음", 0);
	}

	Dog(String name, int age, String category) {
		super(name, age);
		this.category = category;
	}

	@Override
	void sound() {
		System.out.println("멍멍!");
	}

	String getBreed() {
		return category;
	}
	
	static int i = 10; 

}
