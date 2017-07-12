interface MaxPriorityQueue<Key extends Comparable<Key>> {
    public void insert(Key k);
    public Key deleteMax();
    public boolean isEmpty();
    public Key max();
    public int size();
} 