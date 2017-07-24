public class Ordered_PriorityQueue_LinkList<Key extends Comparable<Key>>
		implements MaxPriorityQueue<Key> {
	class Node {
		Key element;
		Node next;
	}

	private Node q;
	private int n;

	public Ordered_PriorityQueue_LinkList() {
		// TODO Auto-generated constructor stub
		q = null;
		n = 0;
	}

	@Override
	public void insert(Key v) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.element = v;
		if (isEmpty() || v.compareTo(q.element) >= 0) {
			node.next = q;
			q = node;
		} else {
			Node p = q;
			while (p.next != null && p.next.element.compareTo(v) > 0)
				p = p.next;
			Node p_next = p.next;
			p.next = node;
			node.next = p_next;
		}
		n++;

	}

	@Override
	public Key deleteMax() {
		// TODO Auto-generated method stub
		Key max = null;
		if (!isEmpty()) {
			max = q.element;
			q = q.next;
			n--;
		}
		return max;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		Key max = null;
		if (!isEmpty())
			max = q.element;
		return max;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	public void print() {
		Node p = q;
		while (p != null) {
			System.out.print(p.element.toString() + " ");
			p = p.next;
		}
	}
}
