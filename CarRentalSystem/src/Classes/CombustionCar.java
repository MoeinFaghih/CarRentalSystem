package Classes;
public class CombustionCar extends Car  {
	private double tankCap;       // max fuel capacity
	private double fuelInTank;    // current fuel in tank
	private String fuelType;      // Type of fuel Gasoline, Diesel
	private double milePerTank;   // full tank = how much mile
	

	public CombustionCar() {
		super();
	}


	public CombustionCar(String brand, double horsePower, int year, String color, double mileage, String licensePlate, double topSpeed,double tankCap, double fuelInTank, String fuelType, double milePerTank) {
		super(brand, horsePower, year, color, mileage, licensePlate, topSpeed);
		this.tankCap = tankCap;
		this.fuelInTank = fuelInTank;
		this.fuelType = fuelType;
		this.milePerTank = milePerTank;
	}
	
	public double getTankCap() {
		return tankCap;
	}

	public double getFuelInTank() {
		return fuelInTank;
	}


	public void setFuelInTank(double fuelInTank) {
		this.fuelInTank = fuelInTank;
	}


	public String getFuelType() {
		return fuelType;
	}

	public double getMilePerTank() {
		return milePerTank;
	}


	public String toString() {
	    return "Combustion Car Details\n" +
                super.toString() + "\n"+
	           "  Tank Capacity: " + tankCap + " liters\n" +
	           "  Fuel in Tank: " + fuelInTank + " liters\n" +
	           "  Fuel Type: " + fuelType + "\n" +
	           "  Miles Per Tank: " + milePerTank + " miles\n";
	}


	public double costToFill() {
		if(fuelType.equalsIgnoreCase("Diesel"))
			return (tankCap-fuelInTank)*44.76;
		if(fuelType.equalsIgnoreCase("Gasoline"))
			return (tankCap-fuelInTank)*43.5;
		else
			return 0;
	}
	
	public double calculateMilage() {
		if(fuelType.equalsIgnoreCase("Diesel"))
			return (tankCap-fuelInTank)*22.22;
		if(fuelType.equalsIgnoreCase("Gasoline"))
			return (tankCap-fuelInTank)*14.7;
		else
			return 0;
	}

}