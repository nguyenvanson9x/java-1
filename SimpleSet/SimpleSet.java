import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleSet<T> implements Iterable<T> {
	private int n, default_size = 10;
	private T[] arr;

	private int[] B;
	private List<SimpleSet<T>> list_sub;

	@SuppressWarnings("unchecked")
	public SimpleSet() {
		arr = (T[]) new Object[default_size];
		n = 0;
	}

	@SuppressWarnings("unchecked")
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
		if (!isEmpty())
			for (i = 0; i < n; i++)
				if (arr[i].equals(element)) {
					int j;
					for (j = i; j < n; j++)
						arr[j] = arr[j + 1];
					j--;
					n--;
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
		if (!isEmpty())
			if (isSubset(set))
				for (T x : arr)
					if (!set.contains(x))
						temp.add(x);
		return temp;
	}

	public List<SimpleSet<T>> get_all_sub() {
		list_sub = new ArrayList<>();
		if (!isEmpty()) {
			B = new int[n];
			binary(0);
		} else {
			SimpleSet<T> zezo = new SimpleSet<>();
			list_sub.add(zezo);
		}
		return list_sub;
	}

	private void binary(int index) {
		int i;
		for (i = 0; i <= 1; i++) {
			B[index] = i;
			if (index == n - 1)
				put_to_list();
			else
				binary(index + 1);
		}
	}

	private void put_to_list() {
		// TODO Auto-generated method stub
		int i;
		SimpleSet<T> temp = new SimpleSet<>();
		for (i = 0; i < n; i++)
			if (B[i] != 0)
				temp.add(arr[i]);
		list_sub.add(temp);
	}

	@Override
	public Iterator<T> iterator() {
		return new SimpleSetIterator();
	}

	class SimpleSetIterator implements Iterator<T> {
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < n;
		}

		@Override
		public T next() {
			return arr[index++];
		}

		public void remove() {

		}

	}

}
