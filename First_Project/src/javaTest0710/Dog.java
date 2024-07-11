package javaTest0710;


public class Dog extends Animal{

	public Dog(){
		super("이름없는 강아지", 0);
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
}

