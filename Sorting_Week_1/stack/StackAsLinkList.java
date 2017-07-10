public class StackAsLinkList<E> implements Stack<E> {
	class Node {
		E element;
		Node next;
	}

	Node head = null;

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.element = e;
		node.next = head;
		head = node;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			E e = head.element;
			head = head.next;
			return e;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Node node = head;
		while (node != null) {
			System.out.print(node.element + " ");
			node = node.next;
		}

	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		Node node = head;
		Node n_new = head;
		while (node != null) {
			
		}
		head = n_new;
	}

}
