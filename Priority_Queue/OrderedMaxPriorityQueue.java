public class OrderedMaxPriorityQueue<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    private Key queue[];
    private int n;
    
    public OrderedMaxPriorityQueue(int cap) {
        n = 0;
        queue = (Key[]) new Comparable[cap];
    }
    
    public void insert(Key k) {
        int r = rank(k);
        if (n >= queue.length)
            resize(n);
        if (r == 0 || r == n)
            queue[r] = k;
        else {
            int i;
            for (i = n; i > r; i--)
                queue[i] = queue[i - 1];
            queue[r] = k;
        }
        n++;
    }
    
    private void resize(int n) {
        Key[] temp = (Key[]) new Comparable[2 * n];
        int i;
        for (i = 0; i < n; i++)
            temp[i] = queue[i];
        queue = temp;
    }
    private int rank(Key k) {
        int r;
        if (isEmpty())
            r = 0;
        else {
            r = n;
            while (r > 0 && queue[r - 1].compareTo(k) > 0)
                r--;
        }
        return r;
    }

    public Key deleteMax() {
        Key max = queue[n - 1];
        n--;
        return max;
    }
    
    private void swap(int i, int j) {
        Comparable<Key> temp = queue[i];
        queue[i] = queue[j];
        queue[j] = (Key) temp;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public Key max() {
        return queue[n - 1];
    }
    public int size() {
        return n;
    }
    
    public void print() {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(queue[i].toString() + " ");
    }
}