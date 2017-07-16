public class Runner {
    public static void main (String[] args) {
        // UnorderedMaxPriorityQueue<Integer> queue = new UnorderedMaxPriorityQueue<Integer>(10);
        // queue.insert(1);
        // queue.insert(10);
        // queue.insert(2);
        // queue.insert(50);
        // queue.insert(20);
        // System.out.println(queue.max());
        // queue.print();
        
        BinaryHeapTree<String> heap = new BinaryHeapTree<>();
        heap.insert("S");
        heap.insert("O");
        heap.insert("R");
        heap.insert("T");
        heap.insert("E");
        heap.insert("X");
        heap.insert("A");
        heap.insert("M");
        heap.insert("P");
        heap.insert("L");
        heap.insert("E");
        heap.heap_sort();
        heap.print();
        // OrderedMaxPriorityQueue<Integer> q = new OrderedMaxPriorityQueue<>(2);
        // q.insert(1);
        // q.insert(3);
        // q.insert(2);
        // q.insert(5);
        // q.insert(7);
        // q.insert(9);
        // q.insert(4);
        
        // q.print();
        // System.out.println();
        
        // System.out.println(q.deleteMax());
        // q.deleteMax();
        // q.print();
    }
}