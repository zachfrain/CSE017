import java.util.Comparator;
/**
 * @author Zachary Frain
 * @version 1.0
 * 
 * @param <E1> The first object in a pair
 * @param <E2> The second object in a pair
 */
public class ComparatorByFirst<E1 extends Comparable<E1>, E2> implements Comparator<Pair<E1, E2>>{
	/**
	 * Method used to compare two E1 objects for two different pairs
	 * @return An int that is used to compare the two objects
	 */
	public int compare(Pair<E1, E2> p1, Pair<E1, E2> p2) {
		E1 f1 = p1.getFirst();
		E1 f2 = p2.getFirst();
		return f1.compareTo(f2);
	}
}
