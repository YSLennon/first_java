package day11;

import java.util.Vector;

public class Vector_1 {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		
		vector.add("자바");
		vector.add("오라클");
		vector.add("html/css");
		vector.add(2, "자바스크립트");
//		vector.set(1, "10");
		
		System.out.println(vector);
		System.out.println(vector.get(1));
//		var vector1 = new Vector<String>(); -> 자바에서도 가능하다.
		for(int i=0 ; i<vector.size(); i++) {
			System.out.println(vector.get(i));
		}
		
		
	}
}
