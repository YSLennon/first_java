package day10;

import java.util.Scanner;
import java.util.StringTokenizer;

public class FourthQuestionProgram{
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("문장을 입력해주세요");
		String sentence = scan.nextLine();
	
		StringBuffer senBuf = new StringBuffer(sentence);

		char[] arr = sentence.toCharArray();
		System.out.println(sentence);
		for(int i=0; i<arr.length; i++) {
			
			senBuf.insert(senBuf.length(),arr[i]);
			senBuf.delete(0, 1);
			System.out.println(senBuf);
			
		}
		
		
	}
	
}