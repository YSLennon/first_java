package day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FruitMarket {

	static ArrayList<HashMap<String, Object>> list = new ArrayList<>();

	public static HashMap<String, Object> searchFruit(String inputName) {
		for (int i = 0; i < list.size(); i++) {
			String name = (String) list.get(i).get("name");
			if (inputName.equals(name)) {
				return list.get(i);
			}
		}
		return new HashMap<String, Object>();
	}

	public static boolean numbIsPlus(int inputNum) {
		if (inputNum < 0) {
			System.out.println("음수 입력 안됨");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("== (1)과일 추가 (2) 판매 (3) 개수확인 (그외) 종료");
			System.out.print("메뉴 선택 : ");
			int menu = s.nextInt();
			if (menu == 1) {
				HashMap<String, Object> map = new HashMap<>();
				System.out.print("과일명 : ");
				String inputName = s.next();
				map = searchFruit(inputName);

				if (map.containsKey("name")) {
					System.out.print("개수 : ");
					int inputNum = s.nextInt();

					if (numbIsPlus(inputNum)) {
						map.put("num", (int) map.get("num") + inputNum);
					}

				} else {
					map.put("name", inputName);
					System.out.print("가격 : ");
					int price = s.nextInt();

					if (price < 0) {
						System.out.println("음수 입력 안됨");
						continue;
					} else {
						map.put("price", price);
					}
					System.out.print("개수 : ");
					int num = s.nextInt();

					if (numbIsPlus(num)) {
						map.put("num", num);
						list.add(map);
					}

				}

			} else if (menu == 2) {
				// 판매
				System.out.print("과일명 : ");
				String inputName = s.next();
				System.out.print("개수 : ");
				int inputNum = s.nextInt();

				if (numbIsPlus(inputNum)) {
					HashMap<String, Object> map = searchFruit(inputName);
					if (map.containsKey("name")) {
						int num = (int) map.get("num");
						if (num < inputNum) {
							System.out.println("개수 부족!");
						} else {
							map.put("num", num - inputNum);
							System.out.println("현재 남은 " + map.get("name") + "의 개수는 " + map.get("num") + "개");
						}
					}
				}

			} else if (menu == 3) {
				// 개수확인
				System.out.print("과일 명 : ");
				String inputName = s.next();
				HashMap<String, Object> map = searchFruit(inputName);
				if (map.containsKey("name")) {
					System.out.println("현재 남은 " + map.get("name") + "의 개수는 " + map.get("num") + "개");
				}
			} else {
				System.out.println("종료되었습니다.");
				break;
			}
		}

	}
}
