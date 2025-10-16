package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers extractFrom(String input) {
        try {
            List<Number> numbers = Arrays.stream(input.split("[,:]"))
                    .map(Integer::parseInt)
                    .map(Number::from)
                    .toList();

            return new Numbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 문자가 포함되어 있습니다.");
        }
    }

    public int calculate() {
        return numbers.stream()
                .mapToInt(Number::valueOf)
                .sum();
    }
}
