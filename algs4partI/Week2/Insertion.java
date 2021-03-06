import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j-1])) exch(a, j, j-1);
				else break;
			}
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
