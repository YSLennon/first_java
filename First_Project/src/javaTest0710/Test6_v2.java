package javaTest0710;

import java.util.ArrayList;
import java.util.HashMap;

public class Test6_v2 {

    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        // Wrapper Class를 만들어서 str값을 wrapper 클래스에 담아서 전달
        InputWrapperClass inputName = new InputWrapperClass();
        InputWrapperClass inputAge = new InputWrapperClass();
        InputWrapperClass inputAddr = new InputWrapperClass();

        // 조건 체크가 필요 없을 경우 디폴트 인터페이스 생성
        CheckInputFlg alwaysTrue = new CheckInputFlg() {
            @Override
            public boolean isTrue(String checkStr) {
                return true;
            }
        };

        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> map = new HashMap<>();

            StringInputClass.inputStr(inputName, "이름을", alwaysTrue);
            StringInputClass.inputStr(inputAge, "나이를", new CheckInputFlg() {
                @Override
                public boolean isTrue(String str) {
                    if(Integer.parseInt(str) > 0 && Integer.parseInt(str) <= 100) return true;

                    System.out.println("나이는 1부터 100까지 입력해주세요.");
                    return false;
                }
            });
            StringInputClass.inputStr(inputAddr, "주소를", alwaysTrue);

            map.put("name", inputName.str);
            map.put("age", inputAge.str);
            map.put("addr", inputAddr.str);
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
