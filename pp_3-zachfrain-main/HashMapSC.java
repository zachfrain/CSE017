import java.util.ArrayList;
import java.util.LinkedList;
/**
 * HashMapSC implementation
 * @author Zachary Frain
 * @version 1.0
 *
 * @param <K> Key value
 * @param <V> Value value
 */
public class HashMapSC<K, V> {
	/**
	 * Data members
	 */
	public static int iterations;
	private int size;
	private double loadFactor;
	private LinkedList<HashMapEntry<K, V>>[] hashTable;
	public static int collisions;

	/**
	 * No-arg constructor for a HashMapSC
	 */
	public HashMapSC() {
		this(100, 0.9);
	}
	/**
	 * One-arg constructor for a HashMapSC
	 * @param c int value representing the capacity of the HashMapSC
	 */
	public HashMapSC(int c) {
		this(c, 0.9);
	}
	/**
	 * Two-arg constructor for a HashMapSC
	 * @param c int value representing the capacity of the HashMapSC
	 * @param lf double value representing the load factor of the HashMapSC
	 */
	public HashMapSC(int c, double lf) {
		hashTable = new LinkedList[trimToPowerOf2(c)];
		loadFactor = lf;
		size = 0;
		collisions = 0;
	}

	/**
	 * private method that trims int c to the nearest power of 2
	 * @param c int value representing the capacity of the HashMapSC
	 * @return an int value representing the new capacity
	 */
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity = capacity << 1;
		return capacity;
	}
	/**
	 * private method used to hash keys
	 * @param hashCode int value representing the hashCode for the key being hashed
	 * @return an int value between 0 and hashTable.length - 1
	 */
	private int hash(int hashCode) {
		return hashCode & (hashTable.length - 1);
	}
	/**
	 * private method used to resize the hashTable and rehashes all the previously hashed keys
	 */
	private void rehash() {
		ArrayList<HashMapEntry<K,V>> list = toList();
		hashTable = new LinkedList[hashTable.length << 1];
		size = 0;
		for(HashMapEntry<K,V> entry: list)
			put(entry.getKey(), entry.getValue());

	}
	/**
	 * Getter method for the size
	 * @return int value representing the size of the hashTable
	 */
	public int size() {
		return size;
	}
	/**
	 * Method used to clear a hashTable
	 */
	public void clear() {
		size = 0;
		for (int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null)
				hashTable[i].clear();
	}
	/**
	 * boolean method used to determine if the hashTable is empty
	 * @return true if empty, false if not
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
	 * boolean method used to determine if the key is in the hashTable
	 * @param key K value representing the key in question
	 * @return true if the key is in the hashTable, false if not 
	 */
	public boolean containsKey(K key) {
		if (get(key) != null)
			return true;
		return false;
	}
	/**
	 * method used to get a value using the corresponding key
	 * @param key K value representing the key in question
	 * @return if the value if in the hashTable, the corresponding value will be returned, null returned if key is not in hashTable
	 */
	public V get(K key) {
		iterations = 0;
		int HTIndex = hash(key.hashCode());
		if (hashTable[HTIndex] != null) {
			LinkedList<HashMapEntry<K, V>> ll = hashTable[HTIndex];
			for (HashMapEntry<K, V> entry : ll) {
				iterations++;
				if (entry.getKey().equals(key))
					return entry.getValue();
			}
		}
		return null;
	}
	/**
	 * method used to remove a HashMapEntry<K,V> from the hashTable
	 * @param key K value representing the key for the HashMapEntry being removed
	 */
	public void remove(K key) {
		int HTIndex = hash(key.hashCode());
		if (hashTable[HTIndex] != null) {
			LinkedList<HashMapEntry<K, V>> ll = hashTable[HTIndex];
			for (HashMapEntry<K, V> entry : ll) {
				if (entry.getKey().equals(key)) {
					ll.remove(entry);
					size--;
					break;
				}
			}
		}
	}
	/**
	 * method used to put a new HashMapEntry<K,V> into the hashTable
	 * @param key K value representing the key being added
	 * @param value V value representing the value being added
	 * @return if the Key is already in the hashTable, the corresponding value will be returned. If not, the new value will be returned
	 */
	public V put(K key, V value) {
		if(get(key) != null) {
			int HTIndex = hash(key.hashCode());
			LinkedList<HashMapEntry<K,V>> ll;
			ll = hashTable[HTIndex];
			for(HashMapEntry<K,V> entry: ll) {
				if(entry.getKey().equals(key)) {
					V old = entry.getValue();
					entry.setValue(value);
					return old;
				}
			}
		}
		if(size >= hashTable.length * loadFactor)
			rehash();
		int HTIndex = hash(key.hashCode());
		if(hashTable[HTIndex] == null){
				hashTable[HTIndex] = new LinkedList<>();
		} else {
			collisions++;
		}
		hashTable[HTIndex].add(new HashMapEntry<>(key, value));
		size++;
		return value;
	}
	/**
	 * method used to put the values from the HashTable into an ArrayList
	 * @return An ArrayList with all the values from the HashTable
	 */
	public ArrayList<HashMapEntry<K,V>> toList(){
		ArrayList<HashMapEntry<K,V>> list = new ArrayList<>();
		for(int i=0; i< hashTable.length; i++) {
			if(hashTable[i]!= null) {
				LinkedList<HashMapEntry<K,V>> ll = hashTable[i];
				for(HashMapEntry<K,V> entry: ll)
					list.add(entry);
			}
		}
		return list;
	}
	/**
	 * toString() method
	 */
	public String toString() {
		String out = "[";
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null) {
				for(HashMapEntry<K,V> entry: hashTable[i])
					out += entry.toString();
				out += "\n";
			}
		}
		out += "]";
		return out;
	}

}
