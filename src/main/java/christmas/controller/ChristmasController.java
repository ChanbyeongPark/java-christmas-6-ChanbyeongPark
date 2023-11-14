package christmas.controller;

import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    public void start() {
        VisitDate date = inputDate();
    }

    private VisitDate inputDate() {
        try {
            return new VisitDate(InputView.inputDate());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputDate();
        }
    }
}
