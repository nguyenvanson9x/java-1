public class Runner {
	public static void main(String[] args) {
		String[] tokens = { "(", "6", "+", "4", ")", "/", "2", "+", "9" };
		BinaryTreeNode btn = new BinaryTreeNode(tokens);

		for (String x : btn.preorder())
			System.out.print(x + " ");
		System.out.println();
		System.out.println(btn.cal());
		InfixToPostfix i = new InfixToPostfix();
		i.cal(i.postfix(tokens));
		i.prefix(tokens);
		i.postfix(tokens);
	}
}
