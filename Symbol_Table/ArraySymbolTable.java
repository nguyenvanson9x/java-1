import java.util.Arrays;
import java.util.Iterator;

public class ArraySymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
	private Key[] keys;
	private Value[] vals;
	private int n, default_size = 10;

	@SuppressWarnings("unchecked")
	public ArraySymbolTable() {
		// TODO Auto-generated constructor stub
		keys = (Key[]) new Comparable[default_size];
		vals = (Value[]) new Object[default_size];
		n = 0;
	}

	@Override
	public void put(Key key, Value value) {
		// TODO Auto-generated method stub
		int r = rank(key);
		if (contains(key))
			vals[r] = value;
		else {
			n++;
			if (n >= keys.length)
				resize(n);
			int i;
			for (i = n - 1; i > r; i--) {
				keys[i] = keys[i - 1];
				vals[i] = vals[i - 1];
			}
			keys[r] = key;
			vals[r] = value;
		}
	}

	private void resize(int n) {
		// TODO Auto-generated method stub
		keys = Arrays.copyOf(keys, 2 * n);
		vals = Arrays.copyOf(vals, 2 * n);

	}

	private int rank(Key key) {
		int u = 0;
		int v = n - 1;
		while (u <= v) {
			int m = u + (v - u) / 2;
			int c = key.compareTo(keys[m]);
			if (c < 0)
				v = m - 1;
			else if (c > 0)
				u = m + 1;
			else
				return m;
		}
		return u;
	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		int r = rank(key);
		if (r < n && keys[r].compareTo(key) == 0)
			return vals[r];
		return null;
	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub
		put(key, null);

	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return new ArraySymbolTableIterable();
	}

	class ArraySymbolTableIterable implements Iterable<Key> {

		@Override
		public Iterator<Key> iterator() {
			// TODO Auto-generated method stub
			return new ArraySymbolTableIterator();
		}

	}

	class ArraySymbolTableIterator implements Iterator<Key> {
		int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < n;
		}

		@Override
		public Key next() {
			// TODO Auto-generated method stub
			return keys[index++];
		}

		public void remove() {

		}

	}

}
