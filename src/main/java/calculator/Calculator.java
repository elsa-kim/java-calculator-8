package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();

    public void run() {
        outputView.printRequireInputMessage();
        String input = inputView.read();
        if (input.isBlank()) {
            outputView.printResult(0);
            return;
        }

        outputView.printResult(1);
    }
}
