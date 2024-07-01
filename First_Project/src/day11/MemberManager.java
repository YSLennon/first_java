package day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MemberManager {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();

		while (true) {
			System.out.println("== (1)입력 (2)검색 (3)종료 ==");
			System.out.print("메뉴를 선택하세요 : ");
			String menu = scan.nextLine();
			HashMap<String, Object> map;

			if (menu.equals("1")) {

				map = new HashMap<>();

				System.out.print("이름 : ");
				map.put("name", scan.next());
				System.out.print("나이 : ");
				map.put("age", scan.nextInt());
				System.out.print("주소 : ");
				map.put("addr", scan.next());
				System.out.print("핸드폰 : ");
				map.put("phone", scan.next());

				list.add(map);
				
			} else if (menu.equals("2")) {
				System.out.println(list);
				System.out.print("검색할 이름을 입력하세요 : ");
				
				String userInput = scan.next();
				Iterator<HashMap<String, Object>> iterator = list.iterator();
				System.out.println(iterator);
				boolean flg = false;
				
				while (iterator.hasNext()) {
					map = iterator.next();
					if (map.get("name").equals(userInput)) {
						System.out.println("이름 : " + map.get("name"));
						System.out.println("나이 : " + map.get("age"));
						System.out.println("주소 : " + map.get("addr"));
						System.out.println("핸드폰 : " + map.get("phone"));
						flg = true;
						break;
					}
				}
				
				if (!flg)
					System.out.println("찾는 사람이 없습니다.");
				else if (menu.equals("3")) {

					System.out.println("종료되었습니다!");
					break;
				} else {
					System.out.println("1, 2, 3 중에 하나를 입력해주세요");
				}
			}

		}

	}

}
