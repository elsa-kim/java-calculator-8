package calculator.domain;

public class Number {
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
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    private boolean isInvalid(int number) {
        return number <= 0;
    }
}
