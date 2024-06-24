package day6_Test;

public class Calc {

	static int sum(int x, int y) {

		return x + y;

	}

	static int multiple(int x, int y) {
		return x * y;
	}

	// 3-2
	static double multiple(int x, double y) {
		return x * y;
	}

	static int multiple(int x, int y, int z) {
		return x * y * z;
	}

	static String multiple(String x, int y) {
		String str = "";
		if(y <= 0) {
			str = "1 이상의 숫자를 입력해주세요";
		
		}else {
			for (int i = 0; i < y; i++) {
				str += x;
			}
		}
		
		return str;
	}

}
