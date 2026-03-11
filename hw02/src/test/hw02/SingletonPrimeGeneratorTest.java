package hw02;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SingletonPrimeGeneratorTest {

    @Test
    void singletonIdentity_sameInstance() {
        SingletonPrimeGenerator g1 = SingletonPrimeGenerator.getInstance();
        SingletonPrimeGenerator g2 = SingletonPrimeGenerator.getInstance();
        assertSame(g1, g2, "getInstance() must always return the same object");
    }

    @Test
    void primes_1_to_10_are_2357() {
        SingletonPrimeGenerator g = SingletonPrimeGenerator.getInstance();
        g.setRange(1, 10);
        g.generatePrimes();
        assertIterableEquals(Arrays.asList(2L, 3L, 5L, 7L), g.getPrimes());
    }

    @Test
    void single_point_2_returns_2() {
        SingletonPrimeGenerator g = SingletonPrimeGenerator.getInstance();
        g.setRange(2, 2);
        g.generatePrimes();
        assertIterableEquals(Arrays.asList(2L), g.getPrimes());
    }

    @Test
    void no_primes_in_14_to_16_returns_empty() {
        SingletonPrimeGenerator g = SingletonPrimeGenerator.getInstance();
        g.setRange(14, 16);
        g.generatePrimes();
        assertTrue(g.getPrimes().isEmpty());
    }

    @Test
    void invalid_negative_range_throws() {
        SingletonPrimeGenerator g = SingletonPrimeGenerator.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            g.setRange(-5, 5);
            g.generatePrimes();
        });
    }

    @Test
    void from_greater_than_to_throws() {
        SingletonPrimeGenerator g = SingletonPrimeGenerator.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            g.setRange(100, 1);
            g.generatePrimes();
        });
    }
}
