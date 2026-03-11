package hw1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimeGeneratorTest {

    @Test
    public void oneToTwenty() {
        PrimeGenerator g = new PrimeGenerator(1, 20);
        g.generatePrimes();
        assertIterableEquals(
            Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L),
            g.getPrimes()
        );
    }

    @Test
    public void twentyToForty() {
        PrimeGenerator g = new PrimeGenerator(20, 40);
        g.generatePrimes();
        assertIterableEquals(
            Arrays.asList(23L, 29L, 31L, 37L),
            g.getPrimes()
        );
    }

    @Test
    public void negativeLower() {
        assertThrows(IllegalArgumentException.class, () -> new PrimeGenerator(-5, 10));
    }

    @Test
    public void reversedBounds() {
        assertThrows(IllegalArgumentException.class, () -> new PrimeGenerator(100, 50));
    }

    @Test
    public void zeroUpper() {
        assertThrows(IllegalArgumentException.class, () -> new PrimeGenerator(1, 0));
    }
}
