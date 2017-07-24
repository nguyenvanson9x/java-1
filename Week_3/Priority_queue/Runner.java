public class Runner {
	public static void main(String[] args) {
		// Unordered_PriorityQueue<Integer> q = new
		// Unordered_PriorityQueue<Integer>();
		// q.insert(1);
		// q.insert(12);
		// q.insert(4);
		// q.insert(100);
		// q.insert(13);
		// System.out.println(q.deleteMax());
		// System.out.println(q.max());

		// q.print();

		// Ordered_PriorityQueue<Integer> q = new
		// Ordered_PriorityQueue<Integer>();
		// q.insert(1);
		// q.insert(12);
		// q.insert(1000);
		// q.insert(1000);
		// q.insert(4);
		// q.insert(100);
		// q.insert(13);
		// System.out.println(q.max());
		// q.deleteMax();
		// q.deleteMax();
		// q.print();

		// Unordered_PriorityQueue_LinkList<Integer> q = new
		// Unordered_PriorityQueue_LinkList<Integer>();
		// q.insert(1);
		// q.insert(12);
		// q.insert(1000);
		// q.insert(1000);
		// q.insert(4);
		// q.insert(100);
		// q.insert(13);
		// System.out.println(q.max());
		// q.deleteMax();
		// q.deleteMax();
		// q.print();

		// Ordered_PriorityQueue_LinkList<Integer> q = new
		// Ordered_PriorityQueue_LinkList<Integer>();
		// q.insert(1);
		// q.insert(12);
		// q.insert(1000);
		// q.insert(1000);
		// q.insert(4);
		// q.insert(100);
		// q.insert(13);
		// q.print();

		PriorityQueue_Heap<Integer> q = new PriorityQueue_Heap<Integer>();
		q.insert(1);
		q.insert(12);
		q.insert(1000);
		q.insert(1000);
		q.insert(4);
		q.insert(100);
		q.insert(13);
		System.out.println(q.deleteMax());
		q.print();
	}
}
