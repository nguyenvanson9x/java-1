import java.util.Arrays;

public class Unordered_PriorityQueue<Key extends Comparable<Key>> implements
		MaxPriorityQueue<Key> {
	private Key[] q;
	private int n, default_size = 10;

	public Unordered_PriorityQueue() {
		// TODO Auto-generated constructor stub
		q = (Key[]) new Comparable[default_size];
		n = 0;
	}

	public Unordered_PriorityQueue(int cap) {
		q = (Key[]) new Comparable[cap];
		n = 0;
	}

	@Override
	public void insert(Key v) {
		// TODO Auto-generated method stub
		if (n >= q.length)
			q = Arrays.copyOf(q, 2 * n);
		q[n++] = v;
	}

	@Override
	public Key deleteMax() {
		// TODO Auto-generated method stub
		int index_max = index_max();
		Key data = q[index_max];
		int i;
		for (i = index_max; i < n; i++)
			q[i] = q[i + 1];
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
		return q[index_max()];
	}

	private int index_max() {
		int j, i = 0;
		for (j = 0; j < n; j++)
			if (q[j].compareTo(q[i]) >= 0)
				i = j;
		return i;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	public void print() {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(q[i].toString() + " ");
	}

}
