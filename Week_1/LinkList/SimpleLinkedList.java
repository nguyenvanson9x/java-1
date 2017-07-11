public class SimpleLinkedList<T> {
	class Node {
		T data;
		Node next;
	}

	private Node top, bot;
	private int n = 0;

	public void add(T data) {
		Node node = new Node();
		node.data = data;
		if (top == null) {
			top = node;
			bot = node;
		} else {
			node.next = top;
			top = node;
		}
		n++;
	}

	public void addBot(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (bot == null) {
			top = node;
			bot = node;
		} else {
			bot.next = node;
			bot = node;
		}
		n++;
	}

	public T get(int i) {
		if (i < size() && size() > 0) {
			Node node = top;
			while (i > 0) {
				node = node.next;
				i--;
			}
			return node.data;
		}
		return null;
	}

	public void set(int i, T data) {
		if (i < size() && size() > 0) {
			Node node = top;
			while (i > 0) {
				node = node.next;
				i--;
			}
			node.data = data;
		}
	}

	public boolean isContain(T data) {
		Node node = top;
		while (node != null) {
			if (node.data.equals(data))
				return true;
			node = node.next;
		}
		return false;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public T removeTop() {
		Node node = null;
		if (size() > 0) {
			node = top;
			top = top.next;
			if (size() == 1)
				bot = null;
			n--;
		}

		return node.data;
	}

	public T removeBot() {
		Node node = top;
		int i, size = size();
		for (i = 0; i < size - 1; i++)
			node = node.next;
		T data = bot.data;
		node.next = null;
		bot = node;
		n--;
		return data;
	}

	public void remove(T data) {
		Node node = top;
		int index = 0;
		while (node != null) {
			if (node.data.equals(data)) {
				if (node == top)
					removeTop();
				else if (node == bot)
					removeBot();
				else {
					int j = index;
					Node p = top;
					while (j > 1) {
						p = p.next;
						j--;
					}
					Node next = p.next;
					p.next = next.next;
					n--;
					index--;
				}

			}
			node = node.next;
			index++;
		}
	}

	public void print() {
		Node node = top;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
