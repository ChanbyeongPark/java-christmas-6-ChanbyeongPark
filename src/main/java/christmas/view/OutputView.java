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
    private static final String FREE_GIFT_TITLE = "<증정 메뉴>";
    private static final String DISCOUNT_TITLE = "<혜택 내역>";
    private static final String NUMBER_MENU_UNIT = "개";
    private static final String PRICE_UNIT = "원";
    private static final String FREE_GIFT_MENU = "샴페인";
    private static final String BLANK = " ";
    private static final String FREE_GIFT_NUMBER = "1";
    private static final String NOTHING = "없음";
    private static final String D_DAY_DISCOUNT = "크리스마스 디데이 할인: -%s원";
    private static final String WEEKDAY_DISCOUNT = "평일 할인: -%s원";
    private static final String WEEKEND_DISCOUNT = "주말 할인: -%s원";
    private static final String SPECIAL_DISCOUNT = "특별 할인: -%s원";
    private static final String FREE_GIFT_DISCOUNT = "증정 이벤트: -%s원";

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

    public static void printFreeGift(boolean freeGift) {
        System.out.println(FREE_GIFT_TITLE);
        System.out.println(getFreeGift(freeGift));
        System.out.println();
    }

    private static String getFreeGift(boolean freeGift) {
        if (freeGift) {
            return FREE_GIFT_MENU+BLANK+FREE_GIFT_NUMBER+NUMBER_MENU_UNIT;
        }
        return NOTHING;
    }

    public static void printDiscountStart() {
        System.out.println(DISCOUNT_TITLE);
    }

    public static void printDDayDiscount(int discount) {
        System.out.println(String.format(D_DAY_DISCOUNT, numberFormat.format(discount)));
    }

    public static void printWeekdayDiscount(int discount) {
        System.out.println(String.format(WEEKDAY_DISCOUNT, numberFormat.format(discount)));
    }

    public static void printWeekendDiscount(int discount) {
        System.out.println(String.format(WEEKEND_DISCOUNT, numberFormat.format(discount)));
    }

    public static void printSpecialDiscount(int discount) {
        System.out.println(String.format(SPECIAL_DISCOUNT, numberFormat.format(discount)));
    }

    public static void printFreeGiftDiscount(int discount) {
        System.out.println(String.format(FREE_GIFT_DISCOUNT, numberFormat.format(discount)));
    }

    public static void printNothing() {
        System.out.println(NOTHING);
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
