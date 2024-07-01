package day11;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class PointManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("** 포인트 관리 프로그램입니다 **");
		HashMap<String,Integer> hashMap = new HashMap<>();
		
		while(true) {
			System.out.print("이름과 포인트 입력>> ");
			String userInput = scan.nextLine();
			if(userInput.equals("그만")) break;
			
			StringTokenizer stToken = new StringTokenizer(userInput, " ");
			if(stToken.countTokens() != 2) {
				System.out.println("김철수 100 ->이와 같이 입력해주세요.");
			} else {

				String name = stToken.nextToken();
				int point = Integer.parseInt(stToken.nextToken());
				
				Set<String> hashName = hashMap.keySet();
				
				if(hashName.contains(name)) {
					int presentPoint = hashMap.get(name);
					hashMap.put(name, presentPoint+point);
				} else {
					hashMap.put(name, point);
				}
				for(String i: hashName) {
					System.out.print("("+ i + "," + hashMap.get(i) +")");
				}
				System.out.println();
					
				
			}

			
			
		}

	}
	
	

}
