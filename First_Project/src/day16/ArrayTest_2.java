package day16;

import java.util.ArrayList;
import java.util.Arrays;

// 실수한 부분 확인해보기 -> 두가지 방법으로 다 짜보자 
// 2차원 배열 추가 문제


public class ArrayTest_2 {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];

		int rowLength = arr.length - 1;

		for (int row = 0; row < rowLength - 1; row++) {
			int colLength = arr[row].length - 1;

			for (int col = 0; col < colLength - 1; col++) {
				int number = (int) Math.random() * 10 + 1;

				arr[row][col] = number;
				arr[row][colLength] += number;
				arr[rowLength][col] += number;
				arr[rowLength][colLength] += number;

			}
			System.out.println(Arrays.toString(arr[row]));
		}

	}

}
