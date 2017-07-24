import java.util.Arrays;

public class Ordered_PriorityQueue<Key extends Comparable<Key>> implements
		MaxPriorityQueue<Key> {
	private Key[] q;
	private int n, default_size = 10;

	public Ordered_PriorityQueue() {
		// TODO Auto-generated constructor stub
		q = (Key[]) new Comparable[default_size];
		n = 0;
	}

	public Ordered_PriorityQueue(int cap) {
		q = (Key[]) new Comparable[cap];
		n = 0;
	}

	@Override
	public void insert(Key v) {
		// TODO Auto-generated method stub
		int r = rank(v);
		int i;
		n++;
		if (n >= q.length)
			q = Arrays.copyOf(q, 2 * n);
		for (i = n - 1; i > r; i--)
			q[i] = q[i - 1];
		q[r] = v;

	}

	private int rank(Key k) {
		int u = 0;
		int v = n - 1;

		while (u <= v) {
			int m = u + (v - u) / 2;
			int c = k.compareTo(q[m]);
			if (c < 0)
				v = m - 1;
			else if (c > 0)
				u = m + 1;
			else
				return m;
		}
		return u;
	}

	@Override
	public Key deleteMax() {
		// TODO Auto-generated method stub
		Key data = q[n - 1];
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
		return q[n - 1];
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
