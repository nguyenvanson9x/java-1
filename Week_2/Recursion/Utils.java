public class Utils {
	private int count = 0;
	private int[] a, B;
	private int[][] R;

	public int giai_thua(int n) {
		if (n <= 1)
			return 1;
		else
			return n * giai_thua(n - 1);
	}

	public int giai_thua_kep(int n) {
		if (n <= 1)
			return 1;
		else if (n == 2)
			return 2;
		else
			return n * giai_thua_kep(n - 2);
	}

	public int fibonacy(int n) {
		if (n < 2)
			return n;
		else
			return fibonacy(n - 1) + fibonacy(n - 2);
	}

	public void HaNoi_Tower(int n) {
		move(n, "A", "B", "C");
	}

	private void move(int n, String A, String B, String C) {
		if (n == 1) {
			System.out.println(A + " -> " + B);
			count++;
		} else {
			move(n - 1, A, C, B);
			move(1, A, B, C);
			move(n - 1, C, B, A);
		}

	}

	public void count() {
		System.out.println("Count HN: " + count);
	}

	public void nhi_phan(int n) {
		a = new int[n];
		nhi_phan(0, n);
	}

	private void nhi_phan(int index, int n) {
		int i;
		for (i = 0; i <= 1; i++) {
			a[index] = i;
			if (index == n - 1)
				ket_qua(a);
			else
				nhi_phan(index + 1, n);
		}
	}

	private void ket_qua(int[] a) {
		int i;
		for (i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public void tap_con(int[] A) {
		B = new int[A.length];
		tap_con(A, 0);
	}

	private void tap_con(int[] A, int index) {
		int n = A.length;
		int i;
		for (i = 0; i <= 1; i++) {
			B[index] = i;
			if (index == n - 1)
				ket_qua_2(A, B);
			else
				tap_con(A, index + 1);
		}
	}

	private void ket_qua_2(int[] A, int[] b2) {
		// TODO Auto-generated method stub
		int i, n = b2.length;
		for (i = 0; i < n; i++) {
			if (b2[i] != 0)
				System.out.print(A[i] + " ");
		}
		System.out.println();

	}

	public void robot(int n) {
		R = new int[n][n];
		System.out.println(_robot(1, 1, n, n));
	}

	private int _robot(int u, int v, int m, int n) {
		if (u == m || v == n)
			return 1;
		else {
			// if (u == m && v < n)
			// return 1 + _robot(u, v + 1, m, n);
			// if (u < m && v == n)
			// return 1 + _robot(u + 1, v, m, n);
			return _robot(u + 1, v, m, n) + _robot(u, v + 1, m, n);
		}
	}

	public void sort(int[] a) {
		ket_qua(a);
		_sort(a, 0, a.length - 1);
		ket_qua(a);
	}

	private void _sort(int[] a, int u, int v) {
		int i, j, m;
		i = u;
		j = v;
		m = a[u + (v - u) / 2];
		System.out.println("value: " + m + ", index: " + (u + (v - u) / 2));
		while (i <= j) {
			while (a[i] < m)
				i++;
			while (a[j] > m)
				j--;
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public int[] create_array(int[] a, int[] b) {
		ket_qua(_merge(a, b));
		return _merge(a, b);
	}

	private int[] _merge(int[] a, int[] b) {
		int i = 0, j = 0, k, n, m;
		int[] c;
		m = a.length;
		n = b.length;
		c = new int[m + n];

		for (k = 0; k < m + n; k++) {
			if (i < m && j < n) {
				if (a[i] < b[j])
					c[k] = a[i++];
				else
					c[k] = b[j++];
			} else {
				if (i == m)
					c[k] = b[j++];
				else if (j == n)
					c[k] = a[i++];
			}
		}
		return c;
	}
}
