import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class Selection {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = {3, 7, 2, 6, 1, 5, 4};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w) { 
		return v.compareTo(w) < 0; 
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
