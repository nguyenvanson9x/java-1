
public class Runner {
	public static void main(String[] args) {
		LinkedListStack<Integer> s = new LinkedListStack<>();
		s.push(1);
		s.push(3);
		s.push(12);
		s.push(100);
		
		for (Integer x : s)
			System.out.print(x + " ");
		
		System.out.println();
		ArrayStack<Integer> arr = new ArrayStack<>(1);
		arr.push(100);
		arr.push(20);
		arr.push(10);
		arr.pop();
		arr.push(13);
		arr.push(14);
		arr.push(1000);
		arr.pop();
		
		for (Integer x : arr)
			System.out.print(x + " ");
		
		System.out.println();
		
		ArrayQueue<Integer> q = new ArrayQueue<>();
		q.enqueue(12);
		q.enqueue(21);
		
		q.enqueue(23);
		q.dequeue();
		q.enqueue(90);
		q.enqueue(1000);
		for (Integer x : q)
			System.out.print(x + " ");
		System.out.println();
		
		LinkListQueue<Integer> list_queue = new LinkListQueue<>();
		list_queue.enqueue(101);
		list_queue.enqueue(104);
		list_queue.enqueue(603);
		list_queue.enqueue(1001);
		System.out.println(list_queue.dequeue());
		for (Integer x : list_queue)
			System.out.print(x + " ");
	}
}
