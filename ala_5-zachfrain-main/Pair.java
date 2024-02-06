/**
 * @author Zachary Frain
 * @version 1.0
 *
 * @param <E1> The first object in the pair
 * @param <E2> The second object in the pair
 */
public class Pair<E1, E2>{
	private E1 first;
	private E2 second;
	/**
	 * Creates a Pair with objects E1 and E2
	 * @param f The first object in the pair
	 * @param s The second object in the pair
	 */
	public Pair(E1 f, E2 s) {
		first = f;
		second = s;
	}
	/**
	 * Getter for the first object in the pair
	 * @return Returns the first object in the pair
	 */
	public E1 getFirst() {
		return first;
	}
	/**
	 * Getter for the second object in the pair
	 * @return Returns the second object in the pair
	 */
	public E2 getSecond() {
		return second;
	}
	/**
	 * Setter for the first object in the pair
	 * @param f The desired first object of the pair
	 */
	public void setFirst(E1 f) {
		first = f;
	}
	/**
	 * Setter for the second object in the pair
	 * @param s The desired second object of the pair
	 */
	public void setSecond(E2 s) {
		second = s;
	}
	/**
	 * toString method for Pair<E1, E2>
	 * @return Returns a formatted string of the pair.
	 */
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	/**
	 * Method used to determine if two pairs are equal
	 * @return True if pairs are equal, False otherwise
	 */
	public boolean equals(Object o) {
		if(o instanceof Pair) {
			Pair<E1,E2> p = (Pair<E1,E2>)o;
			boolean eq1 = this.getFirst().equals(p.first);
			boolean eq2 = this.getSecond().equals(p.second);
			return eq1 && eq2;
		}
		return false;
	}
}
