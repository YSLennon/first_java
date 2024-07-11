package javaTest0710;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test6 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> map = new HashMap<>();

            String name;
            int age;
            String addr;

            System.out.print("이름을 입력하세요 : ");
            name = scan.next();

            while (true) {
                System.out.print("나이를 입력하세요 : ");
                age = scan.nextInt();
                if (age <= 0 || age > 100)
                    System.out.println("나이는 1부터 100까지 입력해주세요.");
                else
                    break;
            }
            System.out.print("주소를 입력하세요 : ");
            addr = scan.next();

            map.put("name", name);
            map.put("age", age);
            map.put("addr", addr);
            list.add(map);

        }
        // 검증코드
        for (int i = 0; i < list.size(); i++) {
            System.out.println("--------------------------");
            System.out.println("List[" + i + "]");
            System.out.println(list.get(i).get("name"));
            System.out.println(list.get(i).get("age"));
            System.out.println(list.get(i).get("addr"));

        }

    }

}
