public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value>{
	Key min(); //the smallest key
	Key max(); //the largest key
	Key floor(Key key); //the largest key less than or equal to a key
	Key ceiling(Key key); //the smallest key greater than or equal to a key
	int rank(Key key); //number of keys less than a key
	Key select(int k); //key of a given rank
	void deleteMin(); //delete smallest key
	void deleteMax(); //delete largest key
	int size(Key u, Key v); //number of keys between an interval
	Iterable<Key> keys(Key u, Key v); //keys between an interval, in sorted order
	Iterable<Key> keys(); //all keys in the table, in sorted order
}
