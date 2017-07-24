public class Unordered_PriorityQueue_LinkList<Key extends Comparable<Key>>
		implements MaxPriorityQueue<Key> {
	class Node {
		Key element;
		Node next;
	}

	private Node q;
	private int n;

	public Unordered_PriorityQueue_LinkList() {
		// TODO Auto-generated constructor stub
		n = 0;
		q = null;
	}

	@Override
	public void insert(Key v) {
		// TODO Auto-generated method stub
		Node p = new Node();
		p.element = v;
		p.next = q;
		q = p;
		n++;
	}

	@Override
	public Key deleteMax() {
		// TODO Auto-generated method stub
		Key max = max();
		Node p = q;
		while (p.next.element.compareTo(max) != 0) {
			p = p.next;
		}
		p.next = p.next.next;
		n--;
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
		Node p = q;
		Key max = q.element;
		while (p != null) {
			if (p.element.compareTo(max) >= 0)
				max = p.element;
			p = p.next;
		}
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
