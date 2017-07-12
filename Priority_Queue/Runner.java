public class Runner {
    public static void main (String[] args) {
        UnorderedMaxPriorityQueue<Integer> queue = new UnorderedMaxPriorityQueue<Integer>(10);
        queue.insert(1);
        queue.insert(10);
        queue.insert(2);
        queue.insert(50);
        queue.insert(20);
        queue.deleteMax();
        queue.print();
    }
}