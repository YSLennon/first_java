package javaTest0710;

import java.util.Scanner;

public class StringInputClass {

	
	InputWrapperClass makeWrapper() {
		return new InputWrapperClass();
	}

	CheckInputFlg defaultFlag = str -> {
		return true;
	};

	// 문자 입력, 조건 체크 후 재입력받는 함수
	 void inputStr(InputWrapperClass strClass, String inputStr, CheckInputFlg flg) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print(inputStr + " 입력하세요 : ");
			strClass.str = scan.next();
			if (flg.isTrue(strClass.str))
				return;
		}
	}
	// 조건없이 입력만 받는 함수
	 void inputStr(InputWrapperClass strClass, String inputStr) {
		Scanner scan = new Scanner(System.in);
		System.out.print(inputStr + " 입력하세요 : ");
		strClass.str = scan.next();
	}
	
}

// 입력받는 문자를 객체에 담아주는 Wrapper 클래스
class InputWrapperClass {
	String str;
}

// 문자 입력 시 조건을 체크하기 위한 인터페이스
interface CheckInputFlg {

	// isTrue 구현 시 틀린 값을 입력하면 안내 메세지 출력
	boolean isTrue(String str);
}
