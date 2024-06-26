package day8_Test;

public class ArrayUtil {
	
	static int[] concat(int[] x, int[] y) {
		int[] arr = new int[x.length + y.length];
		
		for(int i =0 ; i<arr.length ; i++) {
			if(i < x.length) {
				arr[i] = x[i];
			} else {
				arr[i] = y[i-x.length];
			}
		}
		
		return arr;
		
	}

}
