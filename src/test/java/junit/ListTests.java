package junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTests {
    // Always initialized for each test
    private List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    @BeforeAll
    static void initialization(){
        System.out.println("Initialization should be run only once");
    }

    @Test
    @DisplayName("default has correct size")
    void defaultHasCorrectSize() {
        assertEquals(6, strings.size());
        strings = null;
    }

    @Test
    @DisplayName("default list has a size of six")
    void defaultListHasASizeOfSix() {
        assertThat(strings.size(), is(6));
    }
}
