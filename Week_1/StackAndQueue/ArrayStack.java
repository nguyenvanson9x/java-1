import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements StackInterface<T> {
	private T[] stack;
	private int default_cap = 100, top = 0;

	public ArrayStack() {
		// TODO Auto-generated constructor stub
		stack = (T[]) new Object[default_cap];
	}

	public ArrayStack(int cap) {
		stack = (T[]) new Object[cap];
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListStackIterator();
	}

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		if (top >= stack.length)
			resize(top);
		stack[top++] = element;
	}

	private void resize(int i) {
		// TODO Auto-generated method stub
		T[] temp = (T[]) new Object[2 * i];
		int j;
		for (j = 0; j < i; j++)
			temp[j] = stack[j];
		stack = temp;

	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			T data = stack[top - 1];
			top--;
			return data;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == 0;
	}
	
	class ArrayListStackIterator implements Iterator<T> {
		private int id = top;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return id > 0;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			id--;
			return stack[id];
		}
		
	}

}
