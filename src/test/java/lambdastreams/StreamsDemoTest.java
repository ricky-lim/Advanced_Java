package lambdastreams;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.jupiter.api.Assertions.*;

class StreamsDemoTest {
    private StreamsDemo demo = new StreamsDemo();

    @Test
    @DisplayName("test join stream")
    void testJoinStream() {
        assertEquals("this is a list of strings", demo.joinStream() );
    }

    @Test
    @DisplayName("test join upper case")
    void testJoinUpperCase() {
        assertEquals("THIS IS A LIST OF STRINGS", demo.joinUpperCase());
    }

    @Test
    @DisplayName("get total length")
    void getTotalLength() {
        assertEquals(20, demo.getTotalLength());
    }

    @Test
    @DisplayName("get the sum of the first five big decimals")
    void getTheSumOfTheFirstFiveBigDecimals() {
        assertThat(demo.sumFirstNBigDecimals(10), is(closeTo(
                1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10, 0.01
        )));
    }

    @Test
    @DisplayName("test sum randoms one")
    void testSumRandomsOne() {
        int num = 1000;
        double err = num * 0.05;
        assertThat(demo.sumRandoms1(num), is(closeTo(num / 2, err)));
    }

    @Test
    @DisplayName("test sum randoms two")
    void testSumRandomsTwo() {
        int num = 1000;
        double err = num * 0.05;
        assertThat(demo.sumRandoms2(num), is(closeTo(num / 2, err)));
    }

    @Test
    @DisplayName("sum randoms three")
    void sumRandomsThree() {
        int num = 1000;
        double err = num * 0.05;
        assertThat(demo.sumRandoms3(num), is(closeTo(num / 2, err)));
    }
}