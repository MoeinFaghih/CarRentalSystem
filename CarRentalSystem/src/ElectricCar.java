public class ElectricCar extends Car{
    private double batteryPercentage; //current battery cap
    private double milePerBattery; // 100% = how much mile
    private boolean fastCharge; //does supports fast charging
    private double batteryChargeTime; // batteryPercantage to 100 charge time
	
    public ElectricCar() {
		super();
	}
    
    public ElectricCar(String brand, double horsePower, int year, String color, double mileage, String licensePlate, double topSpeed,double batteryPercentage, double milePerBattery, boolean fastCharge,double batteryChargeTime) {
		super(brand, horsePower, year, color, mileage, licensePlate, topSpeed);
		this.batteryPercentage = batteryPercentage;
		this.milePerBattery = milePerBattery;
		this.fastCharge = fastCharge;
		this.batteryChargeTime = batteryChargeTime;
	}


	public double getBatteryPercentage() {
		return batteryPercentage;
	}

	public void setBatteryPercentage(double batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	public double getMilePerBattery() {
		return milePerBattery;
	}


	public boolean isFastCharge() {
		return fastCharge;
	}

	public double getBatteryChargeTime() {
		return batteryChargeTime;
	}

	public void setBatteryChargeTime(double batteryChargeTime) {
		this.batteryChargeTime = batteryChargeTime;
	}

	public String toString() {
	    return "ElectricCar Details\n" +super.toString()+
	           "  Battery Percentage: " + batteryPercentage + "%\n" +
	           "  Miles Per Battery Unit: " + milePerBattery + " miles\n" +
	           "  Supports Fast Charging: " + (fastCharge ? "Yes" : "No") + "\n" +
	           "  Battery Charge Time: " + batteryChargeTime + " hours to be fully charged\n";
	}
	
	public double costToFill() {
		return (100-batteryPercentage)*2;
	}

	
	public double calculateMilage() {
		// TODO Auto-generated method stub
		//1% = 5 mile
		return batteryPercentage*5;
	}
	
	
	
    
    
    
    
    
}