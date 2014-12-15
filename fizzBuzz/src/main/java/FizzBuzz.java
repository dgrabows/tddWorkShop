public class FizzBuzz {

    public String process(Integer inputValue) {
        checkInputConditions(inputValue);
        if (isMultipleOf3(inputValue) && isMultipleOf5(inputValue)) {
            return "FizzBuzz";
        } else if (isMultipleOf3(inputValue)) {
            return "Fizz";
        } else if (isMultipleOf5(inputValue)) {
            return "Buzz";
        } else {
            return inputValue.toString();
        }
    }

    private void checkInputConditions(Integer inputValue) {
        assert(inputValue != null);
        if (inputValue < 1 || inputValue > 100) {
            throw new IllegalArgumentException("Input must be between 1 and 100, inclusive.");
        }
    }

    private boolean isMultipleOf5(Integer inputValue) {
        return inputValue % 5 == 0;
    }

    private boolean isMultipleOf3(Integer inputValue) {
        return inputValue % 3 == 0;
    }
}
