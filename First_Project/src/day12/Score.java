package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Score {

	private Scanner scan = new Scanner(System.in);

	HashMap<String, Object> saveScore() {
		HashMap<String, Object> map = new HashMap<>();
		
		System.out.print("이름 >> ");
		map.put("name", scan.nextLine());
		map.put("java", checkNumb("Java", 35));
		map.put("oracle", checkNumb("Oracle", 40));
		map.put("html", checkNumb("HTML", 25));
		
		
		return map;
		
	}

	void printScore(ArrayList<HashMap<String, Object>> list) {

		for (int i = 0; i < list.size(); i++) {
			int java = (int) list.get(i).get("java");
			int oracle = (int) list.get(i).get("oracle");
			int html = (int) list.get(i).get("html");
			int sum = java + oracle + html;
			System.out.println("이름 : " + list.get(i).get("name") + ", 총점 : " + sum + "점");
		}

	}

	private int checkNumb(String name, int score) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		while (true) {
			System.out.print(name + " >> ");
			int userInput = scan.nextInt();
			if (userInput >= 0 && userInput <= score) {
				hashMap.put(name, userInput);
				return userInput;
			} else {
				System.out.println(name + " 의 범위는 0이상, " + score + " 이하 입니다.");
			}
		}

	}

}
