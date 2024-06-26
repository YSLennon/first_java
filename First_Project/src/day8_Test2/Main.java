package day8_Test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Concert concert = new Concert();
		System.out.println("예약 시스템 심화문제 예약 시스템입니다.");

		int choice = 1;
		while (choice != 4) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			choice = scan.nextInt();
			switch (choice) {
			case 1: // 예약
			{

				concert.reserve();
				break;
			}
			case 2: // 조회
				concert.check();
				break;

			case 3: // 예약 취소
				concert.cancel();
				break;

			case 4: // 종료
				System.out.println("종료되었습니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}

		}

	}

}

class Concert {

	Scanner scan;
	String[] arrS;
	String[] arrA;
	String[] arrB;

	Concert() {
		scan = new Scanner(System.in);
		arrS = new String[10];

		for (int i = 0; i < arrS.length; i++) {
			arrS[i] = "---";
		}
		arrA = arrS.clone();
		arrB = arrS.clone();

	}

	String checkNameAndPlace() {
		System.out.print("좌석 구분 S(1), A(2), B(3)>>");
		int grade = scan.nextInt();
		scan.nextLine();
		String position = "roof";
		while (position == "roof") {
			switch (grade) {
			case 1:
				System.out.print("S>>");
				System.out.println(Arrays.toString(arrS));
				position = "arrS";
				break;
			case 2:
				System.out.print("A>>");
				System.out.println(Arrays.toString(arrA));
				position = "arrA";
				break;
			case 3:
				System.out.print(">>");
				System.out.println(Arrays.toString(arrB));
				position = "arrB";
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}

		}
		System.out.print("이름>>");
		String name = scan.nextLine();

		return name + " " + position;
	}

	void reserve() {

		String[] numberAndPlace = checkNameAndPlace().split(" ");

		System.out.print("번호>>");
		int numb = scan.nextInt();
		switch (numberAndPlace[1]) {
		case "arrS":
			arrS[numb - 1] = numberAndPlace[0];
			break;
		case "arrA":
			arrA[numb - 1] = numberAndPlace[0];
			break;
		case "arrB":
			arrB[numb - 1] = numberAndPlace[0];
			break;
		default:
		}

	}

	void check() {

		System.out.print("S>>");
		System.out.println(Arrays.toString(arrS));
		System.out.print("A>>");
		System.out.println(Arrays.toString(arrA));
		System.out.print(">>");
		System.out.println(Arrays.toString(arrB));
		System.out.println("<<<조회를 완료하였습니다.>>>");

	}

	void cancel() {
		String[] numberAndPlace = checkNameAndPlace().split(" ");

		end: switch (numberAndPlace[1]) {
		case "arrS":
			for (int i =0 ; i< arrS.length ; i++) {
				if (arrS[i].equals(numberAndPlace[0])) {
					arrS[i] = "---";
					break end;
				}
			}
			break;
		case "arrA":
			for (int i =0 ; i< arrA.length ; i++) {
				if (arrA[i].equals(numberAndPlace[0])) {
					arrA[i] = "---";
					break end;
				}
			}
		case "arrB":
			for (int i =0 ; i< arrB.length ; i++) {
				if (arrB[i].equals(numberAndPlace[0])) {
					arrB[i] = "---";
					break end;
				}
			}
		default:

		}

	}
}
