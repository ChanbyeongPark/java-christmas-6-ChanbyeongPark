package christmas.domain;

import java.util.List;

import static christmas.domain.Menu.stringToEnumMenu;

public class FreeGift {
    private static final int FREE_GIFT_CRITERION = 120000;
    private final boolean freeGift;

    public FreeGift(TotalPriceBeforeDiscount totalPriceBeforeDiscount) {
        this.freeGift = whetherFreeGift(totalPriceBeforeDiscount);
    }

    private boolean whetherFreeGift(TotalPriceBeforeDiscount totalPriceBeforeDiscount) {
        return totalPriceBeforeDiscount.getTotalPriceBeforeDiscount() >= FREE_GIFT_CRITERION;
    }

    public boolean getFreeGift() {
        return freeGift;
    }
}
