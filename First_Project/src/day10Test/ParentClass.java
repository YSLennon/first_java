package day10Test;

public class ParentClass {
	 String name;

	 ParentClass(){
		 name = "이름없음";
	 }
	ParentClass(String name) {
		this.name = name;
		System.out.println(name+"님 자바 클래스 테스트를 시작합니다!");

	}
	
	 void gugudan(int numb) {
		for(int i = 1; i<10 ;i++) {
			System.out.println(numb + " * " + i + " = " + numb*i);
		}
	}
	
	int arrBigNum(int[] arr) {
		int max = arr[0];
		
		for(int i =1 ; i<arr.length ; i++) {
			if(arr[i] > max) max = arr[i];
		}
		
		return max;
	}
	
	
	
	
}
