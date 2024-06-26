package day8_Test4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		char[] map = {'-','-','-','-','-','-','-','-','-','-'};
		Bear bear = new Bear(0,0,1);
		Fish fish = new Fish(5,10,1);
		
		int[] bearXY = {bear.getX(), bear.getY()};
		int[] fishXY = {fish.getX(), fish.getY()};
		
		
		while(bear.collide(fish)) {
			for(int j = 9 ; j >= 0; j--) {
				for(int i = 0 ; i<20 ; i++ ) {
					if(bearXY[0]==i && bearXY[1]==j) {
						map[i] = bear.getShape();
					}
					if(fishXY[0]==i && fishXY[1]==j) {
						map[i] = fish.getShape();
					}
					System.out.println(Arrays.toString(map));
				}
			}
			System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >>");
			String move = scan.nextLine();
			bear.move(move);
			fish.move(move);
			
			
		}
		System.out.println("Bear Wins!!");
		
		
	}

}