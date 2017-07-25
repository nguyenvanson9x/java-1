public class BinarySearch {
	public int bsearch(int[] a, int x) {
		int u = 0;
		int v = a.length - 1;
		while (u <= v) {
			int m = u + (v - u) / 2;
			int c = x - a[m];
			if (c < 0)
				v = m - 1;
			else if (c > 0)
				u = m + 1;
			else
				return m;
		}
		return -1;
	}
}
