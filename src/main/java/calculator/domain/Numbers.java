package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private static final String DEFAULT_DELIMITER = "[,:]";

    private static final String INVALID_INPUT_MESSAGE = "잘못된 문자가 포함되어 있습니다.";

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers extractFrom(String input) {
        try {
            List<Number> numbers = Arrays.stream(input.split(DEFAULT_DELIMITER))
                    .map(Integer::parseInt)
                    .map(Number::from)
                    .toList();

            return new Numbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public int calculate() {
        return numbers.stream()
                .mapToInt(Number::valueOf)
                .sum();
    }
}
