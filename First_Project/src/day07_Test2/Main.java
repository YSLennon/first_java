package day07_Test2;

public class Main {
	

	static void fruitBox(Fruit f, int numb) {
		if (f instanceof Banana) System.out.println(f + " " + numb + "개를 바나나상자에 담았습니다.");
		if (f instanceof Orange) System.out.println(f + " " + numb + "개를 오렌지상자에 담았습니다.");
		if (f instanceof Apple) System.out.println(f + " " + numb + "개를 사과상자에 담았습니다.");
		
//		System.out.println(f + " " + numb + "개를 상자에 담았습니다.");
		
	}

	public static void main(String[] args) {

		Banana banana = new Banana("바나나", "노란색", 1000);
		Orange orange= new Orange("오렌지", "주황색", 1500);
		Apple apple= new Apple("사과", "빨간색", 2000);
		
		fruitBox(banana, 10);
	}


	

}