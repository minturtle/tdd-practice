package primeFactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PrimeFactorsTest {


    @Test
    @DisplayName("nothing")
    void t1() throws Exception {
        //given
        //when
        //then
    }

    @Test
    @DisplayName("1의 소인수 구하기")
    void t2() throws Exception {
        //given
        //when
        //then
        assertPrimeFactors(1, list());
    }

    @Test
    @DisplayName("다양한 수를 소인수 분해 하기")
    void t3() throws Exception {
        //given
        //when
        //then
        assertPrimeFactors(2, list(2));
        assertPrimeFactors(3, list(3));
        assertPrimeFactors(4, list(2, 2));
        assertPrimeFactors(6, list(2,3));
        assertPrimeFactors(7, list(7));
        assertPrimeFactors(8, list(2,2,2));
        assertPrimeFactors(2*2*3*5*5*5*7*11, list(2,2,3,5,5,5,7,11));
    }
    private List<Integer> list(Integer ... args){
        return Arrays.asList(args);
    }

    private List<Integer> of(int initialValue){
        ArrayList<Integer> factors = new ArrayList<>();

        int dividedValue = initialValue;
        int divisor = 2;

        while(divisor <= dividedValue && dividedValue > 1){
            if(isDivideable(dividedValue, divisor)){
                factors.add(divisor);
                dividedValue /= divisor;
            }
            else divisor++;
        }

        return factors;
    }

    private boolean isDivideable(int n, int i) {
        return n % i == 0;
    }

    private void assertPrimeFactors(int number, List<Integer> list) {
        assertThat(list).isEqualTo(of(number));
    }
}