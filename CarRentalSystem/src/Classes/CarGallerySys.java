package Classes;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	
	public static boolean isFound(Integer id) {
		return userMap.containsKey(id);
	}
	
	public static CarGallery getCarGalleryById(int id) {
		for (CarGallery carGallery : carGal) {
			if(carGallery.getId() == id)
				return carGallery;
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
}
