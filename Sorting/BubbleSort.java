class BubbleSort {
    public static void main(String[] args) {
        int a[] = {1, 4, 2, 7, 4, 0, 9, 6, 1, 5};
        int n = a.length;
        bubbleSort(a, n);
        
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
    
    private static void bubbleSort(int a[], int n) {
        int i, j;
        for (i = n - 1; i > 0; i--) {
            for (j = 1; j <= i; j++) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }
    
    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}