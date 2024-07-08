package day16;

import java.util.Arrays;

// 2차원 배열 추가 문제


public class ArrayTest_2 {

    public static void main(String[] args) {
        makeArray(4);

    }

    private static void makeArray(int arrayLength) {
        int[][] arr = new int[arrayLength][arrayLength];
//		1번 보기
//		for(int row = 0 ; row < arrayLength ; row++){
//			for(int column =0 ; column < arrayLength -1 ; column++){
//				if(row == arrayLength-1 ) continue;
//				arr[row][column] = (int) (Math.random()*9+1);
//				arr[row][arrayLength-1] += arr[row][column];
//				arr[arrayLength-1][column] += arr[row][column];
//				arr[arrayLength-1][arrayLength-1] += arr[row][column];
//			}
//			System.out.println(Arrays.toString(arr[row]));
//		}

//		2번 보기
        for (int row = 0; row < arrayLength - 1; row++) {
            for (int column = 0; column < arrayLength - 1; column++) {
                arr[row][column] = (int) (Math.random() * 9 + 1);
            }
        }
        int[] columnSumArray = new int[arrayLength];

        for (int row = 0; row < arrayLength - 1; row++) {
            int rowSum = 0;
            for (int column = 0; column < arrayLength - 1; column++) {
                rowSum += arr[row][column];
                columnSumArray[column] += arr[row][column];
            }
            arr[row][arrayLength - 1] = rowSum;
            columnSumArray[arrayLength - 1] += rowSum;
            System.out.println(Arrays.toString(arr[row]));
        }
        arr[arrayLength - 1] = columnSumArray;
        System.out.println(Arrays.toString(arr[arrayLength - 1]));


    }

}
