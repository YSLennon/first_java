package day08_Test4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Bear bear = new Bear(0, 0, 1);
        Fish fish = new Fish(5, 9, 2);



        while (!bear.collide(fish)) {

            int[] bearXY = {bear.getX(), bear.getY()};
            int[] fishXY = {fish.getX(), fish.getY()};

            for (int y = 9; y >= 0; y--) {
                char[] map = {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'};

                for (int x = 0; x < 20; x++) {
                    if (bearXY[0] == x && bearXY[1] == y) {
                        map[x] = bear.getShape();
                    }
                    if (fishXY[0] == x && fishXY[1] == y) {
                        map[x] = fish.getShape();
                    }
                }
                System.out.println(map);
            }
            System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >>");
            String move = scan.nextLine();
            bear.move(move);
            fish.move(move);


        }
        System.out.println("Bear Wins!!");


    }

}