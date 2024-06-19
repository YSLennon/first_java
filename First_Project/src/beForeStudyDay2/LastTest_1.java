package beForeStudyDay2;

import java.util.Scanner;

public class LastTest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요 1: ");
		int numb1 = scan.nextInt();
		System.out.println("숫자를 입력해주세요 2: ");
		int numb2 = scan.nextInt();
		
		if ((numb1 + numb2) % 2 == 1) System.out.println("홀수"); 
		else System.out.println("짝수");
		
	}

}
