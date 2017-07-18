import java.util.List;

public class Runner {
	public static void main(String[] args) {
		Integer[] a = { 1, 2, 3 };
		Integer[] b = { 1, 2, 3, 4, 6, 9 };
		Integer[] c = { 1, 2, 3, 4, 5 };
		SimpleSet<Integer> s1, s2, s3, s4, s5, s6;
		SimpleSet<Integer> s = new SimpleSet<>();
		s4 = new SimpleSet<>();
		s5 = new SimpleSet<>();
		s1 = new SimpleSet<>(a);
		s2 = new SimpleSet<>(b);
		s3 = new SimpleSet<>(c);
		s.add(1);
		s.add(12);
		s.add(32);
		s.add(100);
		s.add(1);
		List<SimpleSet<Integer>> l = s1.get_all_sub();
		for (SimpleSet<Integer> x : l) {
			System.out.print("{");
			for (Integer y : x)
				System.out.print(y + " ");
			System.out.println("}");
			System.out.println();
		}
	}
}
