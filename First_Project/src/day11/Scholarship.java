package day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Scholarship {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Object> hash = new HashMap<>();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();


		System.out.println("미래장학금관리시스템입니다.");
		for(int i=0; i<5 ; i++) {
			System.out.print("이름과 학점>> ");
			String[] userStr = scan.nextLine().split(" ");
			hash.put("name",userStr[0]);
			hash.put("point",Double.parseDouble(userStr[1]));
			list.add(hash);
			
		}
		System.out.print("장학생 선발 학점 기준 입력>> ");
		System.out.println(list);
		double point = Double.parseDouble(scan.nextLine());
		String printString = "장학생 명단 : ";
		
		for(int i=0; i<list.size() ; i++) {
			 double check = (double) list.get(i).get("point");
			if(point >= check){
				printString += list.get(i).get("name") + " ";
			}
		}
		System.out.println(printString);
	}

}
