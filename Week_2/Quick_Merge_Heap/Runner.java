import java.util.List;

public class Runner {
	public static void main(String[] args) {
		Utils u = new Utils();
		int[] arr = { 1, 4, 2, 7, 4, 3, 8 };
		// u.merge_sort(a);
		u.quick_sort(arr);

		//print(a);
		
		Heap<Integer> h = new Heap<Integer>();
		h.insert(1);
		h.insert(100);
		h.insert(12);
		h.insert(14);
		h.insert(43);
		h.insert(31);
		h.insert(67);
		h.insert(101);
		h.deleteMax();
		h.sort();
		h.print();

	}

	public static void print(int[] a) {
		for (int x : a)
			System.out.print(x + " ");
	}
}
