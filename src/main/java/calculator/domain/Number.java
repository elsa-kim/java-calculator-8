package calculator.domain;

public class Number {
    private static final String INVALID_NUMBER_MESSAGE = "양수만 입력 가능합니다.";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 문자가 포함되어 있습니다.";

    private final int number;

    private Number(int number) {
        validatePositive(number);
        this.number = number;
    }

    public static Number from(String input) {
        try {
            int number = Integer.parseInt(input);
            return new Number(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    private void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

}
