package day06_Test2;

public class TestArray {

	static void changeArray(int[] arr) {
		int max = 0;
		int min = 0;
		int tmp;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[max])
				max = i;
			if (arr[i] < arr[min])
				min = i;
		}
		tmp = arr[max];
		arr[max] = arr[min];
		arr[min] = tmp;
	}
}
