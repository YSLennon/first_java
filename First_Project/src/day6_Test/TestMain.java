package day6_Test;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		1. 클래스와 객체의 관계에 대해 주석으로 작성해시오.
//		클래스: 객체를 만들어내기위한 틀
//		객체: 특정한 특징이나 행동들을 가지고있는 무언가
		
//		2-5.
		Student hong = new Student(1234, "홍길동");
		Student yu = new Student(1357, "유재석", "컴퓨터학과");
		
		hong.setInfo(20, "남");
		System.out.println(hong.getAge());
		yu.getDept();
		
//		3-3.
		System.out.println(Calc.sum(1, 2));
		System.out.println(Calc.multiple(2, 4));
		System.out.println(Calc.multiple(2, 4.0));
		System.out.println(Calc.multiple("* ", 4));
		
		
		
		
		

		
	}

}
