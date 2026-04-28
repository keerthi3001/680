package cs680.hw12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        // Correct constructor usage:
        // Car(String make, String model, int year, int mileage, double price)
        cars.add(new Car("Toyota", "Camry", 2010, 20000, 30000.0));
        cars.add(new Car("Honda", "Civic", 2015, 18000, 25000.0));
        cars.add(new Car("Ford", "Focus", 2012, 22000, 22000.0));
        cars.add(new Car("BMW", "X3", 2018, 35000, 45000.0));
        cars.add(new Car("Tesla", "Model 3", 2020, 15000, 48000.0));

        // 1) Sort by price ascending (price is double)
        System.out.println("Sort by price ascending:");
        cars.sort(Comparator.comparingDouble(Car::getPrice));
        cars.forEach(System.out::println);

        System.out.println();

        // 2) Sort by year ascending
        System.out.println("Sort by year ascending:");
        cars.sort(Comparator.comparingInt(Car::getYear));
        cars.forEach(System.out::println);

        System.out.println();

        // 3) Sort by mileage ascending
        System.out.println("Sort by mileage ascending:");
        cars.sort(Comparator.comparingInt(Car::getMileage));
        cars.forEach(System.out::println);

        System.out.println();

        // 4) Sort by price, then mileage
        System.out.println("Sort by price then mileage:");
        cars.sort(
            Comparator.comparingDouble(Car::getPrice)
                      .thenComparingInt(Car::getMileage)
        );
        cars.forEach(System.out::println);
    }
}
