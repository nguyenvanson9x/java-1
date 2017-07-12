import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
	private T[] array;
	private int n = 0;
	private int defaultSize = 100;

	@SuppressWarnings("unchecked")
	public SimpleArrayList() {
		// TODO Auto-generated constructor stub
		array = (T[]) new Object[defaultSize];
	}

	@SuppressWarnings("unchecked")
	public SimpleArrayList(int cap) {
		array = (T[]) new Object[cap];
	}

	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		if (n >= defaultSize)
			resize(2 * n);
		array[n] = data;
		n++;

	}

    private void resize(int cap) {
        T[] tmp = (T[]) new Object[cap];
        System.arraycopy(array, 0, tmp, 0, n);
        array = tmp;
    }

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		if (i >= 0 && i < size())
			return array[i];
		return null;
	}

	@Override
	public void set(int i, T data) {
		// TODO Auto-generated method stub
		if (i >= 0 && i < size())
			array[i] = data;
	}

	@Override
	public void remove(T data) {
		// TODO Auto-generated method stub
		int index = 0;
		while (index < size()) {
			if (array[index].equals(data)) {
				int i;
				for (i = index; i < size() - 1; i++)
					array[i] = array[i + 1];
				n--;
			}
			index++;
		}
	}

	@Override
	public boolean isContain(T data) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < size()) {
			if (array[i].equals(data))
				return true;
			i++;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}
	
	@Override
	public int indexOf(T data) {
		// TODO Auto-generated method stub
		int index = 0;
		while (array[index].equals(data) == false) {
			index++;
		}
		return index;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	
	class ArrayListIterator implements Iterator<T> {
		private int i = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < n;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return array[i++];
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
		
	}
}
