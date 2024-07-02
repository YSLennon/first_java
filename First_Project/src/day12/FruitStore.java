package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class FruitStore {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	//	TODO 가격이나 수량을 음수로 입력할 경우 메시지 "음수 입력은 불가능" 출혁 후 메인으로 이동한다.
	//	TODO 중복된 과일이 입력될 경우 기존 값에 개수를 더해줌 + 가격을 물어보지 않는다.

	void menu() {
		while (true) {
			System.out.println("== (1) 과일 추가 (2) 판매 (3) 개수확인 (그외) 종료");
			String menuChoice = scan.nextLine();
			try {
				if (menuChoice.equals("1")) {
					register();
				} else if (menuChoice.equals("2")) {
					sales();
				} else if (menuChoice.equals("3")) {
					checkNumb();
				} else
					break;
			} catch (ToMenuException e) {
				continue;
			}
		}
	}

	private void register() throws ToMenuException {

		HashMap<String, Object> map = new HashMap<>();
		String name = input("name");

		Iterator<HashMap<String, Object>> iterator = list.iterator();
		while (iterator.hasNext()) {
			HashMap<String, Object> thisMap = iterator.next();
			if (thisMap.get("name").equals(name)) {
				int sumNumb = (int) thisMap.get("numb") + Integer.parseInt(input("numb"));
				thisMap.put("numb", sumNumb);
				System.out.println(name + "의 총 갯수는 " + sumNumb + "개 입니다.");
				return;
			}
		}

		map.put("name", name);
		map.put("price", Integer.parseInt(input("price")));
		map.put("numb", Integer.parseInt(input("numb")));
		list.add(map);

	}

	private void sales() throws ToMenuException {

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

	private void checkNumb() throws ToMenuException {

		String fruitName = input("name");
		for (HashMap<String, Object> checkList : list) {
			if (checkList.get("name").equals(fruitName)) {
				System.out.println(fruitName + "의 현재 남은 개수는 " + checkList.get("numb") + "개 입니다.");
				return;
			}
		}

		System.out.println(fruitName + "이란 이름의 과일은 없습니다.");

	}

	private String input(String name) throws ToMenuException {
		while (true) {

			if (name.equals("name")) {
				System.out.print("과일명 입력 : ");
				return scan.nextLine();
			} else if (name.equals("price")) {
				System.out.print("가격 입력 : ");
				String price = scan.nextLine();
				checkException(price);

				return price;
			} else if (name.equals("numb")) {
				System.out.print("갯수 입력 : ");
				String numb = scan.nextLine();
				checkException(numb);

				return numb;
			}

		}
	}

	class ToMenuException extends Exception {
		public ToMenuException() {
		}

		ToMenuException(String s) {

		}
	}

	private void checkException(String checkNumb) throws ToMenuException {
		try {
			if (Integer.parseInt(checkNumb) < 0) {
				System.out.println("음수 입력은 불가능");
				throw new ToMenuException();
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요");
			throw new ToMenuException();
		}
	}

}
