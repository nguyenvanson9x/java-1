public class PriorityQueue_Heap<Key extends Comparable<Key>> implements
		MaxPriorityQueue<Key> {
	private Heap<Key> q;
	private int n;

	public PriorityQueue_Heap() {
		// TODO Auto-generated constructor stub
		q = new Heap<>();
		n = 0;
	}

	@Override
	public void insert(Key v) {
		// TODO Auto-generated method stub
		q.insert(v);
		n++;
	}

	@Override
	public Key deleteMax() {
		// TODO Auto-generated method stub
		Key data = q.deleteMax();
		n--;
		return data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return q.max();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	
	public void print() {
		q.print();
	}

}
