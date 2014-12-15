import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FizzBuzzTest {

	@Test
    public void shouldReturn1for1() {
        checkFizzBuzz("1", 1);
    }

    @Test
    public void shouldReturn1for2() {
        checkFizzBuzz("2", 2);
    }

    @Test
    public void shouldReturnFizzForMultiplesOf3() {
        checkFizzBuzz("Fizz", 3);
        checkFizzBuzz("Fizz", 6);
        checkFizzBuzz("Fizz", 9);
    }

    @Test
    public void shouldReturnBuzzForMultiplesOf5() {
        checkFizzBuzz("Buzz", 5);
        checkFizzBuzz("Buzz", 10);
        checkFizzBuzz("Buzz", 20);
    }

    @Test
    public void shouldReturnFizzBuzzForMultiplesOf3And5() {
        checkFizzBuzz("FizzBuzz", 15);
        checkFizzBuzz("FizzBuzz", 30);
        checkFizzBuzz("FizzBuzz", 45);
    }

    @Test(expected = AssertionError.class)
    public void shouldFailAssertionWithNullInput() {
        new FizzBuzz().process(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForValuesLessThan1() {
        checkForIllegalArgumentException(0);
        checkForIllegalArgumentException(-1);
        checkForIllegalArgumentException(Integer.MIN_VALUE);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForValuesGreaterThan100() {
        checkForIllegalArgumentException(101);
        checkForIllegalArgumentException(102);
        checkForIllegalArgumentException(Integer.MAX_VALUE);
    }

    private void checkForIllegalArgumentException(int input) {
        try {
            new FizzBuzz().process(input);
            fail("Expected IllegalArgumentException.");
        } catch (Exception e) {
            // expected
        }
    }

    private void checkFizzBuzz(String expectedReturnValue, Integer input) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actualReturnValue = fizzBuzz.process(input);
        assertEquals(String.format("Failed for input %s.", input), expectedReturnValue, actualReturnValue);
    }
}