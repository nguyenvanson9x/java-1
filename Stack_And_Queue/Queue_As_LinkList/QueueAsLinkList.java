class QueueAsLinkList<E> implements Queue<E> {
    class Node {
        E element;
        Node next;
    }
    private Node first, last;
    
    public void enqueue(E e) {
        Node node = new Node();
        node.element = e;
        node.next = null;
        
        if (last == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }
    public E dequeue() {
        E e = first.element;
        first = first.next;
        return e;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void print() {
        Node node = first;
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.next;
        }
    }
    public void reverse() {
        
    }
}