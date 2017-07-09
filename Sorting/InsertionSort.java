class InsertionSort {
    public static void main (String[] args) {
        int a[] = {1, 3, 2, 6, 4, 30, 10, 6, 2, 5, 10, 20, 19};
        int n = a.length;
        insertionSort(a, n);
        for (int x : a)
            System.out.print(x + " ");
    }
    
    private static void insertionSort(int a[], int n) {
        
    }
    
    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}