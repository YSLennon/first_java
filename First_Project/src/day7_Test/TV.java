package day7_Test;

public class TV {
	private int size;
	public TV(int size) { this.size = size;}
	protected int getSize() { return size;}

}

class ColorTV extends TV {
	int color;
	ColorTV(int size, int color){
		super(size);
		this.color = color; 
	}
	void printProperty(){
		System.out.println(getSize() + "인치 " + color + "컬러");
	}
	
}

class IPTV extends ColorTV {
	String name = "IPTV";
	String ip;
	IPTV(String domain, int size, int color){
		super(size, color);
		this.ip = domain;
	}
	@Override
	void printProperty() {
		System.out.println("나의 " +name + "는 " + ip + " 주소의 " + getSize() + "인치 "+ color+"컬러");
	}
}