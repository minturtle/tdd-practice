package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FrameListTest {

    private FrameList frameList;

    @BeforeEach
    void setUp(){
        frameList = new FrameList();
    }

    @Test
    @DisplayName("FrameList 객체 생성")
    void t1() throws Exception {
        //given
        //when
        //then
        assertThat(frameList).isNotNull();
    }


    @Test
    @DisplayName("20번의 기회 모두 0점")
    void t2() throws Exception {
        //given
        //when
        putMany(20, 0);
        //then
        assertThat(frameList.getTotalScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("20번의 기회 모두 1점")
    void t3() throws Exception {
        //given
        //when
        putMany(20, 1);
        //then
        assertThat(frameList.getTotalScore()).isEqualTo(20);
    }

    @Test
    @DisplayName("1번의 스페어, 나머지 1점")
    void t4() throws Exception {
        //given
        //when
        frameList.put(4);
        frameList.put(6);
        putMany(18, 1);
        //then
        assertThat(frameList.getTotalScore()).isEqualTo(29);
    }

    @Test
    @DisplayName("1번의 스트라이크, 나머지 1점")
    void t5() throws Exception {
        //given
        //when
        frameList.put(10);
        //then
        putMany(18, 1);
        assertThat(frameList.getTotalScore()).isEqualTo(30);
    }

    @Test
    @DisplayName("10번째 프레임에서 스페어 처리")
    void t6() throws Exception {
        //given
        //when
        putMany(18, 0);
        putMany(2, 5); //spare
        putMany(2, 1); //추가 기회
        //then
        assertThat(frameList.getTotalScore()).isEqualTo(13);
    }

    @Test
    @DisplayName("10번째 프레임에서 스트라이크 처리")
    void t7() throws Exception {
        //given
        //when
        putMany(18, 0);
        frameList.put(10); // strike
        putMany(2, 1); //추가 기회
        //then
        assertThat(frameList.getTotalScore()).isEqualTo(14);
    }

    @Test
    @DisplayName("10번 모두 스페어")
    void t8() throws Exception {
        //given
        //when
        putMany(22, 5);
        //then
        assertThat(frameList.getTotalScore()).isEqualTo(160);
    }

    @Test
    @DisplayName("10번 모두 스트라이크")
    void t9() throws Exception {
        //given
        //when
        putMany(11, 10);
        //then
        assertThat(frameList.getTotalScore()).isEqualTo(210);
    }
    private void putMany(int count, int score) {
        for(int i = 0; i < count; i++){
            frameList.put(score);
        }
    }

}