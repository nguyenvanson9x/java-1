import java.util.List;

public class Runner {
	public static void main(String[] args) {
		Integer[] a = { 1, 2, 3 };
		Integer[] b = { 1, 1, 2, 3, 4, 6, 9, 9, 2 };
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
		s6 = s5.Tru(s4);
		System.out.println(s1.contains(2));
		System.out.println(s1.isSubset(s1));
		System.out.println(s2.isSubset(s1));
		
		show(s2);
//		List<SimpleSet<Integer>> l = s2.get_all_sub();
//		for (SimpleSet<Integer> x : l) {
//			System.out.print("{");
//			show(x);
//			System.out.println("}");
//			System.out.println();
//		}
	}
	
	public static void show(SimpleSet<Integer> s) {
		for (Integer x : s)
			System.out.print(x + " ");
	}
}
