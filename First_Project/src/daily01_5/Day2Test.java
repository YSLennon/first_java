package daily01_5;

import java.util.Random;
import java.util.Scanner;

public class Day2Test {
	
	
	public static void main(String[] args) {

		addedTest1();
		addedTest2();
		addedTest3();
	}

	 static void test1() {

		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력해주세요");
		int point = scan.nextInt();

		if (point > 100 || point < 0) {
			System.out.println("잘못된 숫자 범위 입니다.");
		} else if (point >= 80) {
			System.out.println("A");
		} else if (point >= 60) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
	}

	static void test2() {

		Scanner scan = new Scanner(System.in);

		System.out.print("숫자를 입력해주세요: ");
		int numb = scan.nextInt();

		for (int i = 1; i < 10; i++) {

			System.out.println(numb + "*" + i + " = " + (i * numb));
		}

	}
	
	static void test3() {
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요: ");
		int numb = scan.nextInt();
		
		for(int i = 1 ; i<=numb ; i++) {
			
			sum += i;
			
		}
		
		System.out.println(sum);
		
		
	}
	static void addedTest1() {

		for(int i = 1 ; i < 31 ; i++) {
			if(i % 3 == 0 || i % 7 == 0) System.out.println(i);
		}
	}


	static void addedTest2() {
	
	int sum = 0;
	for(int i = 1 ; i < 31 ; i++) {
		if(i % 2 == 1) sum += i;
		else sum -= i;
	}
	Math.abs(sum);
	System.out.println(sum);
}



	static void addedTest3() {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	
	int point = 0;
	for(int i =1;i <6;i++) {

		int ranNumb1 = ran.nextInt(2,10);
//		int ranNumb1 = ran.nextInt(8)+2;
		int ranNumb2 = ran.nextInt(2,10);
//		int ranNumb2 = ran.nextInt(9)+1;
		
		System.out.print(ranNumb1 +" * "+ ranNumb2 +" = ");
		int answer = scan.nextInt();
		
		if(answer == ranNumb1*ranNumb2) {
			System.out.println("정답 !");
			point += 20;
			
		} else System.out.println(" 오답 ! 정답은 : " + ranNumb1*ranNumb2+ " 입니다");
			
	}
	System.out.println("5문제 풀이 끝!\n60점 입니다! (한문제당 20점)");
	
	
}


	
	
}
