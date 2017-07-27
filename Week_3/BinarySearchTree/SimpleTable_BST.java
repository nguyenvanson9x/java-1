import java.util.ArrayList;
import java.util.List;

public class SimpleTable_BST<Key extends Comparable<Key>, Value> extends
		AbstractSimpleTable<Key, Value> {
	class Node {
		Key key;
		Value val;
		Node left, right;
		int count;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(Key k, Value v) {
			this.key = k;
			this.val = v;
			this.count = 1;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	@Override
	public void put(Key key, Value value) {
		// TODO Auto-generated method stub
		root = _put(root, key, value);
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

	private int size(Node node) {
		if (node == null)
			return 0;
		return node.count;
	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
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
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size(root);
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		List<Key> l = new ArrayList<>();
		inorder(root, l);
		return l;
	}

	private void inorder(Node node, List<Key> l) {
		if (node != null) {
			inorder(node.left, l);
			if (node.val != null)
				l.add(node.key);
			inorder(node.right, l);
		}
	}

}
