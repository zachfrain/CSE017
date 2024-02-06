import java.util.Comparator;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class ComparatorByName implements Comparator<Country>{
	/**
	 * Compares the name of two countries to determine the alphabetical order of the list
	 */
	public int compare(Country o1, Country o2) {
		String a = o1.getName();
		String b = o2.getName();
		return a.compareTo(b);
	}
}
