package dailyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DailyTest2 {
	public static void main(String[] args) {

//		System.out.println(Arrays.toString(firstQuestion()));
//		System.out.println(Arrays.toString(secondQuestion()));
//		System.out.println(Arrays.toString(thirdQuestion()));
//		System.out.println(Arrays.toString(addedTest1()));
//		checkArray(100 , addedTest1());
		addedTest2();
		
		

	}
	
	static void checkArray(int numb, int[] array) {
		for(int y = 1 ; y <=numb ; y++) {

			for(int i = 0 ; i < array.length; i++) {
				for(int j = 1 ; j< array.length; j++) {
					  
					
					if(array[i] == array[j] && i != j) {
						System.out.println("에러 발생 i: " + array[i] + " j: " + array[j]);
						System.out.println("i: " + i + " j: " + j);
					}
					
				}
			}	
		}
		System.out.println("Test 완료");
		
	}

//	1.
	// 배열에서 중복 제거
	static int[] firstQuestion() {

		int arr[] = { 10, 20, 5, 10, 30, 5, 10, 25 };
//		 결과 예시 : {10, 20, 5, 30, 25} (정렬은 상관x)
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (list.contains(arr[i])) {

			} else
				list.add(arr[i]);

		}

		int[] returnArr = new int[list.size()];
		System.out.println(returnArr.length);
		for (int j = 0; j < list.size(); j++) {
			returnArr[j] = list.get(j);

		}
		return returnArr;
	}

//		2.
//	해당 배열을 홀수, 짝수 따로 정렬하시오.
//	결과 예시 : {23, 25, 27, 61, 10, 16, 32, 54};
	
	// Arrays.sort() 함수 외 Arrays 함수 공부해보자!


	static int[] secondQuestion() {
		int arr[] = { 10, 25, 32, 54, 23, 16, 27, 61 };

		// 임시 리스트 형성 홀수, 짝수
		ArrayList<Integer> oddList = new ArrayList<Integer>();
		ArrayList<Integer> evenList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			// arr 홀수 구분
			if (arr[i] % 2 == 1) {

				// 리스트가 비었을 경우 값 입력
				if (oddList.size() == 0)
					oddList.add(arr[i]);
//				리스트의 각 숫자와 비교해서 더 작은 값을 앞에 입력, 값이 리스트 내 숫자보다 크다면 가장 후순위에 추가
				else {
					int limit = oddList.size();
					for (int y = 0; y <= limit; y++) {
						if (y == oddList.size()) {
							oddList.add(arr[i]);
							break;
						}
						if (arr[i] < oddList.get(y)) {
							oddList.add(y, arr[i]);
							break;

						}
					}

				}

				// arr 순서대로 읽고 짝수 구분
			} else {
				// 리스트가 비었을 경우 값 입력

				if (evenList.size() == 0)
					evenList.add(arr[i]);
//				리스트의 각 숫자와 비교해서 더 작은 값을 앞에 입력, 값이 리스트 내 숫자보다 크다면 가장 후순위에 추가
				else {
					int limit = evenList.size();
					for (int y = 0; y <= limit; y++) {
						if (y == evenList.size()) {
							evenList.add(arr[i]);
							break;
						}
						if (arr[i] < evenList.get(y)) {
							evenList.add(y, arr[i]);
							break;
						}
					}

				}

			}

		}

		// 리스트 통합 후 동일 사이즈의 Array 생성
		oddList.addAll(evenList);
		int[] returnArr = new int[oddList.size()];
		// 리스트 값 Array 대입
		for (int size = 0; size < oddList.size(); size++) {
			returnArr[size] = oddList.get(size);
		}

		return returnArr;
	}

//	3.
//	기본 -> 홀수는 오름차순, 짝수는 내림차순
//	결과 예시 : 홀,짝 순으로 출력 { 23, 54, 25, 32, 27, 16, 61, 10 }

	static int[] thirdQuestion() {
		int arr[] = { 10, 25, 32, 54, 23, 16, 27, 61 };
		ArrayList<Integer> oddList = new ArrayList<Integer>();
		ArrayList<Integer> evenList = new ArrayList<Integer>();
		ArrayList<Integer> returnList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {

				int limit = oddList.size();

				if (oddList.size() == 0)
					oddList.add(arr[i]);

				else {
					for (int oddNumb = 0; oddNumb <= limit; oddNumb++) {
						if (oddNumb == limit) {
							oddList.add(arr[i]);
							break;
						} else if (arr[i] < oddList.get(oddNumb)) {
							oddList.add(oddNumb, arr[i]);
							break;
						}
					}
				}

			} else {

				int limit = evenList.size();

				if (evenList.size() == 0)
					evenList.add(arr[i]);
				else {
					for (int evenNumb = 0; evenNumb <= limit; evenNumb++) {
						if (evenNumb == limit) {
							evenList.add(arr[i]);
							break;
						} else if (arr[i] > evenList.get(evenNumb)) {
							evenList.add(evenNumb, arr[i]);
							break;
						}
					}

				}

			}
		}

		int oddCount = 0;
		int evenCount = 0;

		int[] returnArr = new int[oddList.size() + evenList.size()];

		for (int i = 0; i < returnArr.length; i++) {

			if (i % 2 == 0 && oddCount != oddList.size()) {
				returnArr[i] = oddList.get(oddCount);
				oddCount++;
			} else if (i % 2 == 1 && evenCount != evenList.size()) {
				returnArr[i] = evenList.get(evenCount);
				evenCount++;
			} else if (oddCount != oddList.size()) {
				returnArr[i] = oddList.get(oddCount);
				oddCount++;
			} else if (evenCount != evenList.size()) {
				returnArr[i] = evenList.get(evenCount);
				evenCount++;
			}

		}

		return returnArr;
	}

//	1. 정수를 몇 개 저장할지 키보드로부터 개수를 입력받아(100보다 작은 개수) 
//	정수 배열을 생성하고, 이곳에 1에서 100까지 범위의 정수를 랜덤하게 삽입하라. 
//	배열에는 같은 수가 없도록 하고 배열을 출력하라

	static int[] addedTest1() {
		int[] returnArr;
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("생성할 배열의 크기를 적어주세요\n(1 - 100의 정수)");
			try {
				// testCord
				Random random = new Random();
				int numb = random.nextInt(0, 100)+1;
				
				// correctCord
//				int numb = scan.nextInt();
				
				if (numb <1 || numb > 100) throw new Exception();

				returnArr = new int[numb];
				Random randomNumb = new Random();

				for (int i = 0; i < returnArr.length; i++) {

					int insertNumb = randomNumb.nextInt(0, 100)+1;

					for (int j = 0; j <= i; j++) {
						if (returnArr[j] == insertNumb) {
							i -= 1;
							break;
						} else if (j == i) {
							returnArr[j] = insertNumb;

						}

					}

				}

				break;
			} catch (Exception e) {
				System.out.println("정수를 입력해주세요");
				scan.nextLine();
			}

		}

		return returnArr;
	}
	
	static void addedTest2() {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		boolean finish = true;
		while(finish) {
			int answerCount = 0;
			
			System.out.print("문제수를 입력해주세요: ");
			int questionNumb = scan.nextInt();
			
			for(int i = 0 ; i < questionNumb ; i++) {
				int numb1 = random.nextInt(1,10);
				int numb2 = random.nextInt(1,10);
				
				System.out.println(numb1 +" * " + numb2 + " = ");
				int answer = scan.nextInt();
				if(answer == numb1*numb2) {
					System.out.println("정답.");
					answerCount +=1;
				}
					
				 else
					 System.out.println("오답. 정답은 "+ numb1*numb2 + " 입니다.");
			}
			System.out.println("총 " + questionNumb + "문제 중 " + answerCount +"개 정답!\n계속 하시려면 아무키를 입력해주세요. 종료는 0을 입력해주세요." );
			scan.nextLine();

			try {

				int roofWord = scan.nextInt();

				if(roofWord == 0) {
					finish = false;
					System.out.println("종료되었습니다.");
				}
			}catch(Exception e){

				scan.nextLine();
				
			}
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
