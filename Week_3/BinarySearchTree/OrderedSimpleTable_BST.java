import java.util.ArrayList;
import java.util.List;

public class OrderedSimpleTable_BST<Key extends Comparable<Key>, Value>
		implements OrderedSimpleTable<Key, Value> {
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
		put(key, null);

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
		return null;
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
		return 0;
	}

	@Override
	public Iterable<Key> keys(Key u, Key v) {
		return null;
	}

}
