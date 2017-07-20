public class Utils {
	public void merge_sort(int[] a) {
		int[] b = new int[a.length];
		_merge_sort(a, b, 0, a.length - 1);
	}

	private void _merge_sort(int[] a, int[] b, int u, int v) {
		if (u < v) {
			int m = u + (v - u) / 2;
			_merge_sort(a, b, u, m);
			_merge_sort(a, b, m + 1, v);
			merge(a, b, u, m, v);
		}
	}

	private void merge(int[] a, int[] b, int u, int m, int v) {
		int i, j, k;
		for (k = u; k <= v; k++)
			b[k] = a[k];

		i = u;
		j = m + 1;
		for (k = u; k <= v; k++) {
			if (i > m)
				a[k] = b[j++];
			else if (j > v)
				a[k] = b[i++];
			else if (b[j] < b[i])
				a[k] = b[j++];
			else
				a[k] = b[i++];
		}
	}

	public void quick_sort(int[] a) {
		_quick_sort(a, 0, a.length - 1);
	}

	private void _quick_sort(int[] a, int u, int v) {
		int i, j, m;
		i = u;
		j = v;
		m = a[u + (v - u) / 2];

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
		if (u < j)
			_quick_sort(a, u, j);
		if (v > i)
			_quick_sort(a, i, v);
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
