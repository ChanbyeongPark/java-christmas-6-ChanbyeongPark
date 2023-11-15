package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;


public class VisitDateTest {
    @Test
    @DisplayName("1~31을 벗어난 숫자 입력이 들어오면 예외가 발생한다.")
    void test() {
        assertThatThrownBy(() -> new VisitDate(32))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
