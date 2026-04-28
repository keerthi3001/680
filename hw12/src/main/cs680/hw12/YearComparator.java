package cs680.hw12;

import java.util.Comparator;

/** Sorts cars by year ascending (older -> newer). */
public class YearComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        if (c1 == null || c2 == null) throw new NullPointerException("car is null");
        return Integer.compare(c1.getYear(), c2.getYear());
    }
}

