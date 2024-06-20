package forMyTest;

import java.util.Random;

public class RecursiveFunction {


	public static void main(String[] args) {
		Random ran = new Random();
		int numb = ran.nextInt(100) + 1;
		System.out.println(numb);

		solution(0, 100, numb, 0);

	}

	static void solution(int min, int max, int target, int count) {
		
		int mid = (max + min) / 2;
		count++;
		if (mid > target)
			solution(min, mid, target, count);
		else if (mid < target)
			solution(mid, max, target, count);
		else {
			System.out.println("정답은 " + mid + " 입니다.");
			System.out.println(count + "번 만에 찾았네요");
		}
	}

}
