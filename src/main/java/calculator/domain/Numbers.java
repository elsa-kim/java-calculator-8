package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private static final String DEFAULT_DELIMITER = "[,:]";

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers extractFrom(String input) {
        List<Number> numbers = Arrays.stream(input.split(DEFAULT_DELIMITER))
                .map(Number::from)
                .toList();

        return new Numbers(numbers);
    }

    public int calculate() {
        return numbers.stream()
                .mapToInt(Number::valueOf)
                .sum();
    }
}
