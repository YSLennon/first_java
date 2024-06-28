package daily01_5;

import java.util.Random;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		random_2();

	}

	static void if2() {

		int score = 95;
		if (score >= 90) {
			System.out.println("A");
		} else if (score <= 80) {
			System.out.println("B");
		}

	}

	static void scan1() {
		Scanner scan = new Scanner(System.in);

		int num1 = scan.nextInt();

		if (num1 % 2 == 1) {
			System.out.println("홀수입니다.");
		} else {
			System.out.println("짝수입니다.");

		}

	}

	static void for1() {

		for (int i = 10; i > 0; i--) {
//		System.out.println(i);
		}

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1)
				System.out.println(i);
		}
	}

	static void for2() {
		for (int i = 2; i <= 9; i++) {

			for (int j = 1; j <= 9; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}

	}

	static void for3() {
		int a = 0;
		for (int i = 1; i <= 2532; i++) {

			a += i;

		}
		System.out.println(a);
	}

	static void for4Break() {

		for (int i = 1; i <= 6; i++) {

			for (int j = 1; j <= 6; j++) {

				if (j == 4)
					continue;
				if (i == 5)
					continue;

				System.out.println(i * j);
			}

		}
	}
	
	
	static void for_6() {
		// 무한 루프
		Scanner scan = new Scanner(System.in);

		for(;;) {

			System.out.print("점수를 입력해주세요\n숫자 -1을 입력하면 종료");
			int score = scan.nextInt();
			if (score == -1) break;
			
			if(score > 100 | score<0) {
				System.out.println("잘못된 숫자임");
			} else if(score >= 80) {
				System.out.println("A");
			} else if(score >= 60) {
				System.out.println("B");
			} else System.out.println("C");
			
		}
		System.out.println("프로그램이 종료되었습니다.");
		
		
		
	}
	
	static void stringEquals() {
		
		Scanner scan = new Scanner(System.in);
		
//		int numb1 = 10;
//		int numb2 = scan.nextInt();
//		System.out.println(numb1 == numb2);

		String name1 = "홍길동";
		String name2 = scan.nextLine();
		System.out.println(name1 == name2);
	}

	static void random_1() {
		Math.max(1, 20);
		Math.random();
		
		Random ran = new Random();
		int numb = ran.nextInt(100); // 0부터 99까지( 100개)
		int numb2 = ran.nextInt(100)+1; // 1부터 100까지
		int numb3 = ran.nextInt(1, 101); // 1부터 100까지
		
		
		System.out.println(numb);
		
		
	}
	
	static void random_2() {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		int ranNumb= ran.nextInt(100)+1;
		int count = 0;
		
		for(;;) {
			count +=1;
			System.out.println("숫자를 입력하세요 : ");
			int input = scan.nextInt();
			if(ranNumb > input) {
				System.out.println("UP!");
			} else if(ranNumb < input) {
				System.out.println("DOWN!");
			} else {
				System.out.println("정답입니다.\n"+ count+ "번 만에 맞추셨습니다.");
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
