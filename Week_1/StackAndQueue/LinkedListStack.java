import java.util.Iterator;

public class LinkedListStack<T> implements StackInterface<T> {
	class Node {
		T element;
		Node next;
	}

	private Node head = null;

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		Node p = new Node();
		p.element = element;
		p.next = head;
		head = p;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			T e = head.element;
			head = head.next;
			return e;
		}
		return null;
	}
	
	@Override
	public T peek() {
		if (!isEmpty())
			return head.element;
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	public void print() {
		Node p = head;
		while (p != null) {
			System.out.print(p.element + " ");
			p = p.next;
		}
	}

	class StackIterator implements Iterator<T> {
		private Node p = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return p != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data = p.element;
			p = p.next;
			return data;
		}

		public void remove() {
			
		}
	}
}
