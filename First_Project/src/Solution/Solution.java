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
		Solution c = new SubSolution();
//		String str = "select stu_name, stu_grade from student where stu_name = ' ' ";

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