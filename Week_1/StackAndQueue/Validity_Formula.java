public class Validity_Formula {
	private LinkedListStack<Character> stack;

	public Validity_Formula() {
		// TODO Auto-generated constructor stub
		stack = new LinkedListStack<>();
	}

	public static void main(String[] args) {
		Validity_Formula v = new Validity_Formula();
		String input = "((4 * 2) –    5)    ";

		char[] data = v.init(input);

		System.out.println(v.validity_formula(data));
		System.out.println(v.cal(input));
	}

	private boolean validity_formula(char[] data) {
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

	private int cal(String data) {
		data = convert(data);
		System.out.println(data);
		return 0;
	}

	private String convert(String data) {
		data.replace("  ", " ");
		data.replace(" ", "");
		data.replace("(", "( ");
		data.replace(")", " )");
		data.replace("+", " + ");
		data.replace("-", " - ");
		data.replace("*", " * ");
		data.replace("/", " / ");
		data = data.trim();
		data.replace("  ", " ");
		return data;
	}

	private char[] init(String input) {
		int i, n = input.length();
		char[] data = new char[n];

		for (i = 0; i < n; i++)
			data[i] = input.charAt(i);

		return data;
	}
}
