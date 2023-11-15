package christmas.domain;

public class DDayDiscount {
    private static final int MAX_DATE = 25;
    private static final int MIN_DISCOUNT = 900;
    private static final int DISCOUNT_PER_DAY = 100;
    private static final int ZERO = 0;
    private final int dDayDiscount;

    public DDayDiscount(VisitDate visitDate) {
        this.dDayDiscount = calculateDDayDiscount(visitDate);
    }

    private int calculateDDayDiscount(VisitDate visitDate) {
        int date = visitDate.getVisitDate();
        if (date <= MAX_DATE) {
            return MIN_DISCOUNT + date * DISCOUNT_PER_DAY;
        }
        return ZERO;
    }

    public int getDDayDiscount() {
        return dDayDiscount;
    }
}
