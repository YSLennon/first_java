package firstDay;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		// 사용자로부터 id, 이름을 입력받아서 
		// "ooo (이름) 님이 로그인하셨습니다." 출력
		// "ooo 님의 아이디는 xxx(ID) 입니다." 출력
		
		System.out.print("ID를 입력해주세요: ");
		String id = scan.nextLine();
		
		System.out.print("이름을 입력해주세요: ");
		String name = scan.nextLine();
		
		System.out.println();
		System.out.println(name + " 님이 로그인하셨습니다.");
		System.out.println(name + "님의 아이디는 "+ id + " 입니다.");
		
	}

}
