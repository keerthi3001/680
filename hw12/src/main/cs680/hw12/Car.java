package cs680.hw12;

public class Car {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private double price;

    public Car(String make, String model, int year, int mileage, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return make + " " + model + " (" + year + "), " +
               mileage + " miles, $" + price;
    }
}
