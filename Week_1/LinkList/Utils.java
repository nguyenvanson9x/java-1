import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	private BufferedReader br;

	public void count(String path) {
		SimpleArrayList<WordCount> list = new SimpleArrayList<>();
		String line = "";
		try {
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				String[] word_temp = line.split(" ");
				
				for (String w : word_temp) {
					WordCount data = new WordCount(w, 1);
					if (list.isContain(data)) {
						int index = list.indexOf(data);
						int current_count = list.get(index).getCount();
						WordCount temp = new WordCount(w, current_count + 1);
						list.set(index, temp);
					} else
						list.add(data);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (WordCount x : list) {
			System.out.println(x.toString());
		}
	}
}
