package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FrameTest {
    private Frame frame;
    private Frame nextFrame;
    @BeforeEach
    void setUp(){
        frame = new Frame();
        nextFrame = new Frame();
    }

    @Test
    @DisplayName("Frame 객체 생성")
    void t1() throws Exception {
        //given
        //when
        //then
        assertThat(frame).isNotNull();
    }

    @Test
    @DisplayName("frame에서 첫번째 시도 입력, 0점")
    void t2() throws Exception {
        //given
        //when
        frame.put(0);
        //then
    }

    @Test
    @DisplayName("frame에서 두번 입력, 스페어가 아닌경우")
    void t3() throws Exception {
        //given
        //when
        putTwice(frame,3, 5);
        //then
        assertThat(frame.getTotalScore()).isEqualTo(8);
    }

    @Test
    @DisplayName("frame에서 두번 입력, 스페어인 경우")
    void t4() throws Exception {
        //given
        //when
        putTwice(frame,5,5);
        //then
        assertThat(frame.isSpare()).isTrue();
    }

    @Test
    @DisplayName("스트라이크")
    void t5() throws Exception {
        //given
        //when
        frame.put(10);
        //then
        assertThat(frame.isStrike()).isTrue();
    }

    @Test
    @DisplayName("스페어일때 보너스 점수 적용")
    void t6() throws Exception {
        //given
        //when
        putTwice(frame, 3, 7);
        putTwice(nextFrame, 5, 4);

        frame.addBonusScore(nextFrame);
        //then
        assertThat(frame.getTotalScore()).isEqualTo(15);
    }

    @Test
    @DisplayName("스트라이크일때 보너스 점수 적용")
    void t7() throws Exception {
        //given
        //when
        frame.put(10);
        putTwice(nextFrame, 4, 5);
        frame.addBonusScore(nextFrame);
        //then
        assertThat(frame.getTotalScore()).isEqualTo(19);
    }

    @Test
    @DisplayName("두번 모두 다 쳐서 Frame의 입력이 다 끝났는지 확인")
    void t8() throws Exception {
        //given
        //when
        putTwice(frame, 4,5);
        //then
        assertThat(frame.isDone()).isTrue();
    }

    @Test
    @DisplayName("스트라이크를 쳐서 Frame의 입력이 끝났는지 확인")
    void t9() throws Exception {
        //given
        //when
        frame.put(10);
        //then
        assertThat(frame.isDone()).isTrue();
    }

    @Test
    @DisplayName("점수의 총 합이 10점을 넘어서는 안됨")
    void t10() throws Exception {
        //given
        //when
        //then
        assertThatThrownBy(()->{
            frame.put(12);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            putTwice(frame, 5, 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 점수를 두번 더할 수 없다.")
    void t11() throws Exception {
        //given
        putTwice(nextFrame, 5, 4);
        frame.put(10);
        frame.addBonusScore(nextFrame);

        Frame newFrame = new Frame();
        putTwice(newFrame, 3, 4);
        //when
        frame.addBonusScore(newFrame);
        //then
        assertThat(frame.getTotalScore()).isEqualTo(19);
    }
    private void putTwice(Frame frame, int trial1, int trial2) throws Exception{
        frame.put(trial1);
        frame.put(trial2);
    }

}
