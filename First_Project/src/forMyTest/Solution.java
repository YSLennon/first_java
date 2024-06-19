package forMyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution(1, 2, 3, 4)));


	}

	static int[] solution(int numer1, int denom1, int numer2, int denom2) {

		Solution sol = new Solution(); 
		// 공약수
		int smallCommonMultiple = sol.makeSmallCommonMultiple(denom1, denom2);
		// 공약수 곱하기
		int changeNumer1 = sol.changeNumber(numer1, denom1, smallCommonMultiple);
		int changeNumer2 = sol.changeNumber(numer2, denom2, smallCommonMultiple);

		int newNumer = changeNumer1 + changeNumer2;

		int[] returnArr = sol.divideNumber(newNumer, smallCommonMultiple);

		return returnArr;

	}

	// 1. 약분하기
	 List<Integer> cutTheNumber(int root) {
		

		List<Integer> list = new ArrayList<Integer>();
		int calc = root;

		// 좀 큰 수의 경우는 소수를 먼저 판별하는게 좋을 수도 있지만 숫자의 범위가 작다면(일반적인 경우) 그냥 약분만 진행해도 괜찮을 것 같다.
		// 소수일 경우만 따로 구분
		for (int i = 2; i <= root / 2; i++) {

			if (calc % i == 0) {
				list.add(i);
				calc = calc / i;
				i--;

			}
		}
		// 소수인 경우
		if (list.size() == 0)
			list.add(root);
		return list;

	}

	// 2. 비교 후 최소공배수 구하기
	 int makeSmallCommonMultiple(int d1, int d2) {

		List<Integer> x = cutTheNumber(d1);
		List<Integer> y = cutTheNumber(d2);
		List<Integer> list = new ArrayList<Integer>();

		int returnInt = 1;
		for (int i = 0; i < x.size(); i++) {
			for (int j = 0; j < y.size(); j++) {
				if (x.get(i) == y.get(j)) {

					returnInt *= x.get(i);
					x.remove(i);
					y.remove(j);

					break;
				}
			}
		}

		if (y.size() != 0)
			for (int i = 0; i < y.size(); i++)
				returnInt *= y.get(i);

		if (x.size() != 0)
			for (int i = 0; i < x.size(); i++)
				returnInt *= x.get(i);
//		System.out.println(returnInt);

		return returnInt;

	}

	// 2. 최소공배수 /d 의 숫자를 n에 곱하기
	 int changeNumber(int n, int d, int c) {
		return c / d * n;
	}

	// 3. 2번 숫자 더하기 -> 하드코딩으로 진행

	// 4. 3번/최소공배수 기약분수로 표현하기

	 int[] divideNumber(int n, int d) {

		List<Integer> cuttedNumer = cutTheNumber(n);
		List<Integer> cuttedDenom = cutTheNumber(d);

		for (int i = 0; i < cuttedNumer.size(); i++) {
			for (int j = 0; j < cuttedDenom.size(); j++) {
				if (cuttedNumer.get(i) == cuttedDenom.get(j)) {
					cuttedNumer.remove(i);
					cuttedDenom.remove(j);
					i--;
				}
			}
		}
		int[] returnArr = new int[]{1, 1};
		
		for (int i = 0; i < cuttedNumer.size(); i++) {
			returnArr[0] *= cuttedNumer.get(i);

		}
		for (int i = 0; i < cuttedDenom.size(); i++) {
			returnArr[1] *= cuttedDenom.get(i);

		}

		return returnArr;
	}

}