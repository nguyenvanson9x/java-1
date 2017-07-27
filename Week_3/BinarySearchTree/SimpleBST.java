import java.util.Iterator;
import java.util.Stack;

public class SimpleBST<Key extends Comparable<Key>> implements
		SimpleBTreeInterface<Key> {
	class Node {
		Key key;
		Node left, right;
		int count;

		public Node(Key k) {
			this.key = k;
			this.count = 1;
		}
	}

	private Node root;
	private int n = 0;

	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return new SimpleBST_Iterator();
	}

	@Override
	public void insert(Key k) {
		// TODO Auto-generated method stub
		root = _insert(root, k);
		n++;
	}

	private Node _insert(Node node, Key k) {
		if (node == null)
			node = new Node(k);
		int c = k.compareTo(node.key);
		if (c < 0)
			node.left = _insert(node.left, k);
		else if (c > 0)
			node.right = _insert(node.right, k);
		else
			node.key = k;
		return node;
	}

	@Override
	public boolean search(Key k) {
		// TODO Auto-generated method stub
		if (root == null)
			return false;
		Node p = root;
		while (p != null) {
			int c = k.compareTo(p.key);
			if (c < 0)
				p = p.left;
			else if (c > 0)
				p = p.right;
			else
				return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}

	class SimpleBST_Iterator implements Iterator<Key> {
		private Stack<Key> q;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public SimpleBST_Iterator() {
			// TODO Auto-generated constructor stub
			q = new Stack();
			inorder(root);
		}

		private void inorder(Node node) {
			if (node != null) {
				inorder(node.left);
				q.push(node.key);
				inorder(node.right);
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !q.isEmpty();
		}

		@Override
		public Key next() {
			// TODO Auto-generated method stub
			return q.pop();
		}

	}

}
