import java.util.Iterator;

public class LinkListQueue<T> implements QueueInterface<T> {
	class Node {
		T element;
		Node next;
	}

	private Node first, last;

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkListQueueIterator();
	}

	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		Node p = new Node();
		p.element = element;
		p.next = null;
		if (first == null) {
			first = p;
			last = p;
		} else if (last == null)
			last = p;
		else {
			last.next = p;
			last = p;
		}
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			Node p = first;
			T data = p.element;
			p = p.next;
			return data;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == null;
	}
	
	class LinkListQueueIterator implements Iterator<T> {
		Node p = first;
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
