package calculator.domain;

public class CustomDelimiter {
    private final String customDelimiter;

    private CustomDelimiter(String customDelimiter) {
        validate(customDelimiter);
        this.customDelimiter = customDelimiter;
    }

    public static CustomDelimiter from(String expression) {
        String customDelimiter = expression.substring(2, expression.indexOf("\\n"));
        return new CustomDelimiter(customDelimiter);
    }

    public static boolean hasCustomDelimiter(String expression) {
        return expression.startsWith("//") && expression.contains("\\n");
    }

    public static String remainNumbers(String input) {
        return input.substring(input.indexOf("\\n") + 2);
    }

    public String changeDelimiter(String input) {
        return input.replace(customDelimiter, ",");
    }

    private void validate(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException("커스텀 구분자는 빈 값일 수 없습니다.");
        }
    }
}
