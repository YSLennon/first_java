package day09;

public class Human {
	String name;
	int age;
	
	Human(String name, int age){
		this.name = name;
		this.age = age;
	}

	static void humanInfo(Human human) {
		String getClassName = human.getClass().getSimpleName();

		System.out.println("이 객체는 "+ getClassName + " 클래스 객체 입니다.");
	}
	

}
