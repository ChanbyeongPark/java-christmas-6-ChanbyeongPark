package christmas.domain;

public class FreeGiftDiscount {
    private static final int FREE_GIFT_PRICE = 25000;
    private static final int ZERO = 0;

    private final int freeGiftDiscount;

    public FreeGiftDiscount(FreeGift freeGift) {
        this.freeGiftDiscount = calculateFreeGiftDiscount(freeGift);
    }

    private int calculateFreeGiftDiscount(FreeGift freeGift) {
        if (freeGift.getFreeGift()) {
            return FREE_GIFT_PRICE;
        }
        return ZERO;
    }

    public int getFreeGiftDiscount() {
        return freeGiftDiscount;
    }
}
