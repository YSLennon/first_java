package daily1_5;

import java.util.Random;
import java.util.Scanner;

public class Day3 {
	public static void main(String[] args) {

		while_4();
	}

	// infinityRoof에서 자주 사용됨
	static void while_1() {

		int i = 1;
		while (i <= 10) {
			System.out.println(i);

			i++;

		}

	}

	// 구구단 만들기
	static void while_2() {
		Random ran = new Random();
		Scanner s = new Scanner(System.in);

		int i = 1;
		int score = 0;

		while (i <= 5) {

			int x = ran.nextInt(8) + 2;
			int y = ran.nextInt(9) + 1;

			System.out.print(x + " * " + y + " = ");
			int answer = s.nextInt();

			if (answer == x * y) {
				score += 20;
				System.out.println("정답!");
			} else {
				System.out.println("오답! 정답은 " + (x * y) + " 입니다.");
			}

			i += 1;
		}
		System.out.println("점수는 " + score + "점 입니다.");

	}

	static void while_3() {

		do {

			System.out.println("안녕");
		} while (false);

	}

	static void while_4() {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int choice;
		int solvedQuestion = 0;
		int question = 0;

		do {
			System.out.print("구구단 시작(1),채점(2), 종료(0): ");
			choice = scan.nextInt();
			if (choice == 1) {
				System.out.print("풀고싶은 문항 수를 적어주세요: ");
				int questionNumb = scan.nextInt();
				question += questionNumb;

				for (int i = 1; i <= questionNumb; i++) {
					int x = ran.nextInt(8) + 2;
					int y = ran.nextInt(9) + 1;

					System.out.println(x + " * " + y + " = ");
					int answer = scan.nextInt();
					if (answer == x * y) {
						System.out.println("정답!");
						solvedQuestion += 1;
					} else {
						System.out.println("오답입니다. 한 번 다시 풀어보시겠습니까? \n 다시 푸시려면 1번, 아니면 숫자를 입력해주세요");
						int retry = scan.nextInt();
						if (retry == 1) {
							System.out.println(x + " * " + y + " = ");
							answer = scan.nextInt();
							if (answer == x * y) {
								System.out.println("정답!");
								solvedQuestion += 1;
							} else System.out.println("오답입니다! 다시 공부하세요!");
						}

					}
				}
			} else if (choice == 2) {
				System.out.println("현재까지 " + question + "문제 중 " + solvedQuestion + "문제 맞히셨습니다.");

			} else if (choice == 0) {
				System.out.println("프로그램이 종료되었습니다.");

			} else {
				System.out.println("잘못된 입력입니다.");
			}

		} while (choice != 0);

	}

//	전역변수개념~
	static void var_1() {

		int num = 10;
		if (true) {
			num = 20;
		}
		// 마지막 증감시 i++로 i가 11이 된 채로 바깥에서 읽어진다. 헷갈리지 않게 조심하도록
		int i;
		for (i = 1; i <= 10; i++) {

		}
		System.out.println(i);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
