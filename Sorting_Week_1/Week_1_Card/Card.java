public class Card implements Comparable<Card> {
	public int rank, suit;

	public Card(int r, int s) {
		this.rank = r;
		this.suit = s;
	}

	@Override
	public String toString() {
		return "[rank=" + rank + ", suit=" + suit + "]\n";
	}

	@Override
	public int compareTo(Card o) {
		if (rank < o.rank)
			return -1;
		else if (rank > o.rank)
			return 1;	
		else {
			if (suit < o.suit)
				return -1;
			else if (suit > o.suit)
				return 1;
			else
				return 0;
		}
	}

}
