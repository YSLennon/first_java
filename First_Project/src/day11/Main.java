package day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		ArrayList<Student> list = new ArrayList<>();
		System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
		String flg = "";

		while (!flg.equals("그만")) {
			System.out.print(">> ");
			String userString = scan.nextLine();
			if (!userString.equals("그만")) {
				String[] strArr = userString.split(",");
				Student stu = new Student(strArr[0], strArr[1], strArr[2], Double.valueOf(strArr[3]));
				list.add(stu);
			} else
				flg = userString;
		}

		Iterator<Student> listIterator = list.iterator();
		while ((listIterator.hasNext())) {
			line();
			Student it = listIterator.next();
			System.out.println("이름 : " + it.getName());
			System.out.println("학과 : " + it.getDepartment());
			System.out.println("학번 : " + it.getId());
			System.out.println("학점평균 : " + it.getGrade());
			line();
		}

		ArrayList<HashMap<String, Object>> list2 = new ArrayList<>();
		
		HashMap<String, Object> hashMap = new HashMap<>();
		listIterator = list.iterator();
		
		while ((listIterator.hasNext())) {
			Student it = listIterator.next();

			hashMap.put("name", it.getName());
			hashMap.put("department", it.getDepartment());
			hashMap.put("id", it.getId());
			hashMap.put("grade", it.getGrade());
			list2.add(hashMap);

		}
		
		System.out.println();
		System.out.println(list2);

	}

	static void line() {
		System.out.println("---------------------------");
	}
}
