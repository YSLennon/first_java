package Solution.BearAndFish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Main extends JFrame {
    final int CHANGE_LOCATION_VALUE = 10;
    Bear bear;
    Fish fish;
    final String WINNER_MESSAGE = "YOU WIN!!!";

    Main() {
        setTitle("Bear And Fish");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bear = new Bear(5 * CHANGE_LOCATION_VALUE, 5 * CHANGE_LOCATION_VALUE, CHANGE_LOCATION_VALUE);
        fish = new Fish(20 * CHANGE_LOCATION_VALUE, 20 * CHANGE_LOCATION_VALUE, 2 * CHANGE_LOCATION_VALUE);

        JLabel winnerMessage = new JLabel(WINNER_MESSAGE);
        winnerMessage.setVisible(false);
        winnerMessage.setSize(300, 300);
        winnerMessage.setLocation(250, 250);

        JLabel bearObj = new JLabel(bear.getShape());
        bearObj.setSize(50, 50);
        bearObj.setLocation(bear.getX(), bear.getY());

        JLabel fishObj = new JLabel(fish.getShape());
        fishObj.setSize(50, 50);
        fishObj.setLocation(fish.getX(), fish.getY());


        Container layout = getContentPane();
        layout.setLayout(null);
        layout.add(fishObj);
        layout.add(bearObj);
        layout.add(winnerMessage);

        layout.setFocusable(true);
        layout.requestFocus();

        layout.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                bear.move(e);
                bearObj.setLocation(bear.getX(), bear.getY());

                fish.move(e);
                fishObj.setLocation(fish.getX(), fish.getY());

                if (bear.getX() == fish.getX() && bear.getY() == fish.getY()) {
                    fishObj.setVisible(false);
                    bearObj.setVisible(false);
                    winnerMessage.setVisible(true);
                }
            }
        });
    }


    public static void main(String[] args) {

        Main runMain = new Main();

    }

}