public class Utils {
	private static int count_compare, count_swap;

	public static void bubble_sort(int[] a, int n) {
		count_compare = 0;
		count_swap = 0;
		System.out.println("Bubble Sort: ");
		int i, j;
		for (i = n - 1; i > 0; i--) {
			for (j = 1; j <= i; j++) {
				count_compare++;
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					count_swap++;
					
					show(a);
				}
				
			}
		}
		System.out.println("-Swap: " + count_swap);
		System.out.println("-Compare: " + count_compare);
		show(a);
	}

	public static void insertion_sort(int[] a, int n) {
		System.out.println("Insertion Sort:");
		count_compare = 0;
		count_swap = 0;
		int i;
		for (i = 0; i < n; i++) {
			shiftElement(a, i);
			// show(a);
		}
		show(a);

	}
	private static void shiftElement(int[] a, int i) {
		int temp = a[i];
		while (i > 0 && a[i - 1] > temp) {
			a[i] = a[i - 1];
			i--;
		}
		a[i] = temp;
	}

	public static void selection_sort(int[] a, int n) {
		count_compare = 0;
		count_swap = 0;
		System.out.println("Selection Sort: ");
		int i, j, j_Min;
		for (i = 0; i < n - 1; i++) {
			j_Min = i;
			for (j = i + 1; j < n; j++) {
				count_compare++;
				if (a[j] <= a[j_Min]) {
					j_Min = j;
					show(a);
				}
			}
			swap(a, i, j_Min);
			count_swap++;
		}
		
		System.out.println("-Swap: " + count_swap);
		System.out.println("-Compare: " + count_compare);
		show(a);
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void show(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println();
	}

}
