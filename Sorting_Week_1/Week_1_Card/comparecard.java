import java.util.Comparator;

public class comparecard implements Comparator<Card> {

	@Override
	public int compare(Card a, Card a2) {
		if (a.rank < a2.rank)
			return -1;
		else if (a.rank > a2.rank)
			return 1;
		else {
			if (a.suit < a2.suit)
				return -1;
			else if (a.suit > a2.suit)
				return 1;
			else
				return 0;
		}
	}

}
