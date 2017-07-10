class QueueAsLinkList<E> implements Queue<E> {
    class Node {
        E element;
        Node next;
    }
    private Node first, last;
    
    public void enqueue(E e) {
        Node old_last = last;
        last = new Node();
        last.element = e;
        last.next = null;
        if (isEmpty())
            first = last;
        else {
            old_last.next = last;
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