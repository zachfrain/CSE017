import java.util.Comparator;
/**
 * @author Zachary Frain
 * @version 1.0
 * 
 * @param <E1> The first object in a pair
 * @param <E2> The second object in a pair
 */
public class ComparatorBySecond<E1, E2 extends Comparable<E2>> implements Comparator<Pair<E1, E2>>{
	/**
	 * Method used to compare two E2 objects for two different pairs.
	 * @return An int that is used to compare the two objects
	 */
	public int compare(Pair<E1, E2> p1, Pair<E1, E2> p2) {
		E2 s1 = p1.getSecond();
		E2 s2 = p2.getSecond();
		return s1.compareTo(s2);
	}
}
