package javaTest0710;

import java.util.Arrays;

public class Test5 {

	public static void main(String[] args) {
		ArrayManager arrManager = new ArrayManager();
		int[] question = { 1, 2, 3, 4, 5 };
		int[] question2 = { 6, 4, 2, 1, 5 };
		
		System.out.println("Question1");
		
		System.out.println("maxInt : " + arrManager.maxInt(question));
		System.out.println("sumInt : " + ArrayManager.sumInt(question));
		System.out.println("makeIntArr : " + Arrays.toString(arrManager.makeIntArr()));

		System.out.println("Question2");

		System.out.println("maxInt : " + arrManager.maxInt(question2));
		System.out.println("sumInt : " + ArrayManager.sumInt(question2));
		
	}

}
