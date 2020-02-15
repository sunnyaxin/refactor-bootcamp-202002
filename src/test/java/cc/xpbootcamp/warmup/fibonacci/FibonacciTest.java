package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibonacciTest {

    Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    void should_return_1_when_calculate_give_position_is_1() {
        assertThat(1, is(fibonacci.calculate(1)));
    }

    @Test
    void should_return_2_when_calculate_give_position_is_3() {
        assertThat(2, is(fibonacci.calculate(3)));
    }
}
