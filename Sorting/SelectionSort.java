class SelectionSort {
    public static void main (String[] args) {
        int a[] = {1, 3, 2, 6, 4, 30, 10, 6, 2, 5, 10, 20, 19};
        int n = a.length;
        selectionSort_2(a, n);
        for (int x : a)
            System.out.print(x + " ");
    }
    
    private static void selectionSort(int a[], int n) {
        int i, j;
        for (i = 0; i < n - 1; i++)
            for (j = i + 1; j < n; j++)
                if (a[i] > a[j])
                    swap(a, i, j);
    }
    
    private static void selectionSort_2(int a[], int n) {
        int i, j, j_Min;
        for (i = 0; i < n - 1; i++) {
            j_Min = i;
            for (j = i + 1; j < n; j++)
                if (a[j] < a[j_Min])
                    j_Min = j;
            swap(a, i, j_Min);
        }
    }
    
    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}