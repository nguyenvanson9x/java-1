public interface Bag<E> extends Iterable<E> {
	void add(E element);
	void remove(E element);
	boolean isEmpty();
	boolean contains(E element);
}
