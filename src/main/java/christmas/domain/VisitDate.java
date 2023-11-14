package christmas.domain;

public class VisitDate {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final String MIN_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String MAX_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private final int date;
    public VisitDate(int date) {
        validateDate(date);
        this.date = date;
    }

    private void validateDate(int date) {
        validateMinDate(date);
        validateMaxDate(date);
    }

    private void validateMinDate(int date) {
        if (date < MIN_DATE) {
            throw new IllegalArgumentException(MIN_ERROR);
        }
    }

    private void validateMaxDate(int date) {
        if (date > MAX_DATE) {
            throw new IllegalArgumentException(MAX_ERROR);
        }
    }
}
