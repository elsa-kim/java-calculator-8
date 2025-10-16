package calculator;

import calculator.domain.CustomDelimiter;
import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String input = readInput();
        int result = computeResult(input);
        printResult(result);
    }

    private int computeResult(String input) {
        if (input.isBlank()) {
            return 0;
        }

        if (CustomDelimiter.hasCustomDelimiter(input)) {
            input = normalizeDelimiter(input);
        }

        Numbers numbers = Numbers.extractFrom(input);
        return numbers.calculate();
    }

    private String normalizeDelimiter(String input) {
        CustomDelimiter customDelimiter = CustomDelimiter.from(input);
        String numbers = CustomDelimiter.remainNumbers(input);
        return customDelimiter.changeDelimiter(numbers);
    }

    private void printResult(int total) {
        outputView.printResult(total);
    }

    private String readInput() {
        outputView.printRequireInputMessage();
        return inputView.read();
    }
}
