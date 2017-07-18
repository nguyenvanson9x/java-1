public class Runner {
	public static void main(String[] args) {
		Integer[] a = { 1, 2, 3, 4, 6 };
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

		System.out.println(s4.isSubset(s5));
		System.out.println(s3.isSubset(s1));
		System.out.println(s1.isEqual(s2));
		s6 = s4.Tru(s5);

		for (Integer x : s6)
			System.out.println(x);
	}
}
