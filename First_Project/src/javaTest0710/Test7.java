package javaTest0710;

import java.util.Arrays;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] arr = new int[6];
		int checkSameNumb = 0;
		int arrIndex = 0;

		while (true) {
			boolean skip = false;
			System.out.print("숫자를 입력해주세요 : ");
			int numb = scan.nextInt();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == numb)
					checkSameNumb++;
				if (arr[i] == numb && checkSameNumb > 1) {
					System.out.println("동일한 숫자 2개가 이미 존재합니다.");
					skip = true;
					break;
				}

			}

			if (!skip) {
				arr[arrIndex] = numb;
				arrIndex++;

				if (arrIndex == arr.length)
					break;

			}

		}

		System.out.println(Arrays.toString(arr));

	}

}
