package javaTest0710;

import java.util.Random;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		// 번 반복

		int repeat = 5;
		int goodAnswer = 0;
		int wrongAnswer = 0;
		while (repeat > 0) {

			int numb = ran.nextInt(1,9) + 1;
			int numb2 = ran.nextInt(9) + 1;
			System.out.print(numb + " * " + numb2 + " = ");
			int answer = scan.nextInt();
			if (answer == numb * numb2) {
				goodAnswer++;
				System.out.println("정답!");
				if (goodAnswer >= 3) {
					System.out.println("3 문제 모두 맞추셨습니다. 종료되었습니다.");
					break;

				}

			} else {
				wrongAnswer++;
				System.out.println("오답!");
				if (wrongAnswer >= 3) {
					System.out.println("3 문제 모두 틀리셨습니다. 다시 시작됩니다.");
					goodAnswer = 0;
					wrongAnswer = 0;
					repeat = 6;
					
				}
			}

			repeat--;
		}

	}

}
