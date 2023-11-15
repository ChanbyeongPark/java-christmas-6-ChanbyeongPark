package christmas.domain;

import java.util.List;

import static christmas.domain.Menu.stringToEnumMenu;

public class WeekdayDiscount {
    private static final int WEEK_INTERVAL = 7;
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    private static final int DISCOUNT_PER_DESSERT = 2023;
    private static final int ZERO = 0;
    private final int weekdayDiscount;

    public WeekdayDiscount(VisitDate date, OrderMenus menus) {
        this.weekdayDiscount = calculateWeekdayDiscount(date, menus);
    }

    private int calculateWeekdayDiscount(VisitDate date, OrderMenus menus) {
        boolean weekday = whetherWeekday(date);
        if (weekday) {
            return calculateDiscount(menus);
        }
        return ZERO;
    }

    private boolean whetherWeekday(VisitDate date) {
        int visitDate = date.getVisitDate();
        return visitDate % WEEK_INTERVAL != FRIDAY && visitDate % WEEK_INTERVAL != SATURDAY;
    }

    private int calculateDiscount(OrderMenus menus) {
        return DISCOUNT_PER_DESSERT*calDessertNumMenus(menus);
    }

    private int calDessertNumMenus(OrderMenus menus) {
        int dessertNumber = 0;
        for (List<String> menu : menus.getOrderMenus()) {
            if (stringToEnumMenu(menu.get(0)).getType().equals("디저트")) {
                dessertNumber += Integer.parseInt(menu.get(1));
            }
        }
        return dessertNumber;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }
}
