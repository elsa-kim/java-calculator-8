package calculator.domain;

public class CustomDelimiter {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final int CUSTOM_DELIMITER_LENGTH = 2;

    private static final String INVALID_CUSTOM_DELIMITER_MESSAGE = "커스텀 구분자는 빈 값일 수 없습니다.";

    private final String customDelimiter;

    private CustomDelimiter(String customDelimiter) {
        validateNotBlank(customDelimiter);
        this.customDelimiter = customDelimiter;
    }

    public static CustomDelimiter from(String expression) {
        String customDelimiter = expression.substring(CUSTOM_DELIMITER_LENGTH,
                expression.indexOf(CUSTOM_DELIMITER_SUFFIX));
        return new CustomDelimiter(customDelimiter);
    }

    public static boolean hasCustomDelimiter(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX) && expression.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    public static String remainNumbers(String input) {
        return input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_LENGTH);
    }

    public String changeDelimiter(String input) {
        return input.replace(customDelimiter, DEFAULT_DELIMITER_COMMA);
    }

    private void validateNotBlank(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_MESSAGE);
        }
    }
}
