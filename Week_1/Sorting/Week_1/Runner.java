public class Runner {
	public static void main(String[] args) {
		int a[] = {1, 2, 4, 2, 6, 10, 19, 20, 11, 14, 32, 11, 44, 242, 113, 1000, 3224, 1342};
		int n = a.length;
		
		// Utils.bubble_sort(a, n);
		// Utils.selection_sort(a, n);
		Utils.insertion_sort(a, n);
		
		// System.out.println("OBJECT:");
		// Integer b[] = {1, 2, 4, 2, 6, 10, 19, 20, 11, 14, 32, 11, 44, 242, 113, 1000, 3224, 1342};
		// Utils_Comparable<Integer> utils = new Utils_Comparable<Integer>();
		// utils.bubble_sort(b, n);
		// utils.selection_sort(b, n);
		// utils.insertion_sort(b, n);
		
		// Student s1, s2, s3, s4, s5;
		// s1 = new Student(20);
		// s2 = new Student(32);
		// s3 = new Student(16);
		// s4 = new Student(26);
		// s5 = new Student(40);
		
		// Student[] s = {s1, s2, s3, s4, s5};
		// utils.selection_sort(s, s.length);
	}
}
