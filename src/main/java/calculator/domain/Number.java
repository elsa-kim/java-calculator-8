package calculator.domain;

public class Number {
    private static final int MIN_VALID_NUMBER = 1;

    private static final String INVALID_NUMBER_MESSAGE = "양수만 입력 가능합니다.";

    private final int number;

    private Number(int number) {
        validate(number);
        this.number = number;
    }

    public static Number from(int number) {
        return new Number(number);
    }

    public int valueOf() {
        return number;
    }

    private void validate(int number) {
        if (isInvalid(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    private boolean isInvalid(int number) {
        return number < MIN_VALID_NUMBER;
    }
}
