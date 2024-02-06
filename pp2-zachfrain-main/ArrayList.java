import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{
	// data members
	private E[] elements;
	private int size;
	
	// constructors
	public ArrayList(){
		elements = (E[]) new Object[10];
		size = 0;
	}
	public ArrayList(int capacity) {
		elements = (E[]) new Object[capacity];
		size = 0;
	}
	
	// adding an item to the list (2 methods)
	public boolean add(E item) {
		return add(size, item);
	}
	public boolean add(int index, E item) {
		if(index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		ensureCapacity();
		elements[index] = item;
		size++;
		return true;
	}
	
	// getter and setter
	public E get(int index) {
		checkIndex(index);
		return elements[index];
	}
	public E set(int index, E item) {
		checkIndex(index);
		E oldItem = elements[index];
		elements[index] = item;
		return oldItem;
	}
	// size of the list
	public int size() {
		return size;
	}
	// clear the list
	public void clear() {
		size = 0;
	}
	// check if the list is empty
	public boolean isEmpty() {
		return (size == 0);
	}
	
	// removing an object from the list
	public boolean remove(Object o) {
		E item = (E) o;
		for(int i = 0; i < size; i++)
			if(elements[i].equals(item)) {
				remove(i);
				return true;
			}
		return false;
	}
	// removing the item at index from the list
	public E remove(int index) {
		checkIndex(index);
		E item = elements[index];
		for(int i = index; i < size-1; i++)
			elements[i] = elements[i + 1];
		size--;
		return item;
	}
	// shrink the list to size
	public void trimToSize() {
		if(size != elements.length) {
			E[] newElements = (E[]) new Object[size];
			for(int i=0; i<size; i++)
				newElements[i] = elements[i];
			elements = newElements;
		}
	}
	// grow the list if needed
	private void ensureCapacity() {
		if(size >= elements.length) {
			int newCap = (int)(elements.length * 1.5);
			E[] newElements = (E[]) new Object[newCap];
			for(int i=0; i<size; i++)
				newElements[i] = elements[i];
			elements = newElements;
		}
	}
	// check if the index is valid
	private void checkIndex(int index) {
		if(index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException(
			"Index out of bounds. Must be between 0 and "+
			(size-1));
	}
	// toString() method
	public String toString() {
		String output = "[";
		for(int i=0; i<size-1; i++)
			output += elements[i] + " ";
		output += elements[size-1] + "]";
		return output;
	}
	// iterator for the list
	public Iterator<E> iterator(){
		return new ArrayIterator();
	}
	// inner class that implements Iterator<E>
	private class ArrayIterator implements Iterator<E>{
		private int current = -1;
		public boolean hasNext() {
			return current < size - 1;
		}
		public E next() {
			return elements[++current];
		}
	}
	// returns an object of type ArrayListIterator that points
	// to the first element in the list
	public ListIterator<E> listIterator(){
		return new ArrayListIterator();
	}
	// returns an object of type ArrayListIterator that points
	// to the element at position index
	public ListIterator<E> listIterator(int index){
		if(index == size()) {
			return new ArrayListIterator(size - 1);
		} else if(index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return new ArrayListIterator(index);
	}
	
	private class ArrayListIterator<E> implements ListIterator<E>{
		private int currentIndex = 0;
		
		public ArrayListIterator() {

		}
		public ArrayListIterator(int index) {
			currentIndex = index;
		}
		
		public boolean hasNext(){
			return currentIndex < size();
		}
		
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return (E) elements[currentIndex++];
		}
		public boolean hasPrevious() {
			return currentIndex >= 0;
		}
		public E previous() {
			if(hasPrevious() == false) {
				throw new NoSuchElementException();
			}
			return (E) elements[currentIndex--];
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
