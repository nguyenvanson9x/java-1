public class Runner {
	public static void main(String[] args) {
//		SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
//
//		list.add(1);
//		list.add(2);
//		list.addBot(10);
//		list.add(4);
//		list.addBot(20);
//
//		list.print();
//
//		System.out.println("Value at " + 4 + ": " + list.get(4));
//		list.set(3, 100);
//		System.out.println("After add at 3");
//		list.print();
//		
//		System.out.println();
//		list.addBot(5);
//		list.addBot(6);
//		list.add(12);
//		list.print();
//		System.out.println("Value at " + 6 + ": " + list.get(6));
//		System.out.println(list.isContain(7));
//		list.removeTop();
//		System.out.println(list.removeBot());
//		list.addBot(4);
//		list.set(5, 100);
//		list.set(6, 100);
//		list.print();
//		System.out.println();
//		list.remove(100);
//		list.print();
		SimpleArrayList<Integer> l = new SimpleArrayList<>();
		l.add(10);
		l.add(20);
		l.add(1);
		l.add(20);
		l.add(5);
		l.add(1);
		l.remove(20);
		for (Integer x : l) {
			System.out.print(x + " ");
		}
	}
}
