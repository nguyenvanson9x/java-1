public class Runner {
	public static void main(String[] args) {
		StackAsLinkList<Integer> s = new StackAsLinkList<Integer>();
		s.push(4);
		s.push(1);
		s.push(3);
		s.push(5);
		s.push(10);
		s.reverse();
		s.push(100);
		s.print();
	}
}
