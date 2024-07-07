package Solution.BearAndFish;

import java.awt.event.KeyEvent;

public abstract class GameObject { // 추상 클래스
	protected int distance; // 한 번 이동 거리
	protected int x, y; // 현재 위치(화면 맵 상의 위치)
	
	public GameObject(int startX, int startY, int distance) { // 초기 위치와 이동 거리 설정
		if(startX >= 500) startX = 500;
		if(startY >= 500) startY = 500;
		if(startX < 0) startX = 0;
		if(startY < 0) startY =0;
		this.x = startX; this.y = startY;
		this.distance = distance;
	}
	public int getX() { return x; }
	public int getY() { return y; }

	
	protected abstract void move(KeyEvent e); // 이동한 후의 새로운 위치로 x, y 변경
	protected abstract String getShape(); // 객체의 모양을 나타내는 문자 리턴
}
