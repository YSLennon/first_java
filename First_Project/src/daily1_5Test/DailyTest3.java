package daily1_5Test;

import java.util.Random;
import java.util.Scanner;

public class DailyTest3 {

	public static void main(String[] args) {

		test1();
	}

	static void test1() {
		for (int i = 10; i <= 50; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	static void test2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 두번 입력해주세요.");
		int x = scan.nextInt();
		int y = scan.nextInt();

//		문제가 진짜로 큰 수 작은 수를 입력하라는거였네;
//		String txt = x + y >= 10 ? "큰 수" : "작은 수";
		if (x + y > 10)
			if (x > y) {
				System.out.println(x);
			} else {
				System.out.println(y);
			}
		else if (x > y) {
			System.out.println(y);
		} else {
			System.out.println(x);
		}
	}

	static void test3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요.");
		int x = scan.nextInt();

		for (int i = 1; i <= 9; i++) {
			System.out.println(x + " * " + i + " = " + x * i);
		}

	}

	static void test4() {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		int randomNumb = ran.nextInt(100) + 1;
		System.out.println("숫자를 입력해주세요");
		int userNumb = scan.nextInt();
		if (randomNumb > userNumb) {
			System.out.println("입력한 수가 더 작습니다.");
		} else if (randomNumb < userNumb) {
			System.out.println("입력한 수가 더 큽니다.");
		} else {
			System.out.println("입력한 수와 동일합니다.");
		}

	}

	static void test5() {

		for (int i = 1; i < +30; i++) {
			if (10 <= i && i < 20)
				continue;

			System.out.println(i);

		}

	}

	static void test6() {

		int i = 2;
		while (i <= 9) {
			int j = 1;
			if (i == 4 || i == 8) {

			} else {

				while (j <= 9) {
					System.out.println(i + " * " + j + " = " + i * j);
					j++;
				}

			}
			i++;

		}
	}

}
