import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Board {
	private int[][] board;
	private int n;

	public Board(int[][] blocks) {
		int i, j;
		n = blocks.length;
		board = new int[n][n];
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				board[i][j] = blocks[i][j];
	}

	public int dimension() {
		return n;
	}

	public int manhattan() {
		int i, j, man = 0;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				man += Math.abs((board[i][j] - 1) / n - i) + Math.abs((board[i][j] - 1) % n - j);

		return man;
	}

	public boolean isGoal() {
		int i, j;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				if (board[i][j] != (n * i + j + 1) % (n * n))
					return false;
		return true;
	}

	public Board twin() {
		Random r = new Random();
		int col, row1, row2;
		col = r.nextInt(n);
		row1 = r.nextInt(n);

		row1 = row1 % n;
		row2 = row1 + 1;
		row2 = row2 % n;

		int[][] clone = clone_arr(board);
		swap(clone, row1, col, row2, col);

		return new Board(clone);
	}

	public boolean equals(Object y) {
		if (y == null)
			return false;
		if (y.getClass() != this.getClass())
			return false;

		Board o = (Board) y;
		if (o.toString().equals(this.toString()))
			return true;

		return false;
	}

	public Iterable<Board> neighbors() {
		return new Neighbors();
	}

	public String toString() {
		String s = "";
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				s = s + board[i][j] + " ";
			s += "\n";
		}
		return s;

	}

	public int[][] clone_arr(int[][] src) {
		int i, j, size;
		size = src.length;
		int[][] clone = new int[size][size];

		for (i = 0; i < size; i++)
			for (j = 0; j < size; j++)
				clone[i][j] = src[i][j];

		return clone;
	}

	private void swap(int[][] a, int i, int j, int u, int v) {
		int temp = a[i][j];
		a[i][j] = a[u][v];
		a[u][v] = temp;
	}

	class Neighbors implements Iterable<Board> {

		@Override
		public Iterator<Board> iterator() {
			return new NeighborsIterator();
		}
	}

	class NeighborsIterator implements Iterator<Board> {
		private ArrayList<Board> neig;
		private int index;

		public NeighborsIterator() {
			int i, j;
			neig = new ArrayList<>();
			index = 0;
			for (i = 0; i < n; i++)
				for (j = 0; j < n; j++) {
					if (board[i][j] == 0) {
						if (i >= 1) {
							int[][] clone = clone_arr(board);
							swap(clone, i, j, i - 1, j);
							neig.add(new Board(clone));
						}
						if (i < n - 1) {
							int[][] clone = clone_arr(board);
							swap(clone, i, j, i + 1, j);
							neig.add(new Board(clone));
						}
						if (j >= 1) {
							int[][] clone = clone_arr(board);
							swap(clone, i, j, i, j - 1);
							neig.add(new Board(clone));
						}
						if (j < n - 1) {
							int[][] clone = clone_arr(board);
							swap(clone, i, j, i, j + 1);
							neig.add(new Board(clone));
						}
					}
				}
		}

		@Override
		public boolean hasNext() {
			return index < neig.size();
		}

		@Override
		public Board next() {
			return neig.get(index++);
		}

		public void remove() {

		}
	}
}
