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

    //Default bir şey vermedim
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
    public void addCar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the licanse plate: ");
        String licansePlate=scanner.nextLine();
        while(doesCarExists(licansePlate))
        {
        	System.out.println("Already exists");
        	System.out.print("Enter the licanse plate: ");
            licansePlate=scanner.nextLine();
        }

        System.out.print("Enter car type (electric/combustion): ");
        String type = scanner.nextLine().toLowerCase();
        while(!(type.equalsIgnoreCase("combustion")) || !(type.equalsIgnoreCase("electric")))
        {
        	System.out.print("Enter car type (electric/combustion): ");
            type = scanner.nextLine().toLowerCase();
        }
        
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter horsepower: ");
        int horsepower = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter color: ");
        scanner.nextLine();
        String color = scanner.nextLine();

        System.out.print("Enter mileage: ");
        double mileage = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Enter the car's top speed (in km/h): ");
        double topSpeed = Double.parseDouble(scanner.nextLine());

        ElectricCar eCar=null;
        CombustionCar cCar=null;

        if (type.equals("electric")) {
        	System.out.print("Enter current battery percentage: ");
        	double batteryPercentage = Double.parseDouble(scanner.nextLine());

        	System.out.print("Enter miles per 100% battery: ");
        	double milePerBattery = Double.parseDouble(scanner.nextLine());

        	System.out.print("Does the car support fast charging? (true/false): ");
        	boolean fastCharge = Boolean.parseBoolean(scanner.nextLine());

        	System.out.print("Enter battery charge time to 100% (in hours): ");
        	double batteryChargeTime = Double.parseDouble(scanner.nextLine());

            eCar = new ElectricCar(brand, horsepower, year, color, mileage, licansePlate, topSpeed, batteryPercentage, milePerBattery, fastCharge, batteryChargeTime);
            cars.add(eCar);
            System.out.println("Car added successfully!");
        } else if (type.equals("combustion")) {
        	System.out.print("Enter maximum fuel capacity (in liters): ");
        	double tankCap = Double.parseDouble(scanner.nextLine());

        	System.out.print("Enter current fuel in tank (in liters): ");
        	double fuelInTank = Double.parseDouble(scanner.nextLine());

        	System.out.print("Enter type of fuel (e.g., Gasoline, Diesel): ");
        	String fuelType = scanner.nextLine();

        	System.out.print("Enter miles per full tank: ");
        	double milePerTank = Double.parseDouble(scanner.nextLine());

            cCar = new CombustionCar(brand, horsepower, year, color, mileage, licansePlate, topSpeed, tankCap, fuelInTank, fuelType, milePerTank);
            cars.add(cCar);
            System.out.println("Car added successfully!");
        } else {
            System.out.println("Invalid car type. No car added.");
        }
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
    
    
    
	

   
}