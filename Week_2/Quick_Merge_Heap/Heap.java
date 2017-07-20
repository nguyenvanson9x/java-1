public class Heap<T extends Comparable<T>> {
	private T[] heap;
	private int n, default_size = 10;

	public Heap() {
		// TODO Auto-generated constructor stub
		heap = (T[]) new Comparable[default_size];
		n = 0;
		heap[0] = null;
	}

	public Heap(int cap) {
		heap = (T[]) new Comparable[cap];
		n = 0;
		heap[0] = null;
	}

	public void insert(T element) {
		if (n + 1 >= heap.length)
			resize(n + 1);
		heap[++n] = element;
		upheap(n);
	}

	private void resize(int n) {
		T[] temp = (T[]) new Comparable[2 * n];
		int i;
		for (i = 0; i < n; i++)
			temp[i] = heap[i];
		heap = temp;
	}

	private void upheap(int k) {
		while (k > 1 && heap[k].compareTo(heap[k / 2]) > 0) {
			swap(k, k / 2);
			k = k / 2;
		}
	}

	private void swap(int i, int j) {
		T temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public T max() {
		T data = null;
		if (!isEmpty())
			data = heap[1];

		return data;
	}

	public T deleteMax() {
		T data = heap[1];
		swap(1, n--);
		downheap(1, n);
		return data;
	}

	private void downheap(int k, int n) {
		while (2 * k <= n) {
			int i = 2 * k;
			if (i < n && heap[i].compareTo(heap[i + 1]) < 0)
				i++;
			if (heap[k].compareTo(heap[i]) > 0)
				break;
			swap(i, k);
			k = i;
		}
	}
	
	public void sort() {
		int k = n;
		while (k > 1) {
			swap(1, k--);
			downheap(1, k);
		}
	}

	public void print() {
		if (!isEmpty()) {
			int i;
			for (i = 1; i <= n; i++)
				System.out.print(heap[i].toString() + " ");
		}
	}
}
