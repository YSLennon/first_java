package beForeStudyDay1;

import java.util.Scanner;

public class Day1_Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.print("성별을 입력하세요 : ");
		String gender = scan.nextLine();
		System.out.print("나이를 입력하세요 : ");
		int yourAge = scan.nextInt();

		System.out.println("당신의 나이는 " + yourAge + ", 성별은 " + gender + "입니다.");
		scan.close(); // 오브젝트 닫아주기
	}

}
