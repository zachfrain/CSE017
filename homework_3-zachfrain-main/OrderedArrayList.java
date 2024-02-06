import java.util.ArrayList;
import java.util.Comparator;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 * 
 * @param <E> **FIGURE OUT WHAT TO PUT HERE**
 */
public class OrderedArrayList<E> {
	private ArrayList<E> list;
	private Comparator<E> comparator;
	/**
	 * Creates a new OrderedArrayList with comparator 'c'
	 * @param c The comparator that is being used on the OrderedArrayList
	 */
	public OrderedArrayList(Comparator<E> c) {
		list = new ArrayList<>(10);
		comparator = c;
	}
	/**
	 * Creates a new OrderedArrayList with comparator 'c' and the list's capacity being the integer 'cap'
	 * @param cap The integer that represents the capacity for the OrderedArrayList
	 * @param c The comparator that is being used on the OrderedArrayList
	 */
	public OrderedArrayList(int cap, Comparator<E> c) {
		list = new ArrayList<>(cap);
		comparator = c;
	}
	/**
	 * Method used to find 'E' item in list
	 * @param item The object that is being searched for in the list
	 * @return If the list contains object 'item', it will be returned, otherwise null will be returned
	 */
	public E find(E item) {
		if(item.equals(list.get(0))) {
			return list.get(0);
		} else {
			return find(item, 1);
		}
	}
	/**
	 * Helper method for find(E item)
	 * @param item The object that is being searched for in the list
	 * @param index The index of list that is being checked
	 * @return If the list contains object 'item', that object will be returned, otherwise null will be returned
	 */
	private E find(E item, int index) {
		if(index < list.size()) {
			if(item.equals(list.get(index))) {
				return list.get(index);
			} else {
				return find(item, index + 1);
			}
		}
		return null;
	}
	
	/**
	 * Method used to insert E item into an OrderedArrayList
	 * @param item The object that is being inserted into the OrderedArrayList
	 */
	public void insert(E item) {
		list.add(item);
		list.sort(comparator);
	}
	/**
	 * Method used to remove E item from an OrderedArrayList
	 * @param item The object that is being removed from the OrderedArrayList
	 * @return If the item was successfully removed true will be returned, otherwise, false will be returned
	 */
	public boolean remove(E item) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(item)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * Method used to return the size of an OrderedArrayList
	 * @return An integer containing the size of the OrderedArrayList
	 */
	public int size() {
		return list.size();
	}
	/**
	 * Method used to determine if an OrderedArrayList is empty
	 * @return If the list is empty this program will return true, otherwise, false will be returned.
	 */
	public boolean isEmpty() {
		return (list.size() == 0);
	}
	/**
	 * Method used to clear an OrderedArrayList
	 */
	public void clear() {
		while(!list.isEmpty()) {
			list.remove(0);
		}
	}
	/**
	 * Method used to set the comparator for an OrderedArrayList
	 * @param c The comparator that is being used in the OrderedArrayList
	 */
	public void setComparator(Comparator<E> c) {
		comparator = c;
		list.sort(comparator);
	}
	/**
	 * Method used to create a string that contains all the values from the OrderedArrayList
	 */
	public String toString() {
		String s = "";
		for(int i=0; i<list.size(); i++) {
			s += list.get(i).toString() +"\n";
		}
		return s;
	}
}

