public class Utils_Comparable<E extends Comparable<E>> {
	@SuppressWarnings("unchecked")
	public void bubble_sort(Comparable<E>[] a, int n) {
		int i, j;
		for (i = n - 1; i > 0; i--) {
			for (j = 1; j <= i; j++) {
				if (a[j - 1].compareTo((E) a[j]) > 0)
					swap(a, j - 1, j);
			}
		}
		System.out.println("Bubble Sort:");
		show(a);
	}

	public void insertion_sort(Comparable<E>[] a, int n) {
		int i;
		for (i = 0; i < n; i++)
			shiftElement(a, i);
		System.out.println("Insertion Sort:");
		show(a);
	}

	@SuppressWarnings("unchecked")
	private void shiftElement(Comparable<E>[] a, int i) {
		Comparable<E> temp = a[i];
		while (i > 0 && a[i - 1].compareTo((E) a[i]) > 0) {
			a[i - 1] = a[i];
			i--;
		}
		a[i] = temp;
	}

	public void selection_sort(Comparable[] a, int n) {
		int i, j, j_min;
		for (i = 0; i < n - 1; i++) {
			j_min = i;
			for (j = i + 1; j < n; j++) {
				if (a[j].compareTo((E) a[j_min]) < 0) {
					j_min = j;
				}
			}
			swap(a, i, j_min);
		}
		System.out.println("Selection sort: ");
		show(a);
	}

	private void swap(Comparable<E>[] a, int i, int j) {
		Comparable<E> temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void show(Comparable<E>[] a) {
		for (Comparable<E> x : a) {
			System.out.print(x.toString() + " ");
		}
		System.out.println();

	}
}
