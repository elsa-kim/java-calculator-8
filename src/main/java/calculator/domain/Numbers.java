package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Numbers extractFrom(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split("[,:]")).map(Integer::parseInt).toList();
            return new Numbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 문자가 포함되어 있습니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
        }
    }

    public int calculate() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
