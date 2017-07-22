public class Runner {
    public static void main (String[] args) {
        Odd_Even u = new Odd_Even();
        int[] a = {1, 2, 0, 1, 0, 1, 2, 2, 2, 1, 2, 0, 12, 13, 14, 15, 16, 17, 19, 0, 21, 23, 100, 2, 0, 13, 54, 21};
        show(a);
        System.out.println();
        u.odd_even(a);
        show(a);
    }
    
    public static void show(int[] a) {
        for (int x : a)
            System.out.print(x + " ");
    }
}