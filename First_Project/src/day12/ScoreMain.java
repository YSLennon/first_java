package day12;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreMain {
	public static void main(String[] args) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		Score score = new Score();
		
		System.out.println("성적관리 시스템");

		for (int i = 0; i < 3; i++) {
			list.add(score.saveScore());
		}
		score.printScore(list);

	}
}
