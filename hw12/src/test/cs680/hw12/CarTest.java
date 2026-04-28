package cs680.hw12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Corolla", 2018, 45000, 14000.0));
        cars.add(new Car("Honda", "Civic",   2020, 30000, 19000.0));
        cars.add(new Car("Tesla", "Model 3", 2022, 15000, 35000.0));
        cars.add(new Car("Ford",  "Focus",   2016, 60000, 10000.0));
    }

    @Test
    public void testSortByPriceAscending() {
        cars.sort((c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()));

        assertEquals("Ford",   cars.get(0).getMake());   // 10000
        assertEquals("Toyota", cars.get(1).getMake());   // 14000
        assertEquals("Honda",  cars.get(2).getMake());   // 19000
        assertEquals("Tesla",  cars.get(3).getMake());   // 35000
    }

    @Test
    public void testSortByYearAscending() {
        cars.sort(new YearComparator());

        assertEquals(2016, cars.get(0).getYear());
        assertEquals(2018, cars.get(1).getYear());
        assertEquals(2020, cars.get(2).getYear());
        assertEquals(2022, cars.get(3).getYear());
    }

    @Test
    public void testSortByMileageAscending() {
        cars.sort(Comparator.comparing(Car::getMileage));

        assertEquals(15000, cars.get(0).getMileage());
        assertEquals(30000, cars.get(1).getMileage());
        assertEquals(45000, cars.get(2).getMileage());
        assertEquals(60000, cars.get(3).getMileage());
    }

    @Test
    public void testSortByModelAlphabetical() {
        cars.sort((c1, c2) -> c1.getModel().compareToIgnoreCase(c2.getModel()));

        assertEquals("Civic",   cars.get(0).getModel());
        assertEquals("Corolla", cars.get(1).getModel());
        assertEquals("Focus",   cars.get(2).getModel());
        assertEquals("Model 3", cars.get(3).getModel());
    }

    @Test
    public void testParetoComparatorDetectsDominance() {
        Car better = new Car("A", "A1", 2022, 15000, 18000.0);
        Car worse  = new Car("B", "B1", 2020, 30000, 20000.0);

        ParetoComparator comp = new ParetoComparator();
        assertTrue(comp.compare(better, worse) > 0);
        assertTrue(comp.compare(worse, better) < 0);
        assertEquals(0, comp.compare(better, better));
    }
}
