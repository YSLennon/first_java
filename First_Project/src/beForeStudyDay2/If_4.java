package beForeStudyDay2;

public class If_4 {
	public static void main(String[] args) {
		
		
		int age = 131;
		
		if(age >= 20) {
			if(age %2 == 1) System.out.println("나이가 홀수이며 20살 이상입니다.");
			else System.out.println("나이가 20살 이상이며 짝수입니다.");
		}else {
			if (age%2 == 1) System.out.println("나이가 홀수이며 20살 이하입니다.");
			else System.out.println("나이가 짝수이며 20살 이하입니다.");
		}
		
		if(age >= 20 && age%2 == 1) System.out.println("안녕하세요");

	}
}
