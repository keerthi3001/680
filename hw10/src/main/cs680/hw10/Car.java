package cs680.hw10;

public class Car {

    private final String make;
    private final int year;
    private final int mileage; // in miles
    private final int price;   // in dollars
    private int dominationCount = 0;

    public Car(String make, int year, int mileage, int price) {
        if (make == null) {
            throw new NullPointerException("make is null");
        }
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    public int getDominationCount() { return dominationCount; }

    public void setDominationCount(int dominationCount) {
        if (dominationCount < 0) throw new IllegalArgumentException("dominationCount must be >= 0");
        this.dominationCount = dominationCount;
    }

    @Override
    public String toString() {
        return make + " (" + year + ", " + mileage + " miles, $" + price + ")";
    }
}
