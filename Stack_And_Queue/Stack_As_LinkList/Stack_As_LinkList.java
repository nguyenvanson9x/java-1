public class Stack_As_LinkList<E> implements Stack<E> {
    private class Node {
        E element;
        Node next;
    }
    
    private Node head = null;
    
    public void push(E e) {
        Node node = new Node();
        node.element = e;
        node.next = head;
        head = node;
    }
    
    public E pop() {
        E e = head.element;
        head = head.next;
        return e;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.next;
        }
    }
}