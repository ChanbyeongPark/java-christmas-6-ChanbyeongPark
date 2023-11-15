package christmas.domain;

import java.util.List;

import static christmas.domain.Menu.stringToEnumMenu;

public class WeekendDiscount {
    private static final int WEEK_INTERVAL = 7;
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    private static final int DISCOUNT_PER_MAIN = 2023;
    private static final int ZERO = 0;
    private final int weekendDiscount;

    public WeekendDiscount(VisitDate date, OrderMenus menus) {
        this.weekendDiscount = calculateWeekendDiscount(date, menus);
    }

    private int calculateWeekendDiscount(VisitDate date, OrderMenus menus) {
        boolean weekend = whetherWeekend(date);
        if (weekend) {
            return calculateDiscount(menus);
        }
        return ZERO;
    }

    private boolean whetherWeekend(VisitDate date) {
        int visitDate = date.getVisitDate();
        return visitDate % WEEK_INTERVAL == FRIDAY || visitDate % WEEK_INTERVAL == SATURDAY;
    }

    private int calculateDiscount(OrderMenus menus) {
        return DISCOUNT_PER_MAIN*calMainNumMenus(menus);
    }

    private int calMainNumMenus(OrderMenus menus) {
        int mainNumber = 0;
        for (List<String> menu : menus.getOrderMenus()) {
            if (stringToEnumMenu(menu.get(0)).getType().equals("메인")) {
                mainNumber += Integer.parseInt(menu.get(1));
            }
        }
        return mainNumber;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }
}
