public class Odd_Even {
    public void odd_even(int[] a) {
        _odd_even(a, 0, a.length - 1);

    }
    
    private int[] _odd_even(int[] a, int u, int v) {
        int i, j;
        i = u;
        j = v;
        
        while (i <= j) {
            while (a[i] % 2 != 0 && i < v)
                i++;
            while (a[j] % 2 == 0 && j > u)
                j--;
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        i = u;
        j = v;
        while (i <= j) {
            while (a[i] == 0 || a[i] % 2 != 0)
                i++;
            while (a[j] != 0)
                j--;
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        return a;
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}