import java.util.ArrayList;
import java.util.List;

public class OrderedSimpleTable_BST<Key extends Comparable<Key>, Value> implements OrderedSimpleTable<Key, Value> {
	class Node {
		Key key;
		Value val;
		Node left, right;
		private int count;

		public Node() {
		}

		public Node(Key k, Value v) {
			this.key = k;
			this.val = v;
			this.count = 1;
		}
	}

	private Node root;
	private int n = 0;

	@Override
	public void put(Key key, Value value) {
		root = _put(root, key, value);
		n++;
	}

	private Node _put(Node node, Key k, Value v) {
		if (node == null)
			return new Node(k, v);
		int c = k.compareTo(node.key);
		if (c < 0)
			node.left = _put(node.left, k, v);
		else if (c > 0)
			node.right = _put(node.right, k, v);
		else
			node.val = v;
		node.count = 1 + size(node.left) + size(node.right);
		return node;
	}

	@Override
	public Value get(Key key) {
		if (isEmpty())
			return null;
		Node p = root;
		while (p != null) {
			int c = key.compareTo(p.key);
			if (c < 0)
				p = p.left;
			else if (c > 0)
				p = p.right;
			else
				return p.val;
		}
		return null;
	}

	@Override
	public void delete(Key key) {
		root = _delete(root, key);

	}

	private Node _delete(Node node, Key key) {
		if (node == null)
			return null;
		int c = key.compareTo(node.key);
		if (c < 0)
			node.left = _delete(node.left, key);
		else if (c > 0)
			node.right = _delete(node.right, key);
		else {
			Node p = node;
			if (node.left == null)
				node = node.right;
			else if (node.right == null)
				node = node.left;
			else {
				Node s = node;
				Node Q = s.left;
				while (Q.right != null) {
					s = Q;
					Q = Q.right;
				}
				p.key = Q.key;
				p.val = Q.val;
				s.right = Q.left;
			}
		}
		return node;
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		return node.count;
	}

	@Override
	public Iterable<Key> keys() {
		List<Key> l = new ArrayList<>();
		inorder(root, l);
		return l;
	}

	private void inorder(Node node, List<Key> l) {
		if (node != null) {
			inorder(node.left, l);
			l.add(node.key);
			inorder(node.right, l);
		}
	}

	@Override
	public Key min() {
		if (isEmpty())
			return null;
		Node p = root;
		while (p.left != null)
			p = p.left;
		return p.key;
	}

	@Override
	public Key max() {
		if (isEmpty())
			return null;
		Node p = root;
		while (p.right != null)
			p = p.right;
		return p.key;
	}

	@Override
	public Key floor(Key key) {
		Node node = floor(root, key);
		if (node == null)
			return null;
		return node.key;
	}

	private Node floor(Node node, Key key) {
		if (node == null)
			return null;
		int c = key.compareTo(node.key);
		if (c == 0)
			return node;
		if (c < 0)
			return floor(node.left, key);
		Node p = floor(node.right, key);
		if (p != null)
			return p;
		else
			return node;
	}

	@Override
	public Key ceiling(Key key) {
		Node node = ceiling(root, key);
		if (node == null)
			return null;
		return node.key;
	}

	private Node ceiling(Node node, Key key) {
		if (node == null)
			return null;
		int c = key.compareTo(node.key);
		if (c == 0)
			return node;
		if (c < 0) {
			Node t = ceiling(node.left, key);
			if (t != null)
				return t;
			else
				return node;
		}
		return ceiling(node.right, key);
	}

	@Override
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node node) {
		if (node == null)
			return 0;
		int c = key.compareTo(node.key);
		if (c < 0)
			return rank(key, node.left);
		else if (c > 0)
			return 1 + size(node.left) + rank(key, node.right);
		else
			return size(node.left);
	}

	@Override
	public Key select(int k) {
		Node node = _select(root, k);
		if (node != null)
			return node.key;
		return null;
	}

	private Node _select(Node node, int k) {
		if (node != null) {
			int c = k - rank(node.key);
			if (c == 0)
				return node;
			else if (c > 0)
				node = _select(node.right, k);
			else
				node = _select(node.left, k);
		}
		return node;
	}

	@Override
	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node node) {
		if (node.left == null)
			return node.right;
		node.left = deleteMin(node.left);
		node.count = 1 + size(node.left) + size(node.right);
		return node;
	}

	@Override
	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node node) {
		if (node.right == null)
			return node.left;
		node.right = deleteMax(node.right);
		node.count = 1 + size(node.left) + size(node.right);
		return node;
	}

	@Override
	public int size(Key u, Key v) {
		return _size(root, u, v);
	}

	private int _size(Node node, Key u, Key v) {
		if (node != null) {
			int sizeL = _size(node.left, u, v);
			int sizeR = _size(node.right, u, v);
			if (u.compareTo(node.key) <= 0 && node.key.compareTo(v) <= 0)
				return 1 + sizeL + sizeR;
			return sizeL + sizeR;
		}
		return 0;
	}

	@Override
	public Iterable<Key> keys(Key u, Key v) {
		return keys_between(u, v);
	}

	// chiều cao của cây
	public int depth() {
		return _depth(root);
	}

	private int _depth(Node node) {
		if (node == null)
			return 0;
		int d_left = _depth(node.left);
		int d_right = _depth(node.right);
		return 1 + (d_left > d_right ? d_left : d_right);
	}

	// xuất các key có giá trị chẵn
	public Iterable<Key> keys_even() {
		List<Key> l = new ArrayList<>();
		_keys_even(root, l);
		return l;
	}

	private void _keys_even(Node node, List<Key> l) {
		if (node != null) {
			_keys_even(node.left, l);
			if ((Integer) node.key % 2 == 0)
				l.add(node.key);
			_keys_even(node.right, l);
		}
	}

	// xuất các key có giá trị nằm trong đoạn [u, v]
	public Iterable<Key> keys_between(Key u, Key v) {
		List<Key> l = new ArrayList<>();
		_keys_between(root, u, v, l);
		return l;
	}

	private void _keys_between(Node node, Key u, Key v, List<Key> l) {
		if (node != null) {
			_keys_between(node.left, u, v, l);
			if (u.compareTo(node.key) <= 0 && node.key.compareTo(v) <= 0)
				l.add(node.key);
			_keys_between(node.right, u, v, l);
		}
	}

	// xuất các key nằm trên tầng thứ K của cây
	public Iterable<Key> keys_level(int k) {
		List<Key> l = new ArrayList<>();
		_keys_level(root, k, l);
		return l;
	}

	private void _keys_level(Node node, int k, List<Key> l) {
		if (node != null) {
			k--;
			_keys_level(node.left, k, l);
			if (k == 0)
				l.add(node.key);
			_keys_level(node.right, k, l);
		}
	}

	// xuất tất cả các nút trên cây theo thứ tự từ tầng 0 đến tầng h-1 của cây (với
	// h là chiều cao của cây)
	public Iterable<Key> keys_all_level() {
		List<Key> l = new ArrayList<>();
		int depth = depth();
		_keys_all_level(depth, root, l);
		return l;
	}

	private void _keys_all_level(int depth, Node node, List<Key> l) {
		int i;
		for (i = 0; i < depth; i++)
			_keys_level(node, i + 1, l);
	}

	// xuất các nút có đúng 1 con
	public Iterable<Key> keys_only_one_child() {
		List<Key> l = new ArrayList<>();
		_keys_only_one_child(root, l);
		return l;
	}

	private void _keys_only_one_child(Node node, List<Key> l) {
		if (node != null) {
			_keys_only_one_child(node.left, l);
			_keys_only_one_child(node.right, l);
			if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
				l.add(node.key);
		}
	}

	// Đếm số lượng nút có đúng 1 con
	public int count_key_only_one_child() {
		return _count_key_only_one_child(root);
	}

	private int _count_key_only_one_child(Node node) {
		if (node != null) {
			int c_left = _count_key_only_one_child(node.left);
			int c_right = _count_key_only_one_child(node.right);
			if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
				return 1 + c_left + c_right;
			return c_left + c_right;
		}
		return 0;
	}

	// Đếm số lượng nút có đúng 2 con
	public int count_key_have_two_child() {
		return _count_key_have_two_child(root);
	}

	private int _count_key_have_two_child(Node node) {
		if (node != null) {
			int c_left = _count_key_have_two_child(node.left);
			int c_right = _count_key_have_two_child(node.right);
			if (node.left != null && node.right != null)
				return 1 + c_left + c_right;
			return c_left + c_right;
		}
		return 0;
	}

	// Nút có đúng hai con
	public Iterable<Key> keys_have_two_child() {
		List<Key> l = new ArrayList<>();
		_keys_have_two_child(root, l);
		return l;
	}

	private void _keys_have_two_child(Node node, List<Key> l) {
		if (node != null) {
			_keys_have_two_child(node.left, l);
			if (node.left != null && node.right != null)
				l.add(node.key);
			_keys_have_two_child(node.right, l);
		}
	}

	// Đếm số lượng nút có key chẵn
	public int count_even_key() {
		return _count_even_key(root);
	}

	private int _count_even_key(Node node) {
		if (node != null) {
			int c_left = _count_even_key(node.left);
			int c_right = _count_even_key(node.right);
			if ((Integer) node.key % 2 == 0)
				return 1 + c_left + c_right;
			return c_left + c_right;
		}
		return 0;
	}

	// Đếm số lượng nút lá mà Key của nút đó là giá trị chẵn
	public int count_even_leaf() {
		return _count_even_leaf(root);
	}

	private int _count_even_leaf(Node node) {
		if (node != null) {
			int c_left = _count_even_leaf(node.left);
			int c_right = _count_even_leaf(node.right);
			if (node.left == null && node.right == null && (Integer) node.key % 2 == 0)
				return 1 + c_left + c_right;
			return c_left + c_right;
		}
		return 0;
	}

	// Xuất các lá có Key chẵn
	public Iterable<Key> even_leaf() {
		List<Key> l = new ArrayList<>();
		_even_leaf(root, l);
		return l;
	}

	private void _even_leaf(Node node, List<Key> l) {
		if (node != null) {
			_even_leaf(node.left, l);
			if (node.left == null && node.right == null && (Integer) node.key % 2 == 0)
				l.add(node.key);
			_even_leaf(node.right, l);
		}
	}

	// Đếm số lượng nút trên tầng thứ k của cây
	public int count_level(int k) {
		return _count_level(root, k);
	}

	private int _count_level(Node node, int k) {
		if (node != null) {
			k--;
			int c_left = _count_level(node.left, k);
			int c_right = _count_level(node.right, k);
			if (k == 0)
				return 1 + c_left + c_right;
			return c_left + c_right;
		}
		return 0;
	}

	// tổng các Key trong cây
	public int sum_keys() {
		return _sum_keys(root);
	}

	private int _sum_keys(Node node) {
		if (node != null) {
			int sum_left = _sum_keys(node.left);
			int sum_right = _sum_keys(node.right);
			return (Integer) node.key + sum_left + sum_right;
		}
		return 0;
	}

	// tổng các Key ở nút lá
	public int sum_leaf() {
		return _sum_leaf(root);
	}

	private int _sum_leaf(Node node) {
		if (node != null) {
			int sum_left = _sum_leaf(node.left);
			int sum_right = _sum_leaf(node.right);
			if (node.left == null && node.right == null)
				return (Integer) node.key + sum_left + sum_right;
			return sum_left + sum_right;
		}
		return 0;
	}

	// tổng Key ở các nút có đúng một con
	public int sum_keys_one_child() {
		return _sum_keys_one_child(root);
	}

	private int _sum_keys_one_child(Node node) {
		if (node != null) {
			int sum_left = _sum_keys_one_child(node.left);
			int sum_right = _sum_keys_one_child(node.right);
			if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
				return (Integer) node.key + sum_left + sum_right;
			return sum_left + sum_right;
		}
		return 0;
	}

	// Kiểm tra cây nhị phân T có phải là "cây nhị phân tìm kiếm" hay không?
	public int is_BST() {
		return _is_BST(root);
	}

	private int _is_BST(Node node) {
		if (node == null)
			return 0;
		int check_left = _is_BST(node.left);

		int maxL, maxR;
		if (node.left != null && node.right != null) {
			maxL = max_key(node.left);
			maxR = max_key(node.right);
			if (!(maxL < (Integer) node.key && (Integer) node.key < maxR))
				return 1;
		}
		if (node.left != null && node.right == null) {
			maxL = max_key(node.left);
			if (!(maxL < (Integer) node.key))
				return 1;
		}
		if (node.left == null && node.right != null) {
			maxR = max_key(node.right);
			if (!(maxR > (Integer) node.key))
				return 1;
		}

		int check_right = _is_BST(node.right);
		return check_left + check_right;
	}

	public int max_key(Node node) {
		int max = -Integer.MAX_VALUE, max_L, max_R;
		if (node != null) {
			max = (Integer) node.key;
			max_L = max_key(node.left);
			max_R = max_key(node.right);
			if (max_L > max)
				max = max_L;
			if (max_R > max)
				max = max_R;
		}
		return max;
	}

	// Kiểm tra cây nhị phân T có phải là "cây nhị phân cân bằng" hay không?
	// Cây nhị phân cân bằng là cây nhị phân tìm kiếm mà tại mỗi nút của nó
	// độ cao của cây con trái và cây con phải chêch lệch ko quá 1
	public int is_blanched_BST() {
		return _is_blanched_BST(root);
	}

	private int _is_blanched_BST(Node node) {
		if (node == null)
			return 0;
		int check_left = _is_blanched_BST(node.left);

		int maxL, maxR;
		if (node.left != null && node.right != null) {
			maxL = max_key(node.left);
			maxR = max_key(node.right);
			if (!(maxL < (Integer) node.key && (Integer) node.key < maxR))
				return 1;
		}
		if (node.left != null && node.right == null) {
			maxL = max_key(node.left);
			if (!(maxL < (Integer) node.key))
				return 1;
		}
		if (node.left == null && node.right != null) {
			maxR = max_key(node.right);
			if (!(maxR > (Integer) node.key))
				return 1;
		}

		int depth_left = _depth(node.left);
		int depth_right = _depth(node.right);
		if (Math.abs(depth_left - depth_right) > 1)
			return 1;

		int check_right = _is_blanched_BST(node.right);
		return check_left + check_right;
	}

	// Kiểm tra cây nhị phân T có phải là "cây nhị phân cân bằng hoàn toàn" hay
	// không?
	// cây nhị phân cân bằng hoàn toàn là cây nhị phân tìm kiếm mà tại mỗi nút của
	// nó, số nút của cây con trái và cây con phải chêch lệch ko quá 1
	public int is_completely_balanced_BST() {
		return _is_completely_balanced_BST(root);
	}

	private int _is_completely_balanced_BST(Node node) {
		if (node == null)
			return 0;
		int check_left = _is_completely_balanced_BST(node.left);

		int maxL, maxR;
		if (node.left != null && node.right != null) {
			maxL = max_key(node.left);
			maxR = max_key(node.right);
			if (!(maxL < (Integer) node.key && (Integer) node.key < maxR))
				return 1;
		}
		if (node.left != null && node.right == null) {
			maxL = max_key(node.left);
			if (!(maxL < (Integer) node.key))
				return 1;
		}
		if (node.left == null && node.right != null) {
			maxR = max_key(node.right);
			if (!(maxR > (Integer) node.key))
				return 1;
		}

		int count_left = _count_keys(node.left);
		int count_right = _count_keys(node.right);
		if (Math.abs(count_left - count_right) > 1)
			return 1;

		int check_right = _is_completely_balanced_BST(node.right);
		return check_left + check_right;
	}

	private int _count_keys(Node node) {
		if (node == null)
			return 0;
		int c_left = _count_keys(node.left);
		int c_right = _count_keys(node.right);
		return 1 + c_left + c_right;
	}

	// tổng các Key có giá trị Key < K
	public int sum_keys_less_than(Key k) {
		return _sum_keys_less_than(root, k);
	}

	private int _sum_keys_less_than(Node node, Key k) {
		if (node != null) {
			int sumL = _sum_keys_less_than(node.left, k);
			int sumR = _sum_keys_less_than(node.right, k);
			if (node.key.compareTo(k) < 0)
				return (Integer) node.key + sumL + sumR;
			return sumL + sumR;
		}
		return 0;
	}

	// số node có key < K
	public int count_key_less_than(Key k) {
		return _count_key_less_than(root, k);
	}

	private int _count_key_less_than(Node node, Key k) {
		if (node != null) {
			int count_left = _count_key_less_than(node.left, k);
			int count_right = _count_key_less_than(node.right, k);
			if (node.key.compareTo(k) <= 0)
				return 1 + count_left + count_right;
			return count_left + count_right;
		}
		return 0;
	}

}