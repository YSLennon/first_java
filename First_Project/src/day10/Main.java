package day10;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		MyPoint p = new MyPoint(3, 50);
		MyPoint q = new MyPoint(4, 50);
		System.out.println(p);
		if(p.equals(q)) {
			System.out.println("같은 점");
		} else {
			System.out.println("다른 점");
		}
		
		Circle a = new Circle(2, 3, 5); // 중심 (2, 3)에 반지름 5인 원
		Circle b = new Circle(2, 3, 30); // 중심 (2, 3)에 반지름 30인 원
		System.out.println("원 a : " + a);
		System.out.println("원 b : " + b);
		if(a.equals(b)){
			System.out.println("같은 원");
		} else {
			System.out.println("서로 다른 원");
		}
		

		
		
		
		
//		
//		Apple apple = new Apple("사과", "빨간색", 1000);
//		Fruit apple2= new Apple("사과", "빨간색", 1000);
//		Banana banana= new Banana("바나나", "노란색", 1500);
//		
//		banana.print();
//		apple.print();
//		apple2.print();
//		 System.out.println(apple+"입니다.");
//		 
//		Human human = new Humanimpl();
//		apple.equals(human); -> 에러 발생
		
		
		
	}

}
