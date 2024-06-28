package day09;

public class Main {
	
	
	public static void main(String[] args) {
		

		Student s = new Student("홍길동", 30);
		Worker w = new Worker("김철수", 20);
		Researcher r = new Researcher("박영희", 25);
		Human.humanInfo(s);
		Human.humanInfo(w);
		Human.humanInfo(r);
		Orange o = new Orange("오렌지", "오렌지색", 1000);
		Apple a = new Apple("사과", "빨간색", 5000);
		Fruit.fruitBox(o);
		Fruit.fruitBox(a);		
		
		
		Dog.i = 14;
		
		
		


		
		
		
//		Banana banana = new Banana("바나나", "노란색", 1000);
//		Orange orange = new Orange("오렌지", "주황색", 1500);
//		Apple apple = new Apple("사과", "빨간색", 2000);
//		Candy candy = new Candy();
//
//		Fruit.fruitBox(banana, 10);

//		Animal animal = new Animal("동물", 5);
//        animal.info(); // 이름 : 동물, 나이: 5
//        animal.sound(); // 동물이 소리를 냅니다.
//
//        // Dog 객체 생성
//        Dog dog = new Dog("바둑이", 3, "진돗개");
//        dog.info(); // 이름 : 바둑이, 나이 : 3
//        dog.sound(); // 멍멍!
//        System.out.println("품종 : " + dog.getBreed()); // 품종 : 진돗개
//        
//        Dog dog2 = new Dog();
//        dog2.info(); // 이름 : 정보없음, 나이 : 0

	}

}
