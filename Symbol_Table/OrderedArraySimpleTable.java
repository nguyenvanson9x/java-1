import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedArraySimpleTable<Key extends Comparable<Key>, Value>
		implements OrderedSimpleTable<Key, Value> {
	private Key[] keys;
	private Value[] vals;
	private int n = 0, default_size = 10;

	@SuppressWarnings("unchecked")
	public OrderedArraySimpleTable() {
		keys = (Key[]) new Comparable[default_size];
		vals = (Value[]) new Object[default_size];
	}

	@SuppressWarnings("unchecked")
	public OrderedArraySimpleTable(int cap) {
		keys = (Key[]) new Comparable[cap];
		vals = (Value[]) new Object[cap];
	}

	@Override
	public void put(Key key, Value value) {
		if (n >= keys.length) {
			keys = Arrays.copyOf(keys, 2 * n);
			vals = Arrays.copyOf(vals, 2 * n);
		}
		int r = rank(key);
		if (r < n && key.compareTo(keys[r]) == 0)
			vals[r] = value;
		else {
			int i;
			n++;
			for (i = n - 1; i > r; i--) {
				keys[i] = keys[i - 1];
				vals[i] = vals[i - 1];
			}
			keys[r] = key;
			vals[r] = value;
		}
	}

	@Override
	public Value get(Key key) {
		int r = rank(key);
		if (r < n && key.compareTo(keys[r]) == 0)
			return vals[r];
		return null;
	}

	@Override
	public void delete(Key key) {
		put(key, null);
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		int i, size = 0;
		for (i = 0; i < n; i++)
			if (vals[i] != null)
				size++;
		return size;
	}

	@Override
	public Iterable<Key> keys() {
		List<Key> list = new ArrayList<>();
		int i;
		for (i = 0; i < n; i++)
			if (vals[i] != null)
				list.add(keys[i]);
		return list;
	}

	@Override
	public Key min() {
		if (!isEmpty())
			return keys[0];
		return null;
	}

	public Key max() {
		if (!isEmpty())
			return keys[n - 1];
		return null;
	}

	@Override
	public Key floor(Key key) {
		if (isEmpty())
			return null;

		int r = rank(key);
		int c = key.compareTo(keys[r]);
		if (key.compareTo(min()) < 0)
			return null;

		if (c == 0)
			return keys[r];
		else if (c < 0)
			return keys[r - 1];
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		if (isEmpty())
			return null;

		int r = rank(key);
		if (key.compareTo(max()) > 0)
			return null;
		return keys[r];
	}

	@Override
	public int rank(Key key) {
		if (key == null)
			return 0;
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
	public Key select(int k) {
		if (0 <= k && k < n)
			return keys[k];
		return null;
	}

	@Override
	public void deleteMin() {
		int i;
		for (i = 0; i < n - 1; i++)
			keys[i] = keys[i + 1];
		n--;

	}

	@Override
	public void deleteMax() {
		if (!isEmpty())
			n--;

	}

	@Override
	public int size(Key u, Key v) {

		Key min, max, floor_u, ceiling_v;
		int rank_u, rank_v, plus_low = 0, plus_high = 0;

		min = min();
		max = max();

		if (u.compareTo(max) > 0)
			return 0;
		if (v.compareTo(min) < 0)
			return 0;
		if (u.compareTo(min) <= 0)
			u = min;
		if (v.compareTo(max) >= 0)
			v = max;

		floor_u = floor(u);
		ceiling_v = ceiling(v);

		rank_u = rank(floor_u);
		rank_v = rank(ceiling_v);

		if (u.compareTo(floor_u) != 0)
			plus_low = 1;
		if (v.compareTo(ceiling_v) != 0)
			plus_high = 1;
		return (rank_v - rank_u + 1) - (plus_low + plus_high);
	}

	@Override
	public Iterable<Key> keys(Key u, Key v) {
		Key min, max, floor_v, ceiling_u;
		int rank_u, rank_v;

		min = min();
		max = max();

		if (u.compareTo(v) > 0)
			throw new NullPointerException();
		if (u.compareTo(max) > 0)
			throw new NullPointerException();
		if (v.compareTo(min) < 0)
			throw new NullPointerException();

		if (u.compareTo(min) <= 0)
			u = min;
		if (v.compareTo(max) >= 0)
			v = max;

		floor_v = floor(v);
		ceiling_u = ceiling(u);

		rank_v = rank(floor_v);
		rank_u = rank(ceiling_u);

		List<Key> list = new ArrayList<>();
		int i;
		for (i = rank_u; i <= rank_v; i++)
			list.add(keys[i]);
		return list;
	}

}
