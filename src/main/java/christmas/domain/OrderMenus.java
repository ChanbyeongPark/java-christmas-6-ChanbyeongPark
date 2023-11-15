package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import static christmas.domain.Menu.stringToEnumMenu;

public class OrderMenus {
    private static final String MENUS_DELIMITER = ",";
    private static final String MENU_DELIMITER = "-";
    private static final int MIN_NUMBER_MENU = 1;
    private static final int MAX_TOTAL_NUMBER_MENUS = 20;
    private static final String DUPLICATE_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String MAX_TOTAL_NUMBER_ERROR = "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";
    private static final String ONLY_BEVERAGE_ERROR = "[ERROR] 음료만 주문 시, 주문할 수 없습니다.";
    private static final String FORMAT_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String NOT_EXIST_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private static final String NUMBER_MENU_TYPE_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String MIN_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final List<List<String>> orderMenus;

    public OrderMenus(String menus) {
        this.orderMenus = separateMenus(menus);
    }

    private List<List<String>> separateMenus(String menus) {
        List<List<String>> candidateMenus = new ArrayList<>();
        String[] splitMenus = menus.split(MENUS_DELIMITER);
        for (String menu : splitMenus) {
            candidateMenus.add(separateMenu(menu));
        }
        validateMenus(candidateMenus);
        return candidateMenus;
    }

    private List<String> separateMenu(String menu) {
        String[] splitMenu = menu.split(MENU_DELIMITER);
        validateMenu(splitMenu);
        return new ArrayList<>(Arrays.asList(splitMenu));
    }

    private void validateMenus(List<List<String>> menus) {
        validateNotDuplicateMenus(menus);
        validateMaxTotalNumMenus(menus);
        validateNotOnlyBeverageMenus(menus);
    }

    private void validateNotDuplicateMenus(List<List<String>> menus) {
        if (menus.size() != getDistinguishNumMenus(menus)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private int getDistinguishNumMenus(List<List<String>> menus) {
        Set<String> nameMenus = new HashSet<>();
        for (List<String> menu : menus) {
            nameMenus.add(menu.get(0));
        }
        return nameMenus.size();
    }

    private void validateMaxTotalNumMenus(List<List<String>> menus) {
        if (getTotalNumMenus(menus) > MAX_TOTAL_NUMBER_MENUS) {
            throw new IllegalArgumentException(MAX_TOTAL_NUMBER_ERROR);
        }
    }

    private int getTotalNumMenus(List<List<String>> menus) {
        int totalNumber = 0;
        for (List<String> menu : menus) {
            totalNumber += Integer.parseInt(menu.get(1));
        }
        return totalNumber;
    }

    private void validateNotOnlyBeverageMenus(List<List<String>> menus) {
        if (menus.size() == getBeverageNumMenus(menus)) {
            throw new IllegalArgumentException(ONLY_BEVERAGE_ERROR);
        }
    }

    private int getBeverageNumMenus(List<List<String>> menus) {
        int beverageNumber = 0;
        for (List<String> menu : menus) {
            if (stringToEnumMenu(menu.get(0)).getType().equals("음료")) {
                beverageNumber += 1;
            }
        }
        return beverageNumber;
    }

    private void validateMenu(String[] menu) {
        validateSizeMenu(menu);
        validateExistMenu(menu[0]);
        validateNumberMenu(menu[1]);
    }

    private void validateSizeMenu(String[] menu) {
        if (menu.length != 2) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        }
    }

    private void validateExistMenu(String nameMenu) {
        if (Arrays.stream(Menu.values()).noneMatch(v -> v.name().equals(nameMenu))) {
            throw new IllegalArgumentException(NOT_EXIST_ERROR);
        }
    }

    private void validateNumberMenu(String numberMenu) {
        validateMinNumberMenu(convertToInt(numberMenu));
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_MENU_TYPE_ERROR);
        }
    }

    private void validateMinNumberMenu(int numberMenu) {
        if (numberMenu < MIN_NUMBER_MENU) {
            throw new IllegalArgumentException(MIN_ERROR);
        }
    }

    public List<List<String>> getOrderMenus() {
        return orderMenus;
    }
}
