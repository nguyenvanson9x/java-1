import java.util.Arrays;
import java.util.Random;

public class Runner {
	public static void main(String[] args) {
		comparecard c = new comparecard();

		Card[] deck = new Card[52];
		int i, j, id = 0;
		for (i = 0; i < 13; i++)
			for (j = 0; j < 4; j++) {
				deck[id] = new Card(i, j);
				id++;
			}
		shuffing(deck);
		Arrays.sort(deck, c);
		for (Card x : deck) {
			System.out.println(x.toString());
		}
	}

	public static void bubble_sort(Card[] a, int n, comparecard c) {
		int i, j;
		for (i = n - 1; i > 0; i--) {
			for (j = 1; j <= i; j++) {
				if (c.compare(a[j - 1], a[j]) > 0)
					swap(a, j - 1, j);
			}
		}
	}
	
	public static void shuffing(Card[] a) {
		int i, j;
		Random rd = new Random();
		for (i = 0; i < a.length; i++) {
			j = rd.nextInt(i + 1);
			swap(a, i, j);
					
		}
	}

	private static void swap(Card[] a, int i, int j) {
		// TODO Auto-generated method stub
		Card temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}
}
