package javaTest0710;

import java.util.Scanner;

public class ArrayManager {

	public int maxInt(int[] arr) {

		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
//		for (int i = 1; i< arr.length ; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int sumInt(int[] arr) {
		int sum = 0;
//	    int sum = arr[0];

		for (int i = 0; i < arr.length; i++) {
//		for (int i = 1; i< arr.length ; i++) {
			sum += arr[i];
		}

		return sum;
	}

	public int[] makeIntArr() {
		int[] answer = new int[5];
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.print("숫자를 입력하세요 : ");
			answer[i] = scan.nextInt();
		}

		return answer;

	}

}
