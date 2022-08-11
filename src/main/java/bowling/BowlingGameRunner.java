package bowling;

import java.util.Scanner;

public class BowlingGameRunner {

    private static final String GAMER1_NAME = "게이머 1번";
    private static final String GAMER2_NAME = "게이머 2번";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Game gamer1 = new Game();
        Game gamer2 = new Game();


        for(int i = 0; i < 10; i++){
            play(gamer1, GAMER1_NAME);
            play(gamer2, GAMER2_NAME);
            gamer1.print();
            gamer2.print();
        }
    }

    private static void play(Game gamer1, String name) {
        for(int i = 1; i < 3; i++){
            System.out.printf("%s님, %d번째에 몇개의 핀을 맞추셨나요? ", name, i);
            int pin = sc.nextInt();
            gamer1.roll(pin);
            if(pin == 10) return;
        }

    }
}
