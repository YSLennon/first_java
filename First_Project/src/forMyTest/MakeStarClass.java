package forMyTest;

import java.util.Scanner;

public class MakeStarClass {

	public static void main(String[] args) {
		makePyramid();

	}
	static void makePyramid() {


		Scanner scan = new Scanner(System.in);
		int totalLayer;
		for (int roof = 1; roof >= 0; roof++) {

			System.out.println("2 이상의 피라미드 층 수를 입력해주세요\n숫자가 입력되지 않으면 종료됩니다.");
			String userText = scan.nextLine();
			try {
				totalLayer = Integer.parseInt(userText);

				if (totalLayer <= 1)
					System.out.println("잘못된 숫자입니다.");
				else {
					for (int layer = totalLayer; layer > 0; layer--) {

						int empty = layer - 1;
						int star = totalLayer - empty;

						for (int e = empty; e > 0; e--) {
							System.out.print(" ");
						}
						for (int s = star; s > 0; s--) {
							System.out.print("* ");
						}
						System.out.println();

					}
				}

			} catch (Exception e) {
				System.out.println("숫자가 입력되지않아 종료합니다.");
				break;
			}

		}
	}
}