package day6_Test;

public class Student {
	
	private int stuNo;
	private String stuName;
	private String stuDept;
	private int age;
	private String gender;
	
	
	Student(int stuNo, String stuName){
		
		this.stuNo = stuNo;
		this.stuName = stuName;
	}

	Student(int stuNo, String stuName, String stuDept){
		this(stuNo, stuName);
		this.stuDept = stuDept;
		
		
	}
	
	void setInfo(int age, String gender) {
		this.age = age;
		this.gender = gender;
	}
	
	int getAge() {
		return age;
	}
	
	void getDept() {
		System.out.println(this.stuDept);
	}

}
	
