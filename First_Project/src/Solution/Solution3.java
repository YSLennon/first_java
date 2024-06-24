package Solution;

import java.util.Arrays;
// 가장 많이 받은 선물 - programmers
public class Solution3 {

	public static void main(String[] args) {

		String[] friends = { "muzi", "ryan", "frodo", "neo" };
		String[] gifts = { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
				"frodo ryan", "neo muzi" };

		System.out.println(solution(friends, gifts));
	}

	public static int solution(String[] friends, String[] gifts) {
		int answer = 0;

		int[][] thisMonAToB = new int[friends.length][friends.length];
		int[] presentPoint = new int[friends.length];
		int[] nextReceive = new int[friends.length];
		int max =0;

		// 선물 갯수 체크하기
		for (int i = 0; i < gifts.length; i++) {
			// 선물을 누가 누구한테 줬는지 확인하기
			String[] aToB = String.valueOf(gifts[i]).split(" ");
			String a = aToB[0];
			String b = aToB[1];
			int give = 0;
			int receive = 0;

			for (int j = 0; j < friends.length; j++) {
				if (aToB[0].equals(friends[j]))
					give = j;
				if (aToB[1].equals(friends[j]))
					receive = j;
			}
			thisMonAToB[give][receive] += 1;
			presentPoint[give]++;
			presentPoint[receive]--;
		}
		
		
		for (int i = 0; i < thisMonAToB.length; i++) {
			for (int j = i; j < thisMonAToB[i].length; j++) {
				if(i==j) continue;
              if(thisMonAToB[i][j] < thisMonAToB[j][i]) {
            	  nextReceive[j]++;
              }else if (thisMonAToB[i][j] > thisMonAToB[j][i]) {
            	  nextReceive[i]++;
              }else if(presentPoint[i] > presentPoint[j]) nextReceive[i]++;
              else if(presentPoint[i] < presentPoint[j]) nextReceive[j]++;

			}
		}
		for(int i =1 ; i<nextReceive.length ; i++) {
			if(nextReceive[i] > nextReceive[max]) max = i;
		}
		
		answer = nextReceive[max];
		
		

		return answer;

	}

}