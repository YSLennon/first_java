package day11;

import java.util.ArrayList;
import java.util.HashMap;

public class Map_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		
		HashMap<String, Object> hong = new HashMap<>();

		hong.put("name", "홍길동");
		hong.put("age", 30);
		hong.put("addr", "인천");
		hong.put("phone", "010-1234-5678");
		
		HashMap<String, Object> kim = new HashMap<>();

		kim.put("name", "김철수");
		kim.put("age", 25);
		kim.put("addr", "강원도");
		kim.put("phone", "010-1224-5678");
		HashMap<String, Object> yu = new HashMap<>();

		yu.put("name", "유재석");
		yu.put("age", 45);
		yu.put("addr", "서울");
		yu.put("phone", "010-1234-1678");
		
		list.add(hong);
		list.add(kim);
		list.add(yu);
		
		
		
		System.out.println(list);
	}

}
