import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * Implementation of DoublyLinkedList<E> implementing the List<E> interface
 * @author Zachary Frain
 * @version 1.0
 *
 * @param <E>
 */
public class DoublyLinkedList<E> implements List<E>{
	/**
	 * Data members for the DoublyLinkedList
	 */
	private Node head, tail;
	int size;
	/**
	 * Inner class for the implementation of Node
	 * @author Zachary Frain
	 *
	 */
	private class Node{
		/**
		 * Data members of the Node
		 */
		E value;
		Node previous;
		Node next;
		
		Node(E initialValue){
			value = initialValue;
		}
		/**
		 * Void method used to print out the value of a Node
		 */
		public void displayData() {
			System.out.print(" " + value);
		}
	}
	/**
	 * Constructor for the DoublyLinkedList
	 */
	public DoublyLinkedList() {
		head = tail = null;
		size = 0;
	}
	/**
	 * Boolean method used to add an item to the front of a DoublyLinkedList
	 * @param item The item that is being added to the DoublyLinkedList
	 * @return True once added
	 */
	public boolean addFirst(E item) { //O(1)
		Node newNode = new Node(item);
		if(isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		size++; return true;
	}
	/**
	 * Boolean method used to add an item to the end of a DoublyLinkedList
	 * @param item The item that is being added to the DoublyLinkedList
	 * @return True once added
	 */
	public boolean addLast(E item) { //O(1)
		Node newNode = new Node(item);
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		size++; return true;
	}
	/**
	 * Boolean method used to add an item to the DoublyLinkedList
	 */
	public boolean add(E item) { //O(1)
		return addFirst(item);
	}
	/**
	 * Getter for the first value in the DoublyLinkedList
	 * @return If there is no value for head, error is thrown, otherwise, the first value in the list is returned
	 */
	public E getFirst() { //O(1)
		if(head == null)
			throw new NoSuchElementException();
		return head.value;
	}
	/**
	 * Getter for the last value in the DoublyLinkedList
	 * @return If there is no value for head, error is thrown, otherwise, the last value in the list is returned
	 */
	public E getLast() { //O(1)
		if(head == null)
			throw new NoSuchElementException();
		return tail.value;
	}
	/**
	 * Boolean method used to remove the first value from the DoublyLinkedList
	 * @return If there is no value for head, error is thrown, otherwise, the first value in the list is removed
	 */
	public boolean removeFirst() { //O(1)
		if(head == null) {
			throw new NoSuchElementException();
		}
		if(head.next == null) {
			tail = null;
		} else {
			head.next.previous = null;
		}
		head = head.next;
		size--; return true;
	}
	/**
	 * Boolean method used to remove the last value from the DoublyLinkedList
	 * @return If there is no value for tail, error is throw, otherwise, the last value in the list is removed
	 */
	public boolean removeLast() { //O(1)
		if(tail == null) {
			throw new NoSuchElementException();
		}
		if(head.next == null) {
			head = null;
		} else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		size--; return true;
	}
	/**
	 * toString() method for the DoublyLinkedList 
	 */
	public String toString() { //O(n)
		String output = "[";
		Node node = head;
		while(node != null) {
			output += node.value + " ";
			node = node.next;
		}
		output += "]";
		return output;
	}
	/**
	 * Void method used to clear a DoublyLinkedList
	 */
	public void clear() { //O(1)
		head = tail = null;
		size = 0;
	}
	/**
	 * Boolean method used to determine if the DoublyLinkedList is empty
	 * @return True if the list is empty, false otherwise
	 */
	public boolean isEmpty() { //O(1)
		return (size == 0);
	}
	/**
	 * Getter for the int size
	 */
	public int size() { //O(1)
		return size;
	}
	/**
	 * Creates a new DoublyLinkedListIterator() aimed at the first index
	 */
	public ListIterator<E> listIterator(){ //O(1)
		return new DoublyLinkedListIterator();
	}
	/**
	 * Creates a new DoublyLinkedListIterator() aimed at the index given in the parameter
	 */
	public ListIterator<E> listIterator(int index){ //O(1)
		if(index == size()) {
			return new DoublyLinkedListIterator(size - 1);
		} else if(index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return new DoublyLinkedListIterator(index);
	}
	/**
	 * Inner class implementation of the DoublyLinkedListIterator<E> implementing the interface ListIterator<E>
	 * @author Zachary Frian
	 * @version 1.0
	 * 
	 * @param <E>
	 */
	private class DoublyLinkedListIterator<E> implements ListIterator<E>{
		/**
		 * Data members for the DoublyLinkedListIterator
		 */
		private Node current = head;
		private Node lastAccessed = null;
		private int ind = -1;
		/**
		 * Constructor for the DoublyLinkedListIterator() aimed at the first index
		 */
		public DoublyLinkedListIterator() { //O(1)
			current = head;
		}
		/**
		 * Constructor for the DoublyLinkedListIterator() aimed at the index given in the parameter
		 * @param index Value containing the index in which the DoublyLinkedListIterator() starts at
		 */
		public DoublyLinkedListIterator(int index) { //O(n)
			current = head;
			int i = 0;
			while(i < index) {
				current = current.next;
				i++;
			}
			ind = index;
		}
		/**
		 * Boolean method used to determine if there is a proceeding value for the DoublyLinkedListIterator()
		 */
		public boolean hasNext() { //O(1)
			return (current != null);
		}
		/**
		 * Getter for the next value being pointed at by the DoublyLinkedListIterator()
		 */
		public E next() { //O(1)
			if(!hasNext())
				throw new NoSuchElementException();
			lastAccessed = current;
			E value = (E) current.value;
			current = current.next;
			ind++;
			return value;
		}
		/**
		 * Boolean method used to determine if there is a previous value for the DoublyLinkedListIterator()
		 */
		public boolean hasPrevious() { //O(1)
			return (current != null);
		}
		/**
		 * Getter for the previous value being pointed at by the DoublyLinkedListIterator()
		 */
		public E previous() { //O(1)
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			E value = (E) current.value;
			current = current.previous;
			ind--;
			lastAccessed = current;
			return value;
		}
		
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}
		public void set(E e) {
			throw new UnsupportedOperationException();
		}
		public void add(E e) {
			throw new UnsupportedOperationException();
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}