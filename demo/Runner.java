class Runner { 
    public static void main (String[] args) {
        Car c = new Car();
        c.setPrice(333);
        System.out.print("Before : " + c.getPrice());
        
        Utils.change_value(c);
        System.out.print("\nAfter : " + c.getPrice());
        System.out.print("\nHều chó");
        
    }
}