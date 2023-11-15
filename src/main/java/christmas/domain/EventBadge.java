package christmas.domain;

public class EventBadge {
    private static final int MIN_FIRST_BADGE = 5000;
    private static final int MIN_SECOND_BADGE = 10000;
    private static final int MIN_THIRD_BADGE = 20000;
    private static final String FIRST_BADGE = "별";
    private static final String SECOND_BADGE = "트리";
    private static final String THIRD_BADGE = "산타";
    private static final String NOTHING = "없음";
    private final String eventBadge;

    public EventBadge(TotalDiscount totalDiscount) {
        this.eventBadge = calculateEventBadge(totalDiscount);
    }

    private String calculateEventBadge(TotalDiscount totalDiscount) {
        int discount = totalDiscount.getTotalDiscount();
        if (discount >= MIN_THIRD_BADGE) {
            return THIRD_BADGE;
        }
        if (discount >= MIN_SECOND_BADGE) {
            return SECOND_BADGE;
        }
        if (discount >= MIN_FIRST_BADGE) {
            return FIRST_BADGE;
        }
        return NOTHING;
    }

    public String getEventBadge() {
        return eventBadge;
    }

}
