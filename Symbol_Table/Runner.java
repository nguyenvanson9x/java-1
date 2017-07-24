import java.util.Random;

public class Runner {
	public static void main(String[] args) {
		ArraySymbolTable<Integer, String> s = new ArraySymbolTable<Integer, String>();
		int i, n = 20;
		Random r = new Random();
		for (i = 0; i < n; i++)
			s.put(i, r.nextInt(10000) + "");
		for (Integer x : s.keys())
			System.out.println(x + "\t" + s.get(x));
	}
}
