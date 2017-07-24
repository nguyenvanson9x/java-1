import java.util.Arrays;
import java.util.Iterator;

public class Array_Ordered_SymbolTable<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
	private Key[] keys;
	private Value[] vals;
	private int n, default_size = 10;

	public Array_Ordered_SymbolTable() {
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
	public Key min() {
		// TODO Auto-generated method stub
		if (!isEmpty())
			return keys[0];
		return null;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		if (!isEmpty())
			return keys[n - 1];
		return null;
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		int r = rank(key);
		if (r == 0) {
			if (keys[r].compareTo(key) == 0)
				return keys[r];
			return null;
		}
		if (r == n)
			return keys[n - 1];
		if (keys[r].compareTo(key) == 0)
			return keys[r];
		else
			return keys[r - 1];
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		int r = rank(key);
		// key <= keys[r] with 0 <= r <= n - 1
		// key > keys[n - 1] with r >= n
		if (0 <= r && r <= n - 1)
			return keys[r];
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		int u, v, m, c;
		u = 0;
		v = n - 1;
		while (u <= v) {
			m = u + (v - u) / 2;
			c = key.compareTo(keys[m]);
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
	public Key select(int k) {
		// TODO Auto-generated method stub
		if (0 <= k && k <= n - 1)
			return keys[k];
		return null;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			int i;
			for (i = 0; i < n; i++) {
				keys[i] = keys[i + 1];
				vals[i] = vals[i + 1];
			}
			n--;
		}
	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub
		if (!isEmpty())
			n--;

	}

	@Override
	public int size(Key u, Key v) {
		// TODO Auto-generated method stub
		int rank_u, rank_v, plus_low = 0, plus_height = 0;
		rank_u = rank(floor(u));
		rank_v = rank(ceiling(v));
		if (u.compareTo(floor(u)) != 0)
			plus_low = 1;
		if (v.compareTo(ceiling(v)) != 0)
			plus_height = 1;
		return rank_v - rank_u + 1 - plus_height - plus_low;
	}

	@Override
	public Iterable<Key> keys(Key u, Key v) {
		// TODO Auto-generated method stub
		return null;
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
