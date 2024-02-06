/**
 * HashMapEntry implementation
 * @author Zachary Frain
 * @version 1.0
 *
 * @param <K> Key value
 * @param <V> Value value
 */
public class HashMapEntry<K, V> {
	/**
	 * Data members
	 */
	private K key;
	private V value;
	/**
	 * Two-arg constructor for a HashMapEntry
	 * @param k K value representing the key
	 * @param v V value representing the value
	 */
	public HashMapEntry(K k, V v) {
		key = k;
		value = v;
	}
	/**
	 * getter method for the key
	 * @return K value representing the key
	 */
	public K getKey() {
		return key;
	}
	/**
	 * getter method for the value
	 * @return V value representing the value
	 */
	public V getValue() {
		return value;
	}
	/**
	 * setter method for the key
	 * @param k K value representing the key
	 */
	public void setKey(K k) {
		key = k;
	}
	/**
	 * setter method for the value
	 * @param v V value representing the value
	 */
	public void setValue(V v) {
		value = v;
	}
	/**
	 * toString() method
	 */
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}

