import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solver {
	class Node implements Comparable<Node> {
		private Board board;
		private Node pre;
		private int move, priority;

		public Node(Node pre, Board b) {
			this.board = b;
			this.pre = pre;
			if (this.pre == null)
				move = 0;
			else
				move = this.pre.move + 1;
			priority = b.manhattan() + move;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.priority - o.priority;
		}
	}

	private Node start;

	public Solver(Board initial) {
		start = solve(initial);
	}

	private Node solve(Board initial) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(null, initial));
		
		return null;
	}

	public boolean isSolvable() {
		return start != null;
	}

	public int moves() {
		if (isSolvable())
			return start.move;
		return -1;
	}

	public Iterable<Board> solution() {
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException {
		int i, j, n;
		int[][] blocks;
		Scanner scan = new Scanner(new File("puzzle10.txt"));
		n = scan.nextInt();
		blocks = new int[n][n];

		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				blocks[i][j] = scan.nextInt();

		Board board = new Board(blocks);
		Solver solve = new Solver(board);
	}
}
