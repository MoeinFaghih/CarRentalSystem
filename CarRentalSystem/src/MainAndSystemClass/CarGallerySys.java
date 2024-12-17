package MainAndSystemClass;
import java.util.ArrayList;
import java.util.HashMap;

import Has_A_Class.CarGallery;

public class CarGallerySys {

	private static ArrayList<CarGallery> carGal= new ArrayList<>();
	private static HashMap<Integer, String> userMap = new HashMap<>();
	
	
	public static boolean addCarGallery(String address, int id, String title, String pass) {
		if(isFound(id))
			return false;
		else {
			userMap.put(id, pass);
			CarGallery gal = new CarGallery(address, id, title);
			carGal.add(gal);
			
			return true;
		}
	}
	
	public static String display() {
		String s="";
		for (CarGallery carGallery : carGal) {
			s += carGallery.toString();
		}
		
		return s;
	}
	
	
	public static boolean isFound(Integer id) {
		return userMap.containsKey(id);
	}
	
	public static String getPassword(int id) {
		return userMap.get(id);
	}
	
	public static CarGallery getCarGalleryById(int id) {
		for (CarGallery carGallery : carGal) {
			if(carGallery.getId() == id)
				return carGallery;
		}
		
		return null;
	}
	
	public static boolean deleteCarGallery(int id) {
		CarGallery gal = getCarGalleryById(id);
		if(gal==null)
			return false;
		else {
			carGal.remove(gal);
			return true;
		}
	}
	
	public static int calculateTotalCarCount() {
		int count=0;
		for (CarGallery carGallery : carGal) {
			count += carGallery.getCars().size();
		}
		return count;
	}
	
	
	
	
	
	
	
}
