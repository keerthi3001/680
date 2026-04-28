package cs680.hw10;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        if (c1 == null || c2 == null) throw new NullPointerException("car is null");
        // newer cars first (descending by year)
        return Integer.compare(c2.getYear(), c1.getYear());
    }
}
