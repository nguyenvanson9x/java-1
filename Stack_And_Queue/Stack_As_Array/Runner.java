public class Runner {
    public static void main (String[] args) {
        Stack_As_Array<Integer> s = new Stack_As_Array<Integer>(3);
        s.push(5);
        s.push(12);
        s.push(30);
        
        s.print();
    }
}