package day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Map_1 {

	public static void main(String[] args) {

		HashMap<String, Object> hong = new HashMap<>();

		hong.put("name", "홍길동");
		hong.put("age", 30);
		hong.put("addr", "인천");
		hong.put("phone", "010-1234-5678");

		System.out.println(hong);
		
		Set<String> hongKey = hong.keySet();
		System.out.println(hongKey);

	}

}
