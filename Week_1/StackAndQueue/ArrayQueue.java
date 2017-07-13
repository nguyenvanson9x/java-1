import java.util.Iterator;

public class ArrayQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int n = 0;
	private int top = 0;
	private int count = 0;
	private int default_size = 100;

	public ArrayQueue() {
		// TODO Auto-generated constructor stub
		n = default_size;
		queue = (T[]) new Object[default_size];
	}

	public ArrayQueue(int cap) {
		n = cap;
		queue = (T[]) new Object[cap];
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayQueueIterator();
	}

	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		if (count >= queue.length)
			resize(count);
		queue[(top + count) % n] = element;
		count++;
	}

	private void resize(int n) {
		T[] temp = (T[]) new Object[2 * n];
		int i;
		for (i = 0; i < n; i++)
			temp[i] = queue[(top + i) % n];
		queue = temp;
		top = 0;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			T data = queue[top];
			count--;
			top++;
			if (top == n)
				top = 0;
			return data;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}

	class ArrayQueueIterator implements Iterator<T> {
		private int current = top;
		private int num = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return num < count;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data = queue[(current + num) % n];
			num++;
			return data;
		}
		
		public void remove() {
			
		}

	}
}
