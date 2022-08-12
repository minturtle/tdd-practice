package wordWrap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class WordWrapperTest {

    @Test
    @DisplayName("wrap하기")
    void t1() throws Exception {
        //given
        //when
        //then
        assertThat(wrap("word word", 4)).isEqualTo("word\nword");
    }

    private String wrap(String str, int length){

        final StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0,length));
        sb.append("\n");
        sb.append(str.substring(length+1));

        return sb.toString();
    }
}
