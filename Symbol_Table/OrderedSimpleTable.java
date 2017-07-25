public interface OrderedSimpleTable<Key extends Comparable<Key>, Value> extends
		SimpleTable<Key, Value> {
	Key min();// Khóa nhỏ nhất

	Key max();// Khóa lớn nhất

	Key floor(Key key);// Khóa lớn nhất mà nhỏ hơn hoặc bằng key (cận
	// dưới)

	Key ceiling(Key key);// Khóa nhỏ nhất mà lớn hơn hoặc bằng key
	// (cận trên)

	int rank(Key key);// Số lượng khóa nhỏ hơn key

	Key select(int k);// Khóa tương ứng với rank(k)

	void deleteMin();// Xóa khóa nhỏ nhất

	void deleteMax();// xóa khóa lớn nhất

	int size(Key u, Key v);// số lượng key nằm trong khoảng từ u đến v

	Iterable<Key> keys(Key u, Key v);// Đưa ra các key có giá trị
	// trong khoảng từ u đến v
}
