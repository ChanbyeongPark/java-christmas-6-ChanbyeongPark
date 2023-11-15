package christmas.controller;

import christmas.domain.*;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private static final int MIN_FOR_DISCOUNT = 10000;
    private static final int FREE_GIFT_PRICE = 25000;
    private static final int ZERO = 0;
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
        FreeGift freeGift = calculateFreeGift(totalPriceBeforeDiscount);

        boolean discountFlag = totalPriceBeforeDiscount.getTotalPriceBeforeDiscount() >= MIN_FOR_DISCOUNT;
        TotalDiscount totalDiscount = calculateTotalDiscount(date, menus, freeGift, discountFlag);
        printIfZeroDiscount(totalDiscount);

        printTotalDiscount(totalDiscount);
        printTotalPriceAfterDiscount(totalPriceBeforeDiscount, totalDiscount, freeGift);

    }

    private TotalPriceBeforeDiscount calculateTotalPriceBeforeDiscount(OrderMenus menus) {
        TotalPriceBeforeDiscount totalPriceBeforeDiscount = new TotalPriceBeforeDiscount(menus.getOrderMenus());
        OutputView.printTotalPriceBeforeDiscount(totalPriceBeforeDiscount.getTotalPriceBeforeDiscount());
        return totalPriceBeforeDiscount;
    }

    private FreeGift calculateFreeGift(TotalPriceBeforeDiscount totalPriceBeforeDiscount) {
        FreeGift freeGift = new FreeGift(totalPriceBeforeDiscount);
        OutputView.printFreeGift(freeGift.getFreeGift());
        return freeGift;
    }

    private TotalDiscount calculateTotalDiscount(VisitDate date, OrderMenus menus, FreeGift freeGift, boolean flag) {
        OutputView.printDiscountStart();

        return calculateDiscounts(date, menus, freeGift, flag);
    }

    private TotalDiscount calculateDiscounts(VisitDate date, OrderMenus menus, FreeGift freeGift, boolean flag) {
        DDayDiscount dDayDiscount = calulateDDayDiscount(date, flag);

        WeekdayDiscount weekdayDiscount = calculateWeekdayDiscount(date, menus, flag);

        WeekendDiscount weekendDiscount = calculateWeekendDiscount(date, menus, flag);

        SpecialDiscount specialDiscount = calculateSpecialDiscount(date, flag);

        FreeGiftDiscount freeGiftDiscount = calculateFreeGiftDiscount(freeGift, flag);

        return new TotalDiscount(dDayDiscount, weekdayDiscount, weekendDiscount, specialDiscount, freeGiftDiscount, flag);
    }

    private DDayDiscount calulateDDayDiscount(VisitDate date, boolean flag) {
        DDayDiscount dDayDiscount = new DDayDiscount(date);
        if (dDayDiscount.getDDayDiscount() > ZERO && flag) {
            OutputView.printDDayDiscount(dDayDiscount.getDDayDiscount());
        }
        return dDayDiscount;
    }

    private WeekdayDiscount calculateWeekdayDiscount(VisitDate date, OrderMenus menus, boolean flag) {
        WeekdayDiscount weekdayDiscount = new WeekdayDiscount(date, menus);
        if (weekdayDiscount.getWeekdayDiscount() > ZERO && flag) {
            OutputView.printWeekdayDiscount(weekdayDiscount.getWeekdayDiscount());
        }
        return weekdayDiscount;
    }

    private WeekendDiscount calculateWeekendDiscount(VisitDate date, OrderMenus menus, boolean flag) {
        WeekendDiscount weekendDiscount = new WeekendDiscount(date, menus);
        if (weekendDiscount.getWeekendDiscount() > ZERO && flag) {
            OutputView.printWeekendDiscount(weekendDiscount.getWeekendDiscount());
        }
        return weekendDiscount;
    }

    private SpecialDiscount calculateSpecialDiscount(VisitDate date, boolean flag) {
        SpecialDiscount specialDiscount = new SpecialDiscount(date);
        if (specialDiscount.getSpecialDiscount() > ZERO && flag) {
            OutputView.printSpecialDiscount(specialDiscount.getSpecialDiscount());
        }
        return specialDiscount;
    }

    private FreeGiftDiscount calculateFreeGiftDiscount(FreeGift freeGift, boolean flag) {
        FreeGiftDiscount freeGiftDiscount = new FreeGiftDiscount(freeGift);
        if (freeGiftDiscount.getFreeGiftDiscount() > ZERO && flag) {
            OutputView.printFreeGiftDiscount(freeGiftDiscount.getFreeGiftDiscount());
        }
        return freeGiftDiscount;
    }

    private void printIfZeroDiscount(TotalDiscount totalDiscount) {
        if (totalDiscount.getTotalDiscount() == ZERO) {
            OutputView.printNothing();
        }
    }

    private void printTotalDiscount(TotalDiscount totalDiscount) {
        OutputView.printTotalDiscount(totalDiscount.getTotalDiscount());
    }

    private void printTotalPriceAfterDiscount(TotalPriceBeforeDiscount totalPriceBeforeDiscount,
                                              TotalDiscount totalDiscount, FreeGift freeGift) {
        int freeGiftPrice = 0;
        if (freeGift.getFreeGift()) {
            freeGiftPrice = FREE_GIFT_PRICE;
        }
        int priceBeforeDiscount = totalPriceBeforeDiscount.getTotalPriceBeforeDiscount();
        int discount = totalDiscount.getTotalDiscount();
        int priceAfterDiscount = priceBeforeDiscount-discount+freeGiftPrice;
        OutputView.printTotalPriceAfterDiscount(priceAfterDiscount);
    }
}
