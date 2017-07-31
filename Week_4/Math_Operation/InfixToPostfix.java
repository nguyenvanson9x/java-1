import java.util.Stack;

public class InfixToPostfix {
	public int priority(char c) {
		if (c == '+' || c == '-')
			return 1;
		if (c == '*' || c == '/')
			return 2;
		return 0;
	}

	// kiem tra toan tu
	public boolean isOperator(char c) {
		char operator[] = { '+', '-', '*', '/', '(', ')' };
		for (char x : operator)
			if (c == x)
				return true;
		return false;
	}

	private String reverse(String src) {
		int i, n = src.length();
		char[] des = new char[n];

		for (i = 0; i < n; i++)
			des[i] = src.charAt(n - i - 1);
		return String.copyValueOf(des);
	}

	public String[] postfix(String[] tokens) {
		String out = "";
		int i, n = tokens.length;
		Stack<String> S = new Stack<String>();

		for (i = 0; i < n; i++) {
			String element = tokens[i];
			char c = element.charAt(0);

			if (!isOperator(c))
				out = out + " " + element;
			else {
				if (c == '(')
					S.push(element);
				else if (c == ')') {
					String ele = S.pop();
					char c1 = ele.charAt(0);
					while (c1 != '(') {
						out = out + " " + ele;
						ele = S.pop();
						c1 = ele.charAt(0);
					}
				} else {
					while (!S.isEmpty() && priority(S.peek().charAt(0)) >= priority(c))
						out = out + " " + S.pop();
					S.push(element);
				}
			}
		}
		while (!S.isEmpty())
			out = out + " " + S.pop();
		out = out.trim();
		return out.split(" ");
	}

	public String[] prefix(String[] tokens) {
		String out = "";
		int i, n = tokens.length;
		Stack<String> S = new Stack<String>();

		for (i = n - 1; i >= 0; i--) {
			String element = tokens[i];
			char c = element.charAt(0);

			if (!isOperator(c))
				out = out + " " + element;
			else {
				if (c == ')')
					S.push(element);
				else if (c == '(') {
					String ele = S.pop();
					char c1 = ele.charAt(0);
					while (c1 != ')') {
						out = out + " " + ele;
						ele = S.pop();
						c1 = ele.charAt(0);
					}
				} else {
					while (!S.isEmpty() && priority(S.peek().charAt(0)) > priority(c)) {
						out = out + " " + S.peek();
						S.pop();
					}
					S.push(element);
				}
			}
		}
		while (!S.isEmpty()) {
			out = out + " " + S.peek();
			S.pop();
		}
		out = out.trim();
		out = reverse(out);
		System.out.println(out);
		return out.split(" ");
	}

	public String cal(String[] postfix) {
		int i, n = postfix.length;
		Stack<String> S = new Stack<>();

		for (i = 0; i < n; i++) {
			String element = postfix[i];
			char c = element.charAt(0);

			if (!isOperator(c))
				S.push(element);
			else {
				double r = 0;
				double num2 = Double.parseDouble(S.pop());
				double num1 = Double.parseDouble(S.pop());
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
				S.push(Double.toString(r));
			}
		}
		return S.pop();
	}
}
