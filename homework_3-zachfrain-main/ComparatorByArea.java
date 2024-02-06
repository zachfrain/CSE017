import java.util.Comparator;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class ComparatorByArea implements Comparator<Country>{
	/**
	 * Compares the areas of two countries to determine which is bigger and which is smaller.
	 */
	public int compare(Country o1, Country o2) {
		if(o1.getArea() < o2.getArea()) {
			return -1;
		}
		if(o1.getArea() > o2.getArea()) {
			return 1;
		}
		return 0;
	}

}
