package christmas.domain;

import java.util.List;

import static christmas.domain.Menu.stringToEnumMenu;

public class TotalPriceBeforeDiscount {
    private final int price;

    public TotalPriceBeforeDiscount(List<List<String>> menus) {
        this.price = getTotalPrice(menus);
    }

    private int getTotalPrice(List<List<String>> menus) {
        int totalPrice = 0;
        for (List<String> menu : menus) {
            totalPrice += stringToEnumMenu(menu.get(0)).getPrice() * Integer.parseInt(menu.get(1));
        }
        return totalPrice;
    }

    public int getTotalPriceBeforeDiscount() {
        return price;
    }
}
