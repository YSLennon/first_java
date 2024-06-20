package daily;

import java.util.Arrays;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(array_8()));

	}

	static void array_1() {

		int[] arr = { 3, 2, 1 };

		System.out.println(Arrays.toString(arr));

	}

	static void array_2() {
		// 크기가 100인 배열에 1부터 100까지 순서대로 담기
		int arr[] = new int[100];

		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		System.out.println(Arrays.toString(arr));
	}

	static int array_3() {
		int arr[] = { 1, 3, 7, 6, 2 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			sum += arr[i];
		}
		return sum;
	}

	static void array_4() {
		Scanner scan = new Scanner(System.in);

		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {

			System.out.print("숫자를 입력해주세요 : ");
			arr[i] = scan.nextInt();

			if (arr[i] < 0) {
				System.out.println("0이상의 숫자를 입력하세요");
				i--;
			}

		}
		System.out.println("당신이 입력한 숫자는 " + Arrays.toString(arr) + " 입니다.");

	}

	static int array_5() {
		int[] arr = { 1, 4, 5, 3, 1231234, 12412513, 1241253, 12412412, 2 };
		// 가장 큰 수 찾기
		int tmp = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > tmp)
				tmp = arr[i];

		}

		return tmp;
	}

	static int array_6() {
		int[] arr = { 3, 4, 5, 1, -2 };
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;

	}

	static void array_7() {

		int[] arr = { 3, 4, 5, 1, 2 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static int[] array_8() {
		int[] arr = { 3, 4, 5, 2, 1 };

		int max = 0;
		int min = 0;
		int tmp;
		for (int i = 1; i < arr.length; i++) {
			if (arr[max] < arr[i]) {
				max = i;
			}
			if (arr[min] > arr[i]) {
				min = i;
			}

		}
		tmp = arr[max];
		arr[max] = arr[min];
		arr[min] = tmp;

		return arr;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
