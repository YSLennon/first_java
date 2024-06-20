package Solution;

import java.util.Arrays;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Arrays.toString(solution(1,2,3,4)));

	}

	static int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int divisors = divideNumbers(denom1,denom2);
		
		int newNumer = numer1*denom2/divisors + numer2*denom1/divisors;
		int newDenom = denom1*denom2/divisors;
		
		int newDivisors = divideNumbers(newNumer, newDenom);
		
		int[] answer = new int[2];
		answer[0] = newNumer/newDivisors;
		answer[1] = newDenom/newDivisors;
		
		
		return answer;
	}

	static int divideNumbers(int x, int y) {

		int big = x > y ? x : y;
		int small = x > y ? y : x;

		int divisors = 1;

		if (big % small == 0) {
			divisors *= small;
			x = (x > y) ? x / y : 1;
			y = (y > x) ? y / x : 1;
		} else {
			for (int i = 2; i <= small / 2; i++) {
				if (x % i == 0 && y % i == 0) {
					divisors *= i;
					x /= i;
					y /= i;
					i--;
				}

			}
		}
		return divisors;

	}

}
