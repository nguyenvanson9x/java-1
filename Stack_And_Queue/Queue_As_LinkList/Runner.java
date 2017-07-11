class Runner {
    public static void main (String[] args) {
        QueueAsLinkList<Integer> q = new QueueAsLinkList<>();
        q.enqueue(4);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(3);
        q.enqueue(55);
        q.dequeue();
        q.print();
    }
}