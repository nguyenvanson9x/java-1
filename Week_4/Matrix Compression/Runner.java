public class Runner {
	public static void main(String[] args) {
		MatrixCompression mc = new MatrixCompression();
		int[][] matrix = { { 0, 0, 0, 1 }, { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 0, 1, 1 } };
		int[] comp = mc.compress(matrix);
		int[][] decomp = mc.decompress(comp);
		for (int i = 0; i < decomp.length; i++) {
			for (int j = 0; j < decomp.length; j++)
				System.out.print(decomp[i][j] + " ");
			System.out.println();
		}
	}
}
