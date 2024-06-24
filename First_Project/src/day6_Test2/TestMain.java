package day6_Test2;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,5,3,1,4};
		TestArray.changeArray(arr);
		
		System.out.println(Arrays.toString(arr));
		// 메서드가 리턴이 필요없는 이유
		
//		changeArray 메서드는 배열을 매개변수로 받아서 해당 객체의 위치 변경을 하는 메서드이다.
//		배열은 레퍼런스 타입으로 실제 arr에는 해당 배열의 주소값이 들어있고,
//		changeArray 메서드에 매개변수로 해당 배열의 주소값이 들어가고 해당 배열의 정렬 작업이 진행된다.
//		해당 주소값은 main에 있는 arr에 있는 주소값과 동일하므로 changeArray 메서드는 return type이 따로 필요하지 않다.

	}

}
