package day6;

public class HumanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human hong = new Human("홍길동", 30, "인천");
		Human kim = new Human("김철수", 32, "서울");
		Human park = new Human("박영희", 25, "부천");
		
		hong.age = 40;
		park.publicMoney = 140000;
		
		System.out.println(kim.publicMoney);
		System.out.println(Math.PI);
		
		

	}

}
