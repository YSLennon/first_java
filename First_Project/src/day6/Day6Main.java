package day6;

public class Day6Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.gc(); // garbage collection 요청
		
		Human_Private hong = new Human_Private();
		hong.setName("홍길동");
		hong.setAge(30);
		hong.setAddr("인천");
		System.out.println(hong.getName());



	}

}
