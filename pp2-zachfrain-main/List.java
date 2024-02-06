import java.util.ListIterator;
/**
 * List<E> interface
 * @author Zachary Frain
 * @version 1.0
 * 
 * @param <E>
 */
public interface List<E> {
	public abstract boolean add(E item);
	public abstract int size();
	public abstract ListIterator<E> listIterator();
	public abstract ListIterator<E> listIterator(int index);
	
}
