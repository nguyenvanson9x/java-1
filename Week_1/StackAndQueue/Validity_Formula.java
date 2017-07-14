public class Validity_Formula {
	private LinkedListStack<Character> stack;

	public Validity_Formula() {
		// TODO Auto-generated constructor stub
		stack = new LinkedListStack<>();
	}

	public static void main(String[] args) {
		InfixToPostfix IPF = new InfixToPostfix();
		Validity_Formula v = new Validity_Formula();
		
		String input = "(4.2 + 2.2) * 2";
		
		System.out.println("Input: " + input);
		if (v.validity_formula(input)) {
			String[] s = IPF.postfix(IPF.processString(input));
			System.out.println("Result: " + IPF.cal(s));
		}
		else
			System.out.println("Biểu thức không hợp lệ");
	}

	private boolean validity_formula(String input) {
		char[] data = init(input);
		for (Character x : data) {
			if (x.equals('('))
				stack.push(x);
			if (x.equals(')')) {
				if (!stack.isEmpty())
					stack.pop();
				else
					return false;
			}
		}
		if (stack.isEmpty())
			return true;
		return false;
	}

	private char[] init(String input) {
		int i, n = input.length();
		char[] data = new char[n];

		for (i = 0; i < n; i++)
			data[i] = input.charAt(i);

		return data;
	}
}
