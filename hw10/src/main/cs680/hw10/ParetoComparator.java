package cs680.hw10;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        if (c1 == null || c2 == null) throw new NullPointerException("car is null");
        // Per note17: order cars by domination count (lower is better).
        // Domination counts must be computed before sorting.
        return Integer.compare(c1.getDominationCount(), c2.getDominationCount());
    }
}
