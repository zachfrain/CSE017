import java.util.Comparator;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class ComparatorByCode implements Comparator<Country>{
	/**
	 * Compares the code for two countries to determine the alphabetical order of the list
	 */
	public int compare(Country o1, Country o2) {
		String a = o1.getCode();
		String b = o2.getCode();
		return a.compareTo(b);
	}

}
