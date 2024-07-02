package day12;

import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WordQuiz wordQuiz = new WordQuiz("\"영어테스트\"");
		

		System.out.println(wordQuiz.getName() + "의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.\n현재 " + wordQuiz.getVSize()+"개의 단어가 들어 있습니다. ");
		
		
		
		while(true) {
			int answer = wordQuiz.returnQuiz();
			int userAnswer = scan.nextInt();
			if(userAnswer == -1) {
				System.out.println(wordQuiz.getName() + "를 종료합니다...");
				break;
			}else if(userAnswer == answer) {
				System.out.println("정답 !!");
			}else {
				System.out.println("틀렸음 !!");
			}
	
		}		

	}

}
