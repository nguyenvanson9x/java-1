import java.util.ArrayList;

public class MatrixCompression {
	public int length(int[][] matrix) {
		int[] arr = ex_arr(matrix);
		int n = matrix.length;
		int l = 0, j, i = 0;
		while (i < n * n - 1) {
			j = i;
			while (j < n * n && arr[j] == arr[i]) {
				j++;
			}
			l++;
			i = j;
		}
		return 2 * l;
	}

	public int[] compress(int[][] matrix) {
		int[] arr = ex_arr(matrix);
		int[] out = new int[length(matrix)];
		System.out.println(out.length);
		int index = 0;
		int n = matrix.length;
		int c, j, i = 0;
		while (i < n * n - 1) {
			j = i;
			c = 0;
			out[index++] = arr[i];
			while (j < n * n && arr[j] == arr[i]) {
				c++;
				j++;
			}
			out[index++] = c;
			i = j;
		}
		return out;
	}

	private int[] ex_arr(int[][] matrix) {
		int n = matrix.length;
		int i, j;
		int[] a = new int[n * n];
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				a[n * i + j] = matrix[i][j];
		return a;
	}

	public int[][] decompress(int[] compressed) {
		int i, j, N, n;
		int[][] matrix;
		ArrayList<Integer> a = new ArrayList<>();

		N = 0;
		n = compressed.length;

		for (i = 1; i < n; i = i + 2)
			N += compressed[i];

		N = (int) Math.sqrt(N + 1);
		matrix = new int[N][N];

		for (i = 1; i < n; i = i + 2) {
			int l = compressed[i];
			for (j = 0; j < l; j++)
				a.add(compressed[i - 1]);
		}
		for (i = 0; i < N; i++)
			for (j = 0; j < N; j++)
				matrix[i][j] = a.get(N * i + j);
		return matrix;
	}
}
