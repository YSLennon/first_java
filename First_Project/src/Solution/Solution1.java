package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 분수의 덧셈 - 개정안

public class Solution1 {

	// 공약수 값
	// 분모 = d1 * d2 / divisors
//	분자 = n1 * d2/divisors, n2 * d1/divisors

	// 분자와 분모의 divisors 만들기
	// 해당 숫자를 나눈
	// 공약수를뺀 수를 곱한 n1+ n2

	// n1+n2와 divisors의 공약수

	// 공약수를 나눈 분자와
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
//		int a = sol.makeCommonMultiple(3, 6);
//		List<Integer> b = sol.makeDivisors(17);
//		System.out.println(a);
//		System.out.println(b);

System.out.println(Arrays.toString(solution(1,2,3,4)));

	}

	static int[] solution(int numer1, int denom1, int numer2, int denom2) {
		// TODO Auto-generated method stub

		Solution1 sol = new Solution1();
		int newNumer1 = sol.makeNewNumer(numer1, denom1, denom2);
		int newNumer2 = sol.makeNewNumer(numer2, denom2, denom1);

		int calcNumer = newNumer1 + newNumer2;
		int commonMultiple = sol.makeCommonMultiple(denom1, denom2);

		int commonDivisors = sol.makeCommonDivisors(calcNumer, commonMultiple);

		int[] answer = { calcNumer / commonDivisors, commonMultiple / commonDivisors };

		return answer;

	}

	List<Integer> makeDivisors(int x) {

		List<Integer> list = new ArrayList<Integer>();
		int maxI = x / 2;
		for (int i = 2; i <= maxI; i++) {
			if (x % i == 0) {
				list.add(i);
				x /= i;
				i--;
			}
		}
		if (list.size() == 0)
			list.add(x);

		return list;
	}

	int makeCommonDivisors(int x, int y) {
		List<Integer> xList = makeDivisors(x);
		List<Integer> yList = makeDivisors(y);
		int commonDivisors = 1;
		if (xList.size() < yList.size()) {
			for (int i = 0; i < xList.size(); i++) {
				for (int j = 0; j < yList.size(); j++) {
					if (xList.get(i) == yList.get(j)) {
						commonDivisors *= xList.get(i);
						xList.remove(i);
						yList.remove(j);
						i--;
						break;
					}
				}
			}
		} else {
			for (int i = 0; i < yList.size(); i++) {
				for (int j = 0; j < xList.size(); j++) {
					if (yList.get(i) == xList.get(j)) {
						commonDivisors *= yList.get(i);
						yList.remove(i);
						xList.remove(j);
						i--;
						break;
					}
				}
			}

		}

		return commonDivisors;
	}

	int makeCommonMultiple(int x, int y) {

		int commonDivisors = makeCommonDivisors(x, y);
		return x * y / commonDivisors;

	}

	int makeNewNumer(int n1, int d1, int d2) {

		int commonDivisors = makeCommonDivisors(d1, d2);

		return n1 * d2 / commonDivisors;
	}

}
