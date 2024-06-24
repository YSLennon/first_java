package Solution;

public class Solution4 {

	public static void main(String[] args) {
		int[] a = { 5, 1, 5 };
		int b = 30;
		int[][] c = { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } };
		solution(a, b, c);

	}

	static int solution(int[] bandage, int health, int[][] attacks) {
		int answer;

		int maxHp = health;
		int bandageTime = bandage[0];
		int secHeal = bandage[1];
		int addedHeal = bandage[2];
		int attackTurn = 0;

//	        총 공격 턴
		end: for (int i = 0; i < attacks[attacks.length - 1][0]; i++) {
//	        		공격 당하면
			if (i == attacks[attackTurn][0]) {
				bandageTime = bandage[0];
				health -= attacks[attackTurn][1];
				attackTurn++;
				if (health <= 0)
					break end;

			} else {
				// 스킬 효과 -> 회복이 먼저일듯
				bandageTime--;
				health = (health + secHeal > maxHp) ? health : health + secHeal;
				if (bandageTime == 0) {
					health = (health + addedHeal > maxHp) ? health : health + addedHeal;
					bandageTime = bandage[0];
				}

			}
		}

		answer = (health <= 0) ? -1 : health;

		System.out.println(answer);
		return answer;
	}
}