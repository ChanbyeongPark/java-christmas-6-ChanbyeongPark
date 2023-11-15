package christmas.controller;

import christmas.domain.VisitDate;
import christmas.domain.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    public void start() {
        VisitDate date = inputDate();

        OrderMenus orderMenus = inputMenus();

    }

    private VisitDate inputDate() {
        try {
            return new VisitDate(InputView.inputDate());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputDate();
        }
    }

    private OrderMenus inputMenus() {
        try {
            return new OrderMenus(InputView.inputMenus());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputMenus();
        }
    }
}
