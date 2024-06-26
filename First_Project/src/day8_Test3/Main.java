package day8_Test3;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		Scanner scan = new Scanner(System.in)
				;
		String[] wordArray = {"자바", "코틀린", "스트링", "스플릿", "알파고"};
		
		System.out.println("끝말잇기 게임을 시작합니다...");
		int playerNumb = game.playerNumb();
		String[] playerArray = game.multiPlayerName(playerNumb);
		
		String startWord = game.startWord(wordArray);
		
		String saveWord = startWord;
		String word;
		end:
		while(true) {
			
			for(int i=0; i<playerArray.length ; i++) {
				
				System.out.println(playerArray[i] + ">>");	
				word = scan.nextLine();
				
				char lastChar = saveWord.charAt(saveWord.length()-1);
				char firstChar = word.charAt(0);
				
				if(lastChar == firstChar) {
					saveWord = word;
				} else {
					System.out.println(playerArray[i] + "님이 졌습니다.");
					break end;
				}
				
			}
			
		}

	}

}

class Game implements GameRule {

	@Override
	public int playerNumb() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int playerNumb;
		
		while (true) {
		System.out.println("게임에 참가하는 인원은 몇명입니까>>");

		playerNumb = scan.nextInt();
		
			if (playerNumb <= 1)
				System.out.println("2 이상의 숫자를 입력해주세요");
			else
				break;
		}

		return playerNumb;
	}

	@Override
	public String[] multiPlayerName(int numb) {
		Scanner scan = new Scanner(System.in);
		String[] players = new String[numb];

		for (int i = 0; i < numb; i++) {
			System.out.println("참가자의 이름을 입력하세요>>");
			String player = scan.nextLine();
			players[i] = player;

		}
		return players;
	}

	@Override
	public String startWord(String[] wordArray) {
		Random ran = new Random();
		int randomInt = ran.nextInt(wordArray.length);

		System.out.println("시작하는 단어는 " + wordArray[randomInt] + "입니다");

		return wordArray[randomInt];
	}

}
