package Has_A_Class;
import java.util.ArrayList;
import java.util.Scanner;

import Is_A_Classes.Car;
import Is_A_Classes.CombustionCar;
import Is_A_Classes.ElectricCar;

public class CarGallery {
    private ArrayList<Car> cars;
    private String address;
    private int id;
    private String title;

    
    public CarGallery() {
        this.cars = new ArrayList<>();
        this.address = "";
        this.id = 0;
        this.title = "";
    }

    public CarGallery(String address, int id, String title) {
        this.cars = new ArrayList<>();
        this.address = address;
        this.id = id;
        this.title = title;
    }
    public boolean addCar(String type, String brand, double horsePower, int year, String color, double mileage, 
    		String licensePlate, double topSpeed,double batteryPercentage, double milePerBattery, boolean fastCharge,
    		double batteryChargeTime, double tankCap, double fuelInTank, String fuelType, double milePerTank) {
        Car carObj = findCar(licensePlate);
        if(carObj==null) {
        	if(type.equalsIgnoreCase("electric")) {
            	carObj = new ElectricCar(brand, horsePower, year, color, mileage, licensePlate, topSpeed, batteryPercentage, milePerBattery, fastCharge, batteryChargeTime);
            }else {
            	carObj = new CombustionCar(brand, horsePower, year, color, mileage, licensePlate, topSpeed, tankCap, fuelInTank, fuelType, milePerTank);
            }
            cars.add(carObj);
            return true;
        }
        return false;
    }
    
    
    
    @Override
	public String toString() {
		return "CarGallery [address=" + address + ", id=" + id + ", title=" + title + "]";
	}

	public boolean doesCarExists(String licanseplate) {
    	for(int i=0;i<=cars.size();i++)
    		if(cars.get(i).getLicensePlate().equalsIgnoreCase(licanseplate))
    			return true;
    	return false;
    }
    
    public String displayCars()
    {
    	String output="";
    	for(int i=0;i<cars.size();i++)
    	{
    		output+=cars.get(i).toString();
    		output+="\n";
    	}
    	return output;
    }
    
    
    
    public Car removeCar(String licanseplate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equalsIgnoreCase(licanseplate)) {
                cars.remove(car);
                return car;
            }
        }
        return null;
    }
    public Car findCar(String licanseplate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equalsIgnoreCase(licanseplate)) {
                return car;
            }
        }
        return null; // Return null if no car is found with the given title
    }

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
	public String[] getAllCarsPlate() {
		String[] arr = new String[cars.size()];
		int i =0;
		for (Car car : cars) {
			arr[i] = car.getLicensePlate();
			i++;
		}
		return arr;
	}
    
    
	

   
}