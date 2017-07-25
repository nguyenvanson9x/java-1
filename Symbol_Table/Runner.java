public class Runner {
	public static void main(String[] args) {
		// ArraySimpleTable<Integer, Integer> st = new ArraySimpleTable<Integer,
		// Integer>();
		// st.put(1, 2);
		// st.put(4, 2);
		// st.put(7, 2);
		// st.put(10, 2);
		// st.put(1, 3);
		// st.delete(1);
		// for (Integer x : st.keys())
		// System.out.println(x + ":\t" + st.get(x));

		// int a[] = {1, 3, 6, 8, 10, 21, 30};
		// BinarySearch bs = new BinarySearch();
		// System.out.println(bs.bsearch(a, 30));

		OrderedArraySimpleTable<Integer, Integer> st = new OrderedArraySimpleTable<Integer, Integer>();
		System.out.println(st.ceiling(1));
		st.put(1, 2);
		st.put(4, 2);
		st.put(7, 2);
		st.put(10, 2);
		st.put(1, 3);
		for (Integer x : st.keys())
			System.out.println(x + ":\t" + st.get(x));
		System.out.println("Floor: " + st.floor(-1));
		System.out.println("Ceiling: " + st.ceiling(8));
		System.out.println("Size: " + st.size(-3, 11));
		try {
			for (Integer x : st.keys(8, 1))
				System.out.println(x);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		WordCount w = new WordCount("test1.txt");
		w.count();
		System.out.println("-------------");
		w.remove_rare_words(2);
		// w.remove_top_common(3);
		w.count();
	}
}
