public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    private Key queue[];
    private int n;
    
    public UnorderedMaxPriorityQueue(int cap) {
        n = 0;
        queue = (Key[]) new Comparable[cap];
    }
    
    public void insert(Key k) {
        queue[n++] = k;
    }
    public Key deleteMax() {
        int i, index_max = 0;
        for (i = 0; i < n; i++)
            if (queue[i].compareTo(queue[index_max]) > 0)
                index_max = i;
        swap(index_max, n - 1);
        return queue[--n];
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
        return null;
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