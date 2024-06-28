package daily01_5Test;

import java.util.Arrays;
import java.util.Random;

// 코어과목 자료구조, 소프트웨어 공학

public class DailyTest1 {

	public static void main(String[] args) {

		int[] arr = { 3, 5, 2, 4, 1 };
		int min = 0;
		int max = 0;
		int tmp = arr[0];

		int check = 0;
		System.out.println(Arrays.toString(arr));

		
		
		
		
		
//		1. 가장 큰 수와 가장 작은 수의 위치 변경

		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[min] > arr[i])
				min = i;
			else if (arr[max] < arr[i])
				max = i;
		}

		tmp = arr[min];
		arr[min] = arr[max];
		arr[max] = tmp;

		System.out.println(Arrays.toString(arr));
//		(결과 : {3, 1, 2, 4, 5})

		
		
		
		
		
		
		
		
//		2. 버블 정렬을 이용하여 위 배열을 작은 수에서 큰 수 순으로 정렬
		// 버블 정렬: 인접한 두 항목의 값을 비교하여 조건을 만족하면 서로의 값을 교환하는 식으로 정렬하는 방식

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = tmp;
				}

			}
		}

		System.out.println(Arrays.toString(arr));

//		(결과 : {1, 2, 3, 4, 5})

		
		
		
		
		
		
//		3. 선택 정렬을 이용하여 마찬가지로 작은수 -> 큰 수 순으로 정렬
		// 해당 순서에 넣을 원소를 넣을 위치는 이미 정해져있고, 어떤 원소를 넣을지 선택하는 알고리즘

		int[] arr2 = new int[5];

		for (int i = 0; i <= 4; i++) {
			int tmp2 = arr[i];
			int minNumb = i;

			for (int j = i + 1; j < 5; j++) {
				if (arr[j] < arr[i])
					minNumb = j;
			}
			arr[i] = arr[minNumb];
		}

		System.out.println(Arrays.toString(arr));

//		(결과 : {1, 2, 3, 4, 5})

//
//		- 버블 정렬과 선택 정렬은 자료구조에서 가장 간단한 정렬의 방법론이며,
//		해당 개념은 구글리을 통해서 직접 파악해보시기 바랍니다.
//
//		---
		
		
		
		
		
		
//
//		4. 6개의 공간을 가지는 배열을 생성하고, 랜덤하게 생성된 1부터 45사이의 값을 배열에 
//		넣으시오. 단, 중복 숫자는 허용하지 않음.
		for (int i = 0; i < 1000; i++) {
			int[] testArray = makeRandomArray();

			for (int j = 0; j < 6; j++) {
				for (int y = j + 1; y < 6; y++) {
					if (testArray[y] == testArray[j])
						System.out.println("에러코드 발생 Test Y: " + testArray[y] + "Test J: " + testArray[j]);
				}
			}

		}
		System.out.println("random 테스트 완료");

	}
	
	
	static int[] makeRandomArray() {
		int[] randomArray = new int[6];

		Random random = new Random();

		int randomInt;

		randomArray[0] = random.nextInt(46);

		for (int i = 1; i < randomArray.length; i++) {

			randomInt = random.nextInt(46);

			for (int j = i - 1; j >= 0; j--) {
				if (randomArray[j] == randomInt) {
					i--;
					break;
				} else if (j == 0) {
					randomArray[i] = randomInt;
				}
			}

		}
//	System.out.println(Arrays.toString(randomArray));

		return randomArray;

	}

}
