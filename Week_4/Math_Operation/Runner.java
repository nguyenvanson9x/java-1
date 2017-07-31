public class Runner {
	public static void main(String[] args) {
		InfixToPostfix ITP = new InfixToPostfix();
		String[] tokens = { "(", "6", "+", "4", ")", "/", "2", "+", "9" };
		// ITP.postfix(tokens);
		// ITP.prefix(tokens);
//		System.out.println(ITP.cal(ITP.postfix(tokens)));
		BinaryTreeNode btn = new BinaryTreeNode(tokens);
		String[] postfix = ITP.postfix(tokens);
//		btn.create_tree(postfix);
		for (String x : btn.preorder())
			System.out.print(x + " ");
		System.out.println();
		System.out.println(btn.cal());
	}
}
