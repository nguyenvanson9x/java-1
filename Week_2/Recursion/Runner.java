public class Runner {
	public static void main(String[] args) {
		Utils util = new Utils();
		int[] A = { 1, 4, 6, 8 };
		int[] B = { 1, 5, 10 };
		System.out.println(util.giai_thua(4));
		System.out.println(util.giai_thua_kep(5));
		System.out.println(util.fibonacy(5));
		util.HaNoi_Tower(4);
		util.count();
		// util.nhi_phan(4);
		// util.tap_con(B);
		// util.sort(A);
		util.create_array(A, B);
		util.robot(3);
	}
}
