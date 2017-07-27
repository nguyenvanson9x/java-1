public class Runner {
	public static void main(String[] args) {
		// SimpleBST<Integer> s = new SimpleBST<>();
		// SimpleTable_BST<Integer, Integer> s = new SimpleTable_BST<>();
		OrderedSimpleTable<Integer, Integer> s = new OrderedSimpleTable_BST<>();
		// System.out.println(s.size());
		// s.insert(1);
		// s.insert(13);
		// s.insert(21);
		// s.insert(2);
		// s.insert(3);
		// s.insert(9);
		s.put(100, 1);
		s.put(4, 7);
		s.put(2, 2);
		s.put(10, 9);
		s.put(21, 6);
		s.put(16, 1);
		// s.deleteMax();
		for (Integer x : s.keys())
			System.out.println(x + "\t" + s.get(x));
		System.out.println();
		System.out.println(s.size());
		System.out.println(s.contains(1));
		System.out.println(s.floor(11));
		System.out.println(s.ceiling(11));
	}
}
