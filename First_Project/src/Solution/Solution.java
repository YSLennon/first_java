package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public Solution() {

		a();
	}
	public void a() {
		System.out.println("super");
	}

	public static void main(String[] args) {

//		Solution a = new Solution();
//		SubSolution b = new SubSolution();
//		Solution c = new SubSolution();
//		String str = "select stu_name, stu_grade from student where stu_name = ' ' ";
//		int a;
//		a = 10;
//		a = sumA(1,2);
		
		
		
		System.out.println(sumA(1,2));

	}
	
	static int sumA (int x, int y) {
	
		if(x ==1) {
			x= 2;
		} 
			x= 10;	
		
		
//		y = 10;
		
		
		return x+y;
		
	}

	
}

class SubSolution extends Solution {
	@Override
	public void a(){
		System.out.println("sub");
	}
	public SubSolution() {
		super.a();
		
	}
}