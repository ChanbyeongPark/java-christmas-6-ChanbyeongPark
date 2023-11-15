package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_ORDER_MENUS = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String DATE_TYPE_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static int inputDate() {
        System.out.println(INPUT_VISIT_DATE);
        return convertToInt(Console.readLine());
    }

    public static String inputMenus() {
        System.out.println(INPUT_ORDER_MENUS);
        return Console.readLine();
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATE_TYPE_ERROR);
        }
    }
}
