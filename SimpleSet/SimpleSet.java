import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
	private int n, default_size = 10;
	private T[] arr;

	public SimpleSet() {
		// TODO Auto-generated constructor stub
		arr = (T[]) new Object[default_size];
		n = 0;
	}

	public SimpleSet(T[] set) {
		int i, set_size = set.length;
		arr = (T[]) new Object[set_size];
		for (i = 0; i < set_size; i++)
			arr[i] = set[i];
		n = set_size;
	}

	public void add(T element) {
		if (!contains(element)) {
			arr[n] = element;
			n++;
		}
	}

	public void remove(T element) {
		int i;
		if (!isEmpty()) {
			for (i = 0; i < n; i++) {
				if (arr[i].equals(element)) {
					int j;
					for (j = i; j < n; j++)
						arr[j] = arr[j + 1];
					j--;
					n--;
				}
			}
		}

	}

	public boolean contains(T element) {
		int i;
		for (i = 0; i < n; i++)
			if (arr[i].equals(element))
				return true;
		return false;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public boolean isSubset(SimpleSet<T> set) {
		if (isEmpty()) {
			if (!set.isEmpty())
				return false;
			return true;
		}
		for (T x : set) {
			if (!contains(x))
				return false;
		}
		return true;
	}

	public boolean isEqual(SimpleSet<T> set) {
		SimpleSet<T> temp = new SimpleSet<>(arr);
		return isSubset(set) && set.isSubset(temp);
	}

	public SimpleSet<T> Giao(SimpleSet<T> set) {
		SimpleSet<T> temp = new SimpleSet<>();
		for (T x : set)
			if (contains(x))
				temp.add(x);
		return temp;
	}

	public SimpleSet<T> Hop(SimpleSet<T> set) {
		int i;
		SimpleSet<T> temp = new SimpleSet<>();
		for (T x : set)
			temp.add(x);
		for (i = 0; i < n; i++)
			temp.add(arr[i]);
		return temp;
	}

	public SimpleSet<T> Tru(SimpleSet<T> set) {
		SimpleSet<T> temp = new SimpleSet<>();
		if (!isEmpty()) {
			if (isSubset(set)) {
				for (T x : arr)
					if (!set.contains(x))
						temp.add(x);
			}
		}
		return temp;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new SimpleSetIterator();
	}

	class SimpleSetIterator implements Iterator<T> {
		int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < n;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return arr[index++];
		}
		
		public void remove() {
			
		}

	}

}
