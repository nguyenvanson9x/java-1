public class BinaryHeapTree<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    
    private Key[] heap;
    private int default_cap = 9;
    private int n = 0;
    
    public BinaryHeapTree() {
        heap = (Key[]) new Comparable[default_cap];
        heap[0] = null;
    }
    
    public BinaryHeapTree(int cap) {
        heap = (Key[]) new Comparable[cap];
        heap[0] = null;
    }
    public void insert(Key k) {
        if (n + 1 >= heap.length)
            resize(n + 1);
        heap[++n] = k;
        upheap(n);
    }
    
    private void resize(int n) {
        Key[] temp = (Key[]) new Comparable[2 * n];
        int i;
        for (i = 1; i < n; i++)
            temp[i] = heap[i];
        heap = temp;
    }
    
    private void upheap(int k) {
        while (k > 1 && heap[k].compareTo(heap[k / 2]) > 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }
    
    private void swap(int i, int j) {
        Key temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public Key deleteMax() {
        if (!isEmpty()) {
            Key max = heap[1];
            swap(1, n--);
            downheap(1);
            heap[n + 1] = null;
            return max;
        }
        return null;
    }
    
    private void downheap(int k) {
        while (2 * k <= n) {
            int i = 2 * k;
            if (i < n && heap[i].compareTo(heap[i + 1]) < 0)
                i++;
            if (heap[k].compareTo(heap[i]) > 0)
                break;
            swap(k, i);
            k = i;
        }
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public Key max() {
        if (!isEmpty())
            return heap[1];
        return null;
    }
    
    public int size() {
        return n;        
    }
}