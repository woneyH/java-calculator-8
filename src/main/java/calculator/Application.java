package calculator;

import controller.Controller;
import domain.Calculator;
import service.ParserService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new InputView(),
                new OutputView(),
                new Calculator(),
                new ParserService()
        );
        controller.run();
    }
}
