package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FruitStore {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();

	void menu() {
		while (true) {
			System.out.println("== (1) 과일 추가 (2) 판매 (3) 개수확인 (그외) 종료");
			String menuChoice = scan.nextLine();
			if (menuChoice.equals("1")) {
				register();
			} else if (menuChoice.equals("2")) {
				sales();
			} else if (menuChoice.equals("3")) {
				checkNumb();
			} else
				break;
		}
	}

	private void register() {
		HashMap<String, Object> map = new HashMap<>();

		map.put("name", input("name"));
		map.put("price", Integer.parseInt(input("price")));
		map.put("numb", Integer.parseInt(input("numb")));

		list.add(map);
	}

	private void sales() {

		String fruitName = input("name");

		for (HashMap<String, Object> checkList : list) {

			if (checkList.get("name").equals(fruitName)) {
				int fruitNumb = Integer.parseInt(input("numb"));

				int newValue = (int) checkList.get("numb") - (int) fruitNumb;
				if (newValue >= 0) {
					checkList.replace("numb", newValue);
					System.out.println("판매되었습니다. \n" + fruitName + "의 현재 남은 개수는 " + checkList.get("numb") + "개 입니다.");
					return;

				} else {
					System.out.println("과일이 모자랍니다.");
					return;
				}
					

			}

		}
		System.out.println("그런 이름의 과일은 없습니다.");

	}

	private void checkNumb() {

		String fruitName = input("name");
		for (HashMap<String, Object> checkList : list) {
			if (checkList.get("name").equals(fruitName)) {
				System.out.println(fruitName + "의 현재 남은 개수는 " + checkList.get("numb") + "개 입니다.");
				return;
			}
		}

		System.out.println(fruitName + "이란 이름의 과일은 없습니다.");

	}

	private String input(String name) {
		while (true) {

			if (name.equals("name")) {
				System.out.print("과일명 입력 : ");
				return scan.nextLine();
			} else if (name.equals("price")) {
				System.out.print("가격 입력 : ");
				return scan.nextLine();
			} else if (name.equals("numb")) {
				System.out.print("갯수 입력 : ");
				return scan.nextLine();
			}

		}
	}

	// 과일 등록
	// 판매
	// 개수 확인
	// 종료

}
