package day16;

import java.util.ArrayList;
import java.util.Random;

public class ArrayTest {

	public static void main(String[] args) {
		Random ran = new Random();

		int[][] arr = new int[4][4];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = ran.nextInt(10) + 1;

				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

		
		
		
		// 배열은 0이 들어갈 수 있다는걸 생각해두자. 자꾸 까먹으면 안돼...
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			list.add(i);

		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (list.size() == 0) {
					arr[i][j] = 0;
					cnt++;
				}
				if (ran.nextInt(10) % 2 == 1) {
					int listIndex = ran.nextInt(list.size());
					arr[i][j] = list.get(listIndex);
					list.remove(listIndex);
				} else if (cnt < 6) {
					arr[i][j] = 0;
					cnt++;
				} else {
					int listIndex = ran.nextInt(list.size());
					arr[i][j] = list.get(listIndex);
					list.remove(listIndex);
				}

				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

		
		int row =(int) Math.random()*4;
		int col =(int) Math.random()*4;
		
		int[][] arr3 = new int[row][col]; // 이런식으로 짜는 방법도 있고 이게 더 효율적인 것 같다. 비어있는 배열은 0이라는걸 기억하자..
	}

}
