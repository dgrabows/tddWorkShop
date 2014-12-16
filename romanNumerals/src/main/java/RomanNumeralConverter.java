import java.util.Map;

public class RomanNumeralConverter {



    public static Integer convert(String numeralText) {
        Integer sum = 0;
        Integer previous = null;
        Integer current;

        for (char character : numeralText.toCharArray()) {
            current = convertSingleCharacter(character);
            if (previous != null && current > previous) {
                sum += current - (2 * previous);
            } else {
                sum += current;
            }
            previous = current;
        }

        return sum;
    }

    public static String convert(Integer integer) {
        StringBuilder romanNumeral = new StringBuilder();
        while (integer > 0) {
            if (integer >= 1000) {
                romanNumeral.append("M");
                integer -= 1000;
            } else if (integer >= 500) {
                romanNumeral.append("D");
                integer -= 500;
            } else if (integer >= 100) {
                romanNumeral.append("C");
                integer -= 100;
            } else if (integer >= 50) {
                romanNumeral.append("L");
                integer -= 50;
            } else if (integer >= 10) {
                romanNumeral.append("X");
                integer -= 10;
            } else if (integer >= 5) {
                romanNumeral.append("V");
                integer -= 5;
            } else if (integer >= 1) {
                if (integer == 4) {
                    romanNumeral.append("IV");
                    integer -= 4;
                } else {
                    romanNumeral.append("I");
                    integer--;
                }
            }
        }

        return romanNumeral.toString();
    }

    public static Integer convertSingleCharacter(char character) {
        switch (character) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException(character + " is not a valid Roman numeral character.");
        }
    }
}
