import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
	private Scanner scan;
	private OrderedArraySimpleTable<String, Integer> st;
	private String[] src;

	public WordCount(String path) {
		st = new OrderedArraySimpleTable<String, Integer>();
		src = init_string(path);
		init_symbol_table();

	}

	private String[] init_string(String path) {
		String line = "";
		try {
			scan = new Scanner(new File(path));
			while (scan.hasNext())
				line = line + scan.next() + " ";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		line = line.trim();
		line = line.replaceAll("\\s+", " ");
		return line.split(" ");
	}

	public void count() {
		for (String x : st.keys())
			System.out.println(x + ":\t" + st.get(x));
	}

	public void remove_rare_words(int num) {
		int i = 1;
		while (i <= num) {
			remove_words(num - i);
			i++;
		}
	}

	public void remove_top_common(int k) {
		int max_freq = max_frequency();
		System.out.println(max_freq);
		int i = 0;
		while (i < k) {
			remove_words(max_freq - i);
			i++;
		}

	}

	private void remove_words(int freq) {
		for (String x : st.keys())
			if (st.get(x) == freq)
				st.delete(x);
	}

	private int max_frequency() {
		int max = 0;
		for (String x : st.keys())
			if (st.get(x) >= max)
				max = st.get(x);
		return max;
	}

	private void init_symbol_table() {
		for (String x : src)
			if (!st.contains(x))
				st.put(x, 1);
			else {
				int num = st.get(x);
				st.put(x, num + 1);
			}
	}
}
