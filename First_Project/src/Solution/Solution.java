package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int arr[] = { 1, 23, 4, 10, 0 };
		while (true) {
			System.out.print("숫자를 입력하세요 >>");
			int input = scan.nextInt();
			int temp = 0;
			arr[4] = input;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[4] == arr[i]) {
					break;
				}
				temp++;
			}
			if (temp == arr.length - 1)
				break;

		}
		
		System.out.println(Arrays.toString(arr));

	}
}
