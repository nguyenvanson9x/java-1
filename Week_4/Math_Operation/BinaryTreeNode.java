import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeNode {
	class Node {
		String key;
		Node left, right;

		public Node(String key) {
			this.key = key;
		}
	}

	private Node root;
	private Stack<Node> S;
	private InfixToPostfix itp;
	private String[] postfix;

	public BinaryTreeNode(String[] tokens) {
		S = new Stack<>();
		itp = new InfixToPostfix();
		postfix = itp.postfix(tokens);
		create_tree(postfix);
	}

	private void create_tree(String[] postfix) {
		int i, n = postfix.length;

		for (i = 0; i < n; i++) {
			String ele = postfix[i];
			char c = ele.charAt(0);
			Node p = new Node(ele);
			if (itp.isOperator(c) == false)
				S.push(p);
			else {
				p.right = S.pop();
				p.left = S.pop();
				S.push(p);
			}
		}
		root = S.pop();
	}

	public String cal() {
		return _cal(root);
	}

	private String _cal(Node node) {
		double r = 0, num1, num2;
		if (node.left == null && node.right == null)
			return node.key;
		String left = _cal(node.left);
		String right = _cal(node.right);
		char c = node.key.charAt(0);
		num1 = Double.parseDouble(left);
		num2 = Double.parseDouble(right);
		switch (c) {
		case '*':
			r = num1 * num2;
			break;
		case '/':
			r = num1 / num2;
			break;
		case '+':
			r = num1 + num2;
			break;
		case '-':
			r = num1 - num2;
			break;
		default:
			break;
		}
		return Double.toString(r);
	}

	public Iterable<String> inorder() {
		List<String> l = new ArrayList<>();
		inorder(root, l);
		return l;
	}

	public Iterable<String> preorder() {
		List<String> l = new ArrayList<>();
		preorder(root, l);
		return l;
	}

	public Iterable<String> postorder() {
		List<String> l = new ArrayList<>();
		postorder(root, l);
		return l;
	}

	private void inorder(Node node, List<String> l) {
		if (node != null) {
			inorder(node.left, l);
			l.add(node.key);
			inorder(node.right, l);
		}
	}

	private void preorder(Node node, List<String> l) {
		if (node != null) {
			l.add(node.key);
			preorder(node.left, l);
			preorder(node.right, l);
		}
	}

	private void postorder(Node node, List<String> l) {
		if (node != null) {
			postorder(node.left, l);
			postorder(node.right, l);
			l.add(node.key);
		}
	}
}
