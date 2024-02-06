
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * Implementation of the LinkedList
 * 
 * @author Zachary Frain
 * @version 1.0
 * 
 * @param <E>
 */
public class LinkedList<E>{
	/**
	 * Data members for the LinkedList<E> class
	 */
	private Node head, tail;
	int size;
	/**
	 * Private class implementation of Node
	 */
	private class Node{
		E value;
		Node next;
		Node(E initialValue){
			value = initialValue; next = null;
		}
	}
	/**
	 * Constructor for LinkedList()
	 */
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	/**
	 * Boolean method to add item to the first index of the LinkedList
	 * @param item Object that is being added to the LinkedList
	 * @return Returns true once item has been added
	 */
	public boolean addFirst(E item) {
		Node newNode = new Node(item);
		if(head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++; return true;
	}
	/**
	 * Boolean method to add item to the last index of the LinkedList
	 * @param item Object that is being added to the LinkedList
	 * @return Returns true once item has been added
	 */
	public boolean addLast(E item) {
		Node newNode = new Node(item);
		if(head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++; return true;
	}
	/**
	 * Boolean method to add item to the first index of the LinkedList
	 */
	public boolean add(E item) {
		return addFirst(item);
	}
	/**
	 * Getter for the first value in the linked list
	 * @return The value of the first index
	 */
	public E getFirst() {
		if(head == null)
			throw new NoSuchElementException();
		return head.value;
	}
	/**
	 * Getter for the last value in the linked list
	 * @return The value of the last index
	 */
	public E getLast() {
		if(head == null)
			throw new NoSuchElementException();
		return tail.value;
	}
	/**
	 * Boolean method for removing the first index of the LinkedList
	 * @return Returns true once the object has been removed
	 */
	public boolean removeFirst() {
		if(head == null)
			throw new NoSuchElementException();
		head = head.next;
		if(head == null)
			tail = null;
		size--; return true;
	}
	/**
	 * Boolean method for removing the last index of the LinkedList
	 * @return Returns true once the object has been removed
	 */
	public boolean removeLast() {
		if(head == null)
			throw new NoSuchElementException();
		if(size == 1)
			return removeFirst();
		Node current = head;
		Node previous = null;
		while(current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null; tail = previous;
		size--; return true;
	}
	/**
	 * toString method for LinkedList
	 */
	public String toString() {
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
	 * Void method used to clear a linked list
	 */
	public void clear() {
		head = tail = null;
		size = 0;
	}
	/**
	 * Boolean method used to determine if the LinkedList is empty
	 * @return True if empty, False if not
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
	 * Getter for the int size
	 */
	public int size() {
		return size;
	}
	public int contains(E item) {
		ListIterator<E> iter = listIterator();
		int iterations = 0;
		while(iter.hasNext()) {
			iterations++;
			if(item.equals(iter.next())) {
				return iterations;
			}
		}
		return iterations;
	}
	/**
	 * Method used to create a new LinkedListIterator at the first index
	 */
	public ListIterator<E> listIterator(){
		return new LinkedListIterator();
	}
	/**
	 * Method used to create a new LinkedListIterator at the index given in the parameter
	 */
	public ListIterator<E> listIterator(int index){
		if(index == size()) {
			return new LinkedListIterator(size - 1);
		} else if(index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return new LinkedListIterator(index);
	}
	/**
	 * Private class LinkedListIterator<E> 
	 * @author Zach Frain
	 *
	 * @param <E> 
	 */
	private class LinkedListIterator<E> implements ListIterator<E>{
		private Node current = head;
		/**
		 * Constructor for LinkedListIterator at no given index
		 */
		public LinkedListIterator() {
			current = head;
		}
		/**
		 * Constructor for LinkedListIterator starting at the index given in the parameter
		 * @param index Int value containing the index in which the LinkedListIterator is starting at
		 */
		public LinkedListIterator(int index) {
			current = head;
			int i = 0;
			while(i < index) {
				current = current.next;
				i++;
			}
		}
		/**
		 * Boolean method to determine if there is another value next in the LinkedList
		 */
		public boolean hasNext() {
			return (current != null);
		}
		/**
		 * Method used to get the next value for the LinkedListIterator
		 */
		public E next() {
			if(current == null)
				throw new NoSuchElementException();
			E value = (E) current.value;
			current = current.next;
			return value;
		}
		/**
		 * Boolean method to determine if there is another value previously in the LinkedList
		 */
		public boolean hasPrevious() {
			return (current != null);
		}
		/**
		 * Method used to get the previous value for the LinkedListIterator
		 */
		public E previous() {
			if(head == null) {
				throw new NoSuchElementException();
			}
			Node temp = head;
			Node previous = null;
			while(temp != current) {
				previous = temp;
				temp = temp.next;
			}
			E value = (E) current.value;
			current = previous;
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
