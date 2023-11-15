package christmas.controller;

import christmas.domain.TotalPriceBeforeDiscount;
import christmas.domain.VisitDate;
import christmas.domain.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    public void start() {
        printStart();

        VisitDate date = inputDate();

        OrderMenus menus = inputMenus();

        printResult(date, menus);
    }

    private void printStart() {
        OutputView.printPlannerStart();
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

    private void printResult(VisitDate date, OrderMenus menus) {
        OutputView.printResultStart(date);

        OutputView.printMenus(menus);

        TotalPriceBeforeDiscount totalPriceBeforeDiscount = calculateTotalPriceBeforeDiscount(menus);

        //printGift()
    }

    private TotalPriceBeforeDiscount calculateTotalPriceBeforeDiscount(OrderMenus menus) {
        TotalPriceBeforeDiscount totalPriceBeforeDiscount = new TotalPriceBeforeDiscount(menus.getOrderMenus());
        OutputView.printTotalPriceBeforeDiscount(totalPriceBeforeDiscount.getTotalPriceBeforeDiscount());
        return totalPriceBeforeDiscount;
    }
}
