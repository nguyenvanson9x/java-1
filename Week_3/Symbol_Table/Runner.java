public class Runner {
	public static void main(String[] args) {
		// ArraySymbolTable<Integer, String> s = new ArraySymbolTable<Integer,
		// String>();
		Array_Ordered_SymbolTable<Integer, String> s = new Array_Ordered_SymbolTable<Integer, String>();
		System.out.println(s.floor(1));
		System.out.println(s.ceiling(1));
		s.put(1, "3");
		s.put(10, "3");
		s.put(21, "3");
		s.put(12, "3");
		s.put(8, "3");
		// s.deleteMax();
		// s.deleteMin();
		for (Integer x : s.keys())
			System.out.println(x + "\t" + s.get(x));
		int in = -1;
		System.out.println(in + ": " + s.rank(in));
		System.out.println("Floor: " + s.floor(0));
		System.out.println(s.ceiling(21));
		System.out.println(s.min());
		System.out.println("Select: " + s.select(-1));
		System.out.println("Size: " + s.size(0, 24));
	}
}
