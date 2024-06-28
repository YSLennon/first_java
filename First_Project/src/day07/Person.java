package day07;

public class Person {
	private String name;
	int age;
	Person(){
		System.out.println("Person 기본 생성자!");
	}
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	
	void speak() {
		System.out.println("말한다");
	}
	void eat() {
		System.out.println("먹는다");
	}
	void walk() {
		System.out.println("걷는다");
	}
}

class Student extends Person{
	int stuNo;
	String stuDept;
	Student(){
		System.out.println("Student 기본 생성자!");
	}
	Student(String name, int age){
		super(name, age);
//		System.out.println("Student의 매개변수 있는 생성자");
	}
	Student(String name, int age, int stuNo, String stuDept){
		super(name, age);
		this.stuNo = stuNo;
		this.stuDept = stuDept;
		
	}
	
	
	void study() {
		System.out.println("공부한다");
	}
	
}




