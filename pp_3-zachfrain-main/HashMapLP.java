import java.util.ArrayList;
import java.util.LinkedList;
/**
 * HashMapLP implementation
 * @author Zachary Frain
 * @version 1.0
 *
 * @param <K> Key value
 * @param <V> Value value
 */
public class HashMapLP<K, V> {
	/**
	 * Data members
	 */
	public static int iterations;
	private int size;
	private double loadFactor;
	private HashMapEntry<K, V>[] hashTable;
	public static int collisions;

	/**
	 * No-arg constructor for a HashMapLP
	 */
	public HashMapLP() {
		this(100, 0.5);
	}
	/**
	 * One-arg constructor for a HashMapLP
	 * @param c int value representing the capacity of the HashMapLP
	 */
	public HashMapLP(int c) {
		this(c, 0.5);
	}
	/**
	 * Two-arg constructor for a HashMapLP
	 * @param c int value representing the capacity of the HashMapLP
	 * @param lf int value representing the load factor of the HashMapLP
	 */
	public HashMapLP(int c, double lf) {
		hashTable = new HashMapEntry[trimToPowerOf2(c)];
		loadFactor = lf;
		size = 0;
		collisions = 0;
	}

	/**
	 * private method that trims int c to the nearest power of 2
	 * @param c int value representing the capacity of the HashMapLP
	 * @return int value representing the new capacity trimmed to the nearest power of 2
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
	 * private method used to resize the hashTable and rehash all the previously hashed HashMapEntry objects
	 */
	private void rehash() {
		ArrayList<HashMapEntry<K,V>> list = toList();
		hashTable = new HashMapEntry[hashTable.length << 1];
		size = 0;
		for(int i = 0; i < list.size(); i++)
			put(list.get(i).getKey(), list.get(i).getValue());
	}
	/**
	 * getter method for the data member size
	 * @return int value representing the size
	 */
	public int size() {
		return size;
	}
	/**
	 * method used to clear the hashTable
	 */
	public void clear() {
		size = 0;
		for (int i = 0; i < hashTable.length; i++)
			hashTable[i] = null;
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
	 * @param key K value representing the key being checked
	 * @return true if the key is in the hashTable, false if not
	 */
	public boolean containsKey(K key) {
		if (get(key) != null)
			return true;
		return false;
	}
	/**
	 * method used to get the corresponding value to the K key
	 * @param key K value representing the key being searched for in the hashTable
	 * @return if the key is present, the corresponding value will be returned, if not null is returned
	 */
	public V get(K key) {
		iterations = 0;
		int HTIndex = hash(key.hashCode());
		int i;
		for(i = HTIndex; hashTable[i] != null; i = (i + 1) % hashTable.length) {
			iterations++;
			if(hashTable[i].getKey().equals(key)) {
				return hashTable[i].getValue();
			}
		}
		return null;
	}
	/**
	 * method used to remove a HashMapEntry from the hashTable
	 * @param key K value representing the key of the HashMapEntry being removed
	 */
	public void remove(K key) {
		if(key == null) throw new IllegalArgumentException("arguement is null");
		if(!containsKey(key)) return;
		
		int i = hash(key.hashCode());
		while(!key.equals(hashTable[i].getKey())) {
			i = (i + 1) % size;
		}
		hashTable[i].setKey(null);
		hashTable[i].setValue(null);
		
		i = (i + 1) % size;
		while(hashTable[i].getKey() != null) {
			K tempKey = hashTable[i].getKey();
			V tempValue = hashTable[i].getValue();
			hashTable[i].setKey(null);
			hashTable[i].setValue(null);
			size--;
			put(tempKey, tempValue);
			i = (i + 1) % size;
		}
		size--;
	}
	/**
	 * method used to add a new HashMapEntry to the hashTable
	 * @param key K value representing the key being added
	 * @param value V value representing the value being added
	 * @return If the key is already in the hashTable, the corresponding value will be returned. If the key isn't present, the new value is returned
	 */
	public V put(K key, V value) {
		if(get(key) != null) {
			int HTIndex = hash(key.hashCode());
			while(!key.equals(hashTable[HTIndex].getKey())) {
				HTIndex = (HTIndex + 1) % hashTable.length;
			}
			V old = hashTable[HTIndex].getValue();
			hashTable[HTIndex].setValue(value);
			return old;
		}
		if(size >= hashTable.length * loadFactor)
			rehash();
		int HTIndex = hash(key.hashCode());
		if(hashTable[HTIndex] != null){
			collisions++;
		}
		while(hashTable[HTIndex] != null) {
			HTIndex = (HTIndex + 1) % hashTable.length;
		}
		hashTable[HTIndex] = new HashMapEntry<>(key, value);
		size++;
		return value;	
	}
	/**
	 * method used to put the elements from the hashTable into an ArrayList
	 * @return an ArrayList containing all the HashMapEntry objects from the hashTable
	 */
	public ArrayList<HashMapEntry<K,V>> toList(){
		ArrayList<HashMapEntry<K,V>> list = new ArrayList<>();
		for(int i=0; i< hashTable.length; i++) {
			if(hashTable[i]!= null) {
				list.add(hashTable[i]);
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
				out += hashTable[i].toString();
				out += "\n";
			}
		}
		out += "]";
		return out;
	}

}
