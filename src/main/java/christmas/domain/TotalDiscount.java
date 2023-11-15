package christmas.domain;

public class TotalDiscount {
    private static final int ZERO = 0;
    private final int totalDiscount;

    public TotalDiscount(DDayDiscount dDayDiscount, WeekdayDiscount weekdayDiscount,
                         WeekendDiscount weekendDiscount, SpecialDiscount specialDiscount,
                         FreeGiftDiscount freeGiftDiscount, boolean flag) {
        this.totalDiscount = calculateTotalDiscount(dDayDiscount, weekdayDiscount, weekendDiscount,
                specialDiscount, freeGiftDiscount, flag);
    }

    private int calculateTotalDiscount(DDayDiscount dDayDiscount, WeekdayDiscount weekdayDiscount,
                                       WeekendDiscount weekendDiscount, SpecialDiscount specialDiscount,
                                       FreeGiftDiscount freeGiftDiscount, boolean flag) {
        int totalDiscount = ZERO;
        if (flag) {
            totalDiscount += dDayDiscount.getDDayDiscount();
            totalDiscount += weekdayDiscount.getWeekdayDiscount();
            totalDiscount += weekendDiscount.getWeekendDiscount();
            totalDiscount += specialDiscount.getSpecialDiscount();
            totalDiscount += freeGiftDiscount.getFreeGiftDiscount();
        }
        return totalDiscount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }
}
