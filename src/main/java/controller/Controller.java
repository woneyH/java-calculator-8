package controller;

import domain.Calculator;
import service.ParserService;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView in;
    private final OutputView out;
    private Calculator calculator;
    private ParserService parserService;

    public Controller(InputView in, OutputView out, Calculator calculator, ParserService parserService){
        this.in = in;
        this.out = out;
        this.calculator = calculator;
        this.parserService = parserService;
    }

    public void run(){
        String str = in.input();
        int result = calculator.plus(parserService.parseNumber(str));
        out.output(result);
    }
}
