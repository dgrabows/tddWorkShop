import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumeralConverterTest {

	@Test
    public void shouldReturn1ForI() {
        testRomanNumeralToAribicNumeral("I", 1);
    }

    @Test
    public void shouldReturn5ForV() {
        testRomanNumeralToAribicNumeral("V", 5);
    }

    @Test
    public void shouldReturn2ForII() throws Exception {
        testRomanNumeralToAribicNumeral("II", 2);
    }

    @Test
    public void shouldReturn4ForIV() throws Exception {
        testRomanNumeralToAribicNumeral("IV", 4);
    }

    @Test
    public void shouldReturn90ForXC() throws Exception {
        testRomanNumeralToAribicNumeral("XC", 90);
    }

    private void testRomanNumeralToAribicNumeral(String romanNumeral, Integer aribicNumeral) {
        Integer actualResult = RomanNumeralConverter.convert(romanNumeral);
        assertEquals(aribicNumeral, actualResult);
    }

    @Test
    public void testConversionOfAribicNumeralToRomanNumeral() throws Exception {
        checkConversionOfAribicNumeralToRomanNumeral(1, "I");
        checkConversionOfAribicNumeralToRomanNumeral(2, "II");
        checkConversionOfAribicNumeralToRomanNumeral(5, "V");
        checkConversionOfAribicNumeralToRomanNumeral(10, "X");
        checkConversionOfAribicNumeralToRomanNumeral(50, "L");
        checkConversionOfAribicNumeralToRomanNumeral(100, "C");
        checkConversionOfAribicNumeralToRomanNumeral(500, "D");
        checkConversionOfAribicNumeralToRomanNumeral(1000, "M");
    }

    @Test
    public void shouldReturnIVFor4() throws Exception {
        checkConversionOfAribicNumeralToRomanNumeral(4, "IV");
    }

    private void checkConversionOfAribicNumeralToRomanNumeral(int arabicNumeral, String romanNumeral) {
        String actualResult = RomanNumeralConverter.convert(arabicNumeral);
        String expectedResult = romanNumeral;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertSingleCharacter() {
        checkConversionOfSingleCharacter('I', 1);
        checkConversionOfSingleCharacter('V', 5);
        checkConversionOfSingleCharacter('X', 10);
        checkConversionOfSingleCharacter('L', 50);
        checkConversionOfSingleCharacter('C', 100);
        checkConversionOfSingleCharacter('D', 500);
        checkConversionOfSingleCharacter('M', 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRomanNumeralThrowsIllegalArgumentException() throws Exception {
        RomanNumeralConverter.convertSingleCharacter('T');
    }

    private void checkConversionOfSingleCharacter(char character, Integer value) {
        Integer actualResult = RomanNumeralConverter.convertSingleCharacter(character);
        Integer expectedResult = value;
        assertEquals(expectedResult, actualResult);
    }
}
