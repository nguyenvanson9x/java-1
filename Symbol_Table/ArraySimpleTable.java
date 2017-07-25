import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySimpleTable<Key extends Comparable<Key>, Value> extends
		AbstractSimpleTable<Key, Value> {
	private Key[] keys;
	private Value[] vals;
	private int n = 0, default_size = 10;

	@SuppressWarnings("unchecked")
	public ArraySimpleTable() {
		keys = (Key[]) new Comparable[default_size];
		vals = (Value[]) new Object[default_size];
	}

	@SuppressWarnings("unchecked")
	public ArraySimpleTable(int cap) {
		keys = (Key[]) new Comparable[cap];
		vals = (Value[]) new Object[cap];
	}

	@Override
	public void put(Key key, Value value) {
		if (n >= keys.length) {
			keys = Arrays.copyOf(keys, 2 * n);
			vals = Arrays.copyOf(vals, 2 * n);
		}
		int i, index = -1;
		for (i = 0; i < n; i++)
			if (keys[i].compareTo(key) == 0)
				index = i;
		if (index == -1) {
			keys[n] = key;
			vals[n] = value;
			n++;
		} else
			vals[index] = value;
	}

	@Override
	public Value get(Key key) {
		int i;
		for (i = 0; i < n; i++)
			if (keys[i].compareTo(key) == 0)
				return vals[i];
		return null;
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
		List<Key> list = new ArrayList<Key>();
		int i;
		for (i = 0; i < n; i++)
			if (vals[i] != null)
				list.add(keys[i]);
		return list;
	}

}
