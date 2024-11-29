package jzel;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

import com.jzel.Fibonacci;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciTest {

    private final Fibonacci calculator = new Fibonacci();

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "10, 55"})
    void testCalculate_withValidInput(final int input, final int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @Test
    void testCalculate_withNegativeInput() {
        assertThatThrownBy(() -> calculator.calculate(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("non-negative");
    }
}
