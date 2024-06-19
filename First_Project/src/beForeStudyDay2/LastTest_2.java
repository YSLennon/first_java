package beForeStudyDay2;

import java.util.Scanner;

public class LastTest_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요: ");
		int numb = scan.nextInt();
		if (numb >100 || numb < 0) System.out.println("잘못된 숫자 범위 입니다.");
		else {
			if (numb >= 80)System.out.println("A");
			else if (numb >= 60)System.out.println("B");
			else System.out.println("C");			
		}		

	}
}
