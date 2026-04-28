package cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarTest {

    // Same sign behavior as Integer.compare
    private int expectedSignByInt(int a, int b) {
        return Integer.compare(a, b);
    }

    // Reusable helper: comparator should match getter's ordering
    private void assertComparatorMatchesGetterOrder(
            Comparator<Car> comp, Car c1, Car c2, int v1, int v2) {
        assertEquals(expectedSignByInt(v1, v2), comp.compare(c1, c2));
    }

    @Test
    public void yearComparatorMatchesYearGetter() {
        Car c1 = new Car("Toyota", 2010, 30, 20000);
        Car c2 = new Car("Honda", 2015, 35, 18000);

        Comparator<Car> comp = new YearComparator();
        // newer first (descending by year)
        assertEquals(expectedSignByInt(c2.getYear(), c1.getYear()), comp.compare(c1, c2));
    }

    @Test
    public void priceComparatorMatchesPriceGetter() {
        Car c1 = new Car("Toyota", 2010, 30, 20000);
        Car c2 = new Car("Honda", 2015, 35, 18000);

        Comparator<Car> comp = new PriceComparator();
        assertComparatorMatchesGetterOrder(comp, c1, c2, c1.getPrice(), c2.getPrice());
    }

    @Test
    public void mileageComparatorMatchesMileageGetter() {
        Car c1 = new Car("Toyota", 2010, 30, 20000);
        Car c2 = new Car("Honda", 2015, 35, 18000);

        Comparator<Car> comp = new MileageComparator();
        assertComparatorMatchesGetterOrder(comp, c1, c2, c1.getMileage(), c2.getMileage());
    }

    @Test
    public void paretoComparatorEqualObjectsReturnZero() {
        Car c1 = new Car("Toyota", 2010, 30, 20000);
        Car c2 = new Car("Toyota", 2010, 30, 20000);

        Comparator<Car> comp = new ParetoComparator();
        c1.setDominationCount(0);
        c2.setDominationCount(0);
        assertEquals(0, comp.compare(c1, c2));
    }

    @Test
    public void paretoComparatorDominatesWhenAllNonWorseAndOneStrictBetter() {
        // Per note17: ParetoComparator compares domination counts (lower is better).
        Car better = new Car("A", 2018, 30, 18000);
        Car worse  = new Car("B", 2016, 35, 20000);

        better.setDominationCount(0);
        worse.setDominationCount(1);

        Comparator<Car> comp = new ParetoComparator();
        assertEquals(-1, comp.compare(better, worse)); // better has lower domination count => "smaller"
    }

    @Test
    public void paretoComparatorTradeoffReturnsZero() {
        Car c1 = new Car("A", 2018, 30, 22000);
        Car c2 = new Car("B", 2020, 35, 18000);

        // If domination counts are equal, comparator returns 0.
        c1.setDominationCount(2);
        c2.setDominationCount(2);

        Comparator<Car> comp = new ParetoComparator();
        assertEquals(0, comp.compare(c1, c2));
    }

    private static boolean dominates(Car a, Car b) {
        // better directions from note17:
        // lower mileage, higher year, lower price
        boolean noWorse =
                a.getMileage() <= b.getMileage()
                        && a.getYear() >= b.getYear()
                        && a.getPrice() <= b.getPrice();
        boolean strictBetter =
                a.getMileage() < b.getMileage()
                        || a.getYear() > b.getYear()
                        || a.getPrice() < b.getPrice();
        return noWorse && strictBetter;
    }

    private static void computeDominationCounts(List<Car> cars) {
        for (Car c : cars) c.setDominationCount(0);
        for (Car target : cars) {
            int count = 0;
            for (Car other : cars) {
                if (other != target && dominates(other, target)) count++;
            }
            target.setDominationCount(count);
        }
    }

    @Test
    public void paretoSortOrdersByDominationCountAscending() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A", 2018, 30, 18000)); // strong
        cars.add(new Car("B", 2016, 35, 20000)); // weak
        cars.add(new Car("C", 2017, 40, 15000)); // tradeoff

        computeDominationCounts(cars);
        cars.sort(new ParetoComparator());

        // Sorted by dominationCount ascending (ties allowed).
        assertTrue(cars.get(0).getDominationCount() <= cars.get(1).getDominationCount());
        assertTrue(cars.get(1).getDominationCount() <= cars.get(2).getDominationCount());
    }
}
