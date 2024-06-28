package day10;

import java.util.Scanner;

public class ThirdQuestionProgram {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean flg = true;

		System.out.println("문장을 입력해주세요.\n종료를 원하시면 그만을 입력해주세요");

		while (flg) {

			System.out.print(">>");
			String sentence = scan.nextLine();
			
			if (sentence.equals("그만")) {
				flg = false;
				System.out.println("종료합니다...");
			}
				
			else {
				String[] returnArr = sentence.split(" ");
				System.out.println("어절 개수는 " + (returnArr.length));

			}
		}

	}

}
