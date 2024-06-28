package daily01_5;

import java.util.HashMap;
import java.util.Scanner;


public class Day5 {

	public static void main(String[] args) {

		Calculator_1 calc = new Calculator_1();
		System.out.println(calc.sum(10,3));

		
		
		
		
		
////		Human hong = new Human(1, "철수");
//		Human hong = new Human();
//		Human yu = new Human(15, "유재석");
//		
////		hong.name = "김철수";
//		hong.eat("아침");
//		hong.study();
//		System.out.println(hong.name);

	}

	static void switch_case3() {
		Scanner scan = new Scanner(System.in);

		System.out.print("첫번째 숫자: ");
		int numb1 = scan.nextInt();
		scan.nextLine();
		System.out.print("두번째 숫자: ");
		int numb2 = scan.nextInt();
		scan.nextLine();
		System.out.print("연산자: ");
		String calc = scan.nextLine();

		switch (calc) {
		case "-":
			System.out.println(numb1 - numb2);
			break;
		case "+":
			System.out.println(numb1 + numb2);
			break;
		case "*":
			System.out.println(numb1 * numb2);
			break;
		case "/":
			System.out.println(numb1 / numb2);
			break;
		default:
			System.out.println("/, *, +, -중에 입력해주세요");
		}
	}

	static void switch_case2() {
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력하시오: ");
		int score = scan.nextInt();

		System.out.println(-3 / 2);
		switch (score / 10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("F");
		}

	}

	static void swit_case1() {

		// switch의 경우 break를 걸지 않으면 전부 실행된다.
		int num = 10;
		switch (num) {
		case 5:
			System.out.println("case 5");
			break;
		case 10:
			System.out.println("case 10");
			break;
		case 15:
			System.out.println("case 15");
			break;
		default:
			System.out.println("case default");
			break;
		}

		int i = 0;
		switch (i) {
		case 1 -> System.out.println(i);

		case 2 -> System.out.println(i + 1);
		case 3 -> System.out.println(i);
		default -> System.out.println("not");
		}
	}

}
class Human {

	String name;
	int age;
	String address;
	Human() {
		System.out.println("생성자다!");
		name = "홍길동";
		age = 10;
		address = "인천";
	}

	Human(int age, String name) {
		System.out.println("생성자다!2");
		this.age = age;
		this.name = name;

	}


	void eat(String str) {
		System.out.println(str +"밥을 먹었다!");
	};

	void study() {
		System.out.println("자바 진짜 재밌다! ㄹㅇㅋㅋ");
	};

}
