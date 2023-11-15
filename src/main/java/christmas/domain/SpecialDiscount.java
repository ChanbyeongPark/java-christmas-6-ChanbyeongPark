package christmas.domain;

public class SpecialDiscount {
    private static final int WEEK_INTERVAL = 7;
    private static final int SUNDAY = 3;
    private static final int CHRISTMAS = 25;
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final int ZERO = 0;
    private final int specialDiscount;

    public SpecialDiscount(VisitDate date) {
        this.specialDiscount = calculateSpecialDiscount(date);
    }

    private int calculateSpecialDiscount(VisitDate date) {
        boolean sunday = whetherSunday(date);
        boolean christmas = whetherChristmas(date);
        if (sunday || christmas)  {
            return SPECIAL_DISCOUNT;
        }
        return ZERO;
    }

    private boolean whetherSunday(VisitDate date) {
        return date.getVisitDate() % WEEK_INTERVAL == SUNDAY;
    }

    private boolean whetherChristmas(VisitDate date) {
        return date.getVisitDate() == CHRISTMAS;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }
}
