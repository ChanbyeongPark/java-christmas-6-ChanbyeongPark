package christmas.view;

import christmas.domain.VisitDate;
import christmas.domain.OrderMenus;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    private static final String EVENT_PLANNER_START = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String RESULT_START = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String RESULT_MENUS_TITLE = "<주문 메뉴>";
    private static final String TOTAL_PRICE_BEFORE_DISCOUNT_TITLE = "<할인 전 총주문 금액>";
    private static final String NUMBER_MENU_UNIT = "개";
    private static final String PRICE_UNIT = "원";

    static NumberFormat numberFormat = NumberFormat.getInstance();

    public static void printPlannerStart() {
        System.out.println(EVENT_PLANNER_START);
    }

    public static void printResultStart(VisitDate date) {
        System.out.println(String.format(RESULT_START, date.getVisitDate()));
        System.out.println();
    }
    public static void printMenus(OrderMenus menus) {
        System.out.println(RESULT_MENUS_TITLE);
        for (List<String> menu : menus.getOrderMenus()) {
            System.out.println(String.format("%s %s"+NUMBER_MENU_UNIT, menu.get(0), menu.get(1)));
        }
        System.out.println();
    }

    public static void printTotalPriceBeforeDiscount(int price) {
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT_TITLE);
        System.out.println(numberFormat.format(price)+PRICE_UNIT);
        System.out.println();
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
