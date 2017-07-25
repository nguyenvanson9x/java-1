public abstract class AbstractSimpleTable<Key extends Comparable<Key>, Value>
		implements SimpleTable<Key, Value> {
	public boolean contains(Key key) {
		return get(key) != null;
	}

	public void delete(Key key) {
		put(key, null);
	}
}
