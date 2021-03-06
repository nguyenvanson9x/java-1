public class Runner {
	public static void main(String[] args) {
		// SimpleBST<Integer> s = new SimpleBST<>();
		// SimpleTable_BST<Integer, Integer> s = new SimpleTable_BST<>();
		Exercise_BST<Integer, Integer> s = new Exercise_BST<>();
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
		s.put(22, 6);
		s.put(16, 1);
		s.put(1, 1);
		s.put(3, 1);
		// s.deleteMax();
		// s.delete(4);
		for (Integer x : s.keys())
			System.out.println(x + "\t" + s.get(x));
		System.out.println();
		System.out.println(s.size());
		System.out.println(s.contains(1));
		System.out.println(s.floor(11));
		System.out.println(s.ceiling(11));
		System.out.println("Depth: " + s.depth());
		show(s.keys(-1, 10));
		System.out.println("Count node between: " + s.size(-1, 10));
		show(s.keys_level(4));
		show(s.keys_all_level());

		System.out.println("*" + s.count_key_only_one_child());
		System.out.println("*" + s.count_key_have_two_child());
		show(s.keys_have_two_child());
		System.out.println("even: " + s.count_even_key());
		System.out.println("even leaf: " + s.count_even_leaf());
		show(s.even_leaf());
		show(s.keys_level(4));
		System.out.println("Count level: " + s.count_level(4));
		System.out.println("Sum keys: " + s.sum_keys());
		System.out.println("Sum leafs: " + s.sum_leaf());
		System.out.println("Keys have one child:");
		show(s.keys_only_one_child());
		System.out.println("Sum node have one child: " + s.sum_keys_one_child());
		System.out.println("is BST: " + s.is_BST());
		System.out.println("is blanched BST: " + s.is_blanched_BST());
		System.out.println("is_completely_balanced_BST: " + s.is_completely_balanced_BST());
		System.out.println("Sum key less than k: " + s.sum_keys_less_than(5));
		System.out.println("Count key less than or equal k: " + s.count_key_less_than(10));
		// get_number("This is a number abc12a3.a456aaa222,666");
		System.out.println("Rank: " + s.rank(16));
		System.out.println("Select: " + s.select(4));
		System.out.println("Key nearest: " + s.key_nearest(-1));
	}

	private static void show(Iterable<Integer> i) {
		System.out.println("\n********");
		System.out.println("Keys:");
		for (Integer x : i)
			System.out.print(x + " ");
		System.out.println();
		System.out.println("---------");
	}

	/*
	 * private static ArrayList<Double> get_number(String str) { // str =
	 * "This is a number abc12a3.456aaa222,666" ArrayList<Double> list = new
	 * ArrayList<>(); str = str.replaceAll("[,]", "."); str =
	 * str.replaceAll("[^0-9-,\\.]", "@"); String[] items = str.split("@"); for
	 * (String x : items) try { double result = Double.parseDouble(x);
	 * list.add(result); } catch (Exception e) {
	 * 
	 * } return list; }
	 */
}
