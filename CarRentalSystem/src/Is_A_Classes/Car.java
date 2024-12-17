package Is_A_Classes;

import Interface.CarInterface;

public abstract class Car implements CarInterface{

    protected static int numberOfCars = 0;
    protected String brand;
    protected double horsePower;
    protected int year;
    protected String color;
    protected double mileage;
    protected String licensePlate;
    protected double topSpeed;

    public Car() {
        this.brand = "Unknown";
        this.horsePower = 0.0;
        this.year = 0;
        this.color = "Unknown";
        this.mileage = 0.0;
        this.licensePlate = "Unknown";
        this.topSpeed = 0.0;
        numberOfCars++;
    }


    public Car(String brand, double horsePower, int year, String color, double mileage, String licensePlate, double topSpeed) {
        this.brand = brand;
        this.horsePower = horsePower;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.licensePlate = licensePlate;
        this.topSpeed = topSpeed;
        numberOfCars++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }


    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public abstract double calculateMilage(); //arabayi aldiktan hemen sonra ne kadar gider


	@Override
	public String toString() {
		return "Brand: " + brand + "\n" +
                "Horse Power: " + horsePower + "\n" +
                "Year: " + year + "\n" +
                "Color: " + color + "\n" +
                "Mileage: " + mileage + "\n" +
                "License Plate: " + licensePlate + "\n" +
                "Top Speed: " + topSpeed ;
	}
    
    
    
    


}