package movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MovieTest{

    Movie movie;

    @BeforeEach
    void setUp(){
        movie = new Movie();
    }
    @Test
    @DisplayName("무비 객체 만들기")
    void t1() throws Exception {
        //given
        //when
        //then
        Assertions.assertThat(movie).isNotNull();
    }

    @Test
    @DisplayName("무비 객체가 만들어진 직후, average는 0이여야함.")
    void t2() throws Exception {
        //given
        //when
        //then
        Assertions.assertThat(movie.getAverageRating()).isEqualTo(0.0);
    }

    @Test
    @DisplayName("무비에 평가 1점 주기")
    void t3() throws Exception {
        //given
        //when
        movie.rate(1);
        //then
        Assertions.assertThat(movie.getAverageRating()).isEqualTo(1);
    }

    @Test
    @DisplayName("평점을 두명이 줬을때(3,5점) 평균이 잘 나오는지 테스트")
    void t4() throws Exception {
        //given
        //when
        movie.rate(3.0);
        movie.rate(5.0);
        //then
        Assertions.assertThat(movie.getAverageRating()).isEqualTo(4.0);
    }

    @Test
    @DisplayName("평점이 0~5점 사이가 아닐 때 IllegalArgumentExeption 발생")
    void t5() throws Exception {
        //given
        //when
        //then
        assertThatThrownBy(()->{
            movie.rate(-1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            movie.rate(6.0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}