public class NhanVien {
    public static void main (String[] args) {
        Student s = new Student();
        s.main(args);
    }
}
class Student {
    public static void main (String[] args) {
        Student s = new Student();
        s.show();
        System.out.println("Call main() of Student class");
    }
    public void show() {
        System.out.println("OK - Student");
    }
}