package day16;

public class Array_1 {

	public static void main(String[] args) {

//		int[][] arr = new int [2][5];
		int[][] arr1 = { { 1, 2, 3, 4, 5 }, { 3, 2, 5, 4, 1 } };
		for (int[] arrI : arr1) {
			
			for (int i : arrI) {
				
				System.out.println(i);
				
			}
			
		}
	}

}
