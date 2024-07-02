package day12;

import java.util.Scanner;

public class Ex_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("나눌 수 : ");
		int numb1 = scan.nextInt();
		System.out.print("나누는 수 : ");
		int numb2 = scan.nextInt();
		int arr[] = { 1, 2, 3 };

		try {
			System.out.println(numb1 / numb2);
			arr[3] = 10;
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음");
			System.out.println(e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} finally {
			System.out.println("finally : 무조건 실행");
		}

	}

}
