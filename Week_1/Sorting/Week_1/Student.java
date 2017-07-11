public class Student implements Comparable<Student> {
	private int weight;
	
	public Student(int w) {
		this.weight = w;
	}
	@Override
	public int compareTo(Student o) {
		if (this.weight < o.weight)
			return -1;
		if (this.weight > o.weight)
			return 1;
		return 0;
	}
	@Override
	public String toString() {
		return "Student [weight=" + weight + "]\n";
	}
}
