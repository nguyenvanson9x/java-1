public class Runner {
    public static void main (String[] args) {
        BagLinkList<Integer> bag = new BagLinkList<>();
        bag.add(1);
        bag.add(10);
        bag.add(20);
        bag.add(1);
        bag.add(12);
        bag.remove(1);
        for (Integer x : bag)
            System.out.print(x + " ");
    }
}