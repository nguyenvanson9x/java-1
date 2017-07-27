public interface SimpleBTreeInterface<Key extends Comparable<Key>>
		extends Iterable<Key> {
	public void insert(Key k);

	public boolean search(Key k);

	public int size();

	public boolean isEmpty();
}
