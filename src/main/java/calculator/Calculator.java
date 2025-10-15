package calculator;

import calculator.domain.CustomDelimiter;
import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printRequireInputMessage();
        String input = inputView.read();
        if (input.isBlank()) {
            outputView.printResult(0);
            return;
        }
        if(CustomDelimiter.hasCustomDelimiter(input)) {
            CustomDelimiter customDelimiter = CustomDelimiter.from(input);
            String numbers = CustomDelimiter.remainNumbers(input);
            input = customDelimiter.changeDelimiter(numbers);
        }

        Numbers numbers = Numbers.extractFrom(input);
        int total = numbers.calculate();

        outputView.printResult(total);
    }
}
