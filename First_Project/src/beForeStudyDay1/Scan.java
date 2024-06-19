package beForeStudyDay1;

import java.util.Scanner;

public class Scan {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요: ");
		String name = scan.nextLine(); // 문자를 입력받는 메서드
		// next를 사용해도 된다고함. -> Buffer 배우고 설명해주신다네? 찾아보기
		System.out.print("나이를 입력해주세요: ");
		int age = scan.nextInt(); // 숫자는 nextInt();를 사용한다.
		
		System.out.println("제 이름은 " + name + "이고, 나이는 "+ age+ "살 입니다.");
		
		
		
	}

}
