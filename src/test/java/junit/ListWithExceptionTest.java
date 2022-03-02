package junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListWithExceptionTest {
    private List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    @Test
    @DisplayName("default list has six strings")
    void defaultListHasSixStrings() {
        assertThat(strings.size(), is(6));
    }

    @Test
    @DisplayName("null list throws NPE")
    void nullListThrowsNpe() {
        assertThrows(NullPointerException.class, () -> {
            strings = null;
            strings.add("hello");
        });
    }

    @Test
    @DisplayName("access strings arrays beyond its size should throw error")
    void accessStringsArraysBeyondItsSizeShouldThrowError() {
        String[] stringArray = strings.toArray(new String[0]);
        int outSize = stringArray.length + 1;

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> System.out.println(stringArray[outSize]));
        assertThat(exception.getMessage(), containsString(Integer.toString(outSize)));
    }

}
