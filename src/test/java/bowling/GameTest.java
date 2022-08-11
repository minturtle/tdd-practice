package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class GameTest {
    Game game;

    @BeforeEach
    void setUp(){
        game = new Game();
    }
    @Test
    @DisplayName("게임 클래스 생성")
    void t1() throws Exception {
        //given
        //when
        // then
        assertThat(game).isNotNull();
    }

    @Test
    @DisplayName("공을 던져 핀을 0개 쓰러트림")
    void t2() throws Exception {
        //given
        //when
        game.roll(0);
        //then
    }

    @Test
    @DisplayName("공을 모두 굴렸지만 핀을 하나도 못 쓰러트렸을 때")
    void t3() throws Exception {
        //given
        //when
        rollMany(0, 20);
        //then
        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("20 기회에 핀을 모두 1개씩 쓰러트린 경우")
    void t4() throws Exception {
        //given
        //when
        rollMany(1, 20);
        //then
        assertThat(game.getScore()).isEqualTo(20);
    }

    @Test
    @DisplayName("스페어 1개")
    void t5() throws Exception {
        //given
        //when
        rollSpare(5);
        game.roll(3);
        rollMany(0, 17);
        //then
        assertThat(game.getScore()).isEqualTo(16);
    }


    @Test
    @DisplayName("스트라이크 1개")
    void t6() throws Exception {
        //given
        //when
        rollStrike();
        game.roll(3);
        game.roll(5);
        rollMany(0, 17);
        //then
        assertThat(game.getScore()).isEqualTo(26);
    }

    @Test
    @DisplayName("퍼펙트 게임")
    void t7() throws Exception {
        //given
        //when
        rollMany(10, 10);
        rollStrike();
        //then
        assertThat(game.getScore()).isEqualTo(210);

    }

    private void rollStrike(){
        game.roll(10);
    }
    private void rollSpare(int firstPin) {
        game.roll(firstPin);
        game.roll(10-firstPin); //spare
    }
    //count만큼 공을 굴려 pins개의 핀을 맞추는 클래스
    private void rollMany(int pins, int count) {
        for (int i = 0; i < count; i++) {
            game.roll(pins);
        }
    }

}
