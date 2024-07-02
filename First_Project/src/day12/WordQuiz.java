package day12;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class WordQuiz {
	Random random = new Random();

	private Vector<Word> v;
	private String name;

	int getVSize() {
		return v.size();
	}

	public WordQuiz(String name) {
		this.name = name;
		v = new Vector<Word>();
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "꿀"));
		v.add(new Word("dall", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
	}

	int returnQuiz() {
		
		Vector<Word> v2 = (Vector<Word>) v.clone();
		ArrayList<String> quizViewList = new ArrayList<>();
		int returnInt = 0;
		
		Word nowQuiz = v2.get(random.nextInt(0, v2.size()));
		v2.remove(nowQuiz);

		quizViewList.add(nowQuiz.getKorean());
		System.out.println(nowQuiz.getEnglish() + "?");

		for (int i = 0; i < 3; i++) {
			Word otherView = v2.get(random.nextInt(0, v2.size()));
			v2.remove(otherView);

			quizViewList.add(otherView.getKorean());
		}
		
		for(int i=1; i<=4 ; i++) {
			int ranNumb = random.nextInt(0, quizViewList.size());
			System.out.print("("+ (i) + ")"+quizViewList.get(ranNumb) + " ");
			if(nowQuiz.getKorean().equals(quizViewList.get(ranNumb))) returnInt = i;

			quizViewList.remove(ranNumb);
			
		}
		System.out.print(":>");
		
		return returnInt;

	}

	public String getName() {
		return name;
	}

}
