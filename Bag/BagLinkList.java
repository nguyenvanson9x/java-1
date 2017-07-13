import java.util.Iterator;
import java.util.Random;

public class BagLinkList<E> implements Bag<E> {
	class Node {
		E element;
		Node next;
	}

	private Node bag = null;
	private int n = 0;

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new BagIterator<E>();
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		if (!contains(element)) {
			Node p = new Node();
			p.element = element;
			p.next = bag;
			bag = p;
			n++;
		}
	}

	@Override
	public void remove(E element) {
		// TODO Auto-generated method stub
		
		if (n > 0) {
			if (n == 1) {
				if (bag.element.equals(element))
					bag = null;
			} else {
				Node p = bag;
				System.out.println("**-" + p.element);
				while (p.next != null) {
					System.out.println("*" + p.element);
					if (p.next.element.equals(element))
						p.next = p.next.next;
					p = p.next;
				}
			}
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return bag == null;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			Node p = bag;
			while (p != null) {
				if (p.element.equals(element))
					return true;
				p = p.next;
			}
		}
		return false;
	}

	@SuppressWarnings("hiding")
	class BagIterator<E> implements Iterator<E> {
		private int index[], current = 0;

		public BagIterator() {
			// TODO Auto-generated constructor stub
			index = new int[n];
			int i;
			for (i = 0; i < n; i++)
				index[i] = i;
			for (i = 0; i < n; i++) {
				int j = new Random().nextInt(n);
				// swap
				int temp = index[i];
				index[i] = index[j];
				index[j] = temp;
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current < n;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			// TODO Auto-generated method stub
			Node p = bag;
			int i;
			for (i = 0; i < index[current]; i++)
				p = p.next;
			E e = (E) p.element;
			current++;

			return e;
		}

		public void remove() {

		}
	}
}
