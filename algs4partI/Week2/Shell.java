import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class Shell {
	public static void sort(Comparable[] a) {
		int N = a.length;
		
		// Use 3x + 1 increment sequence, find largest such h < N
		int h = 1;
		while (h < N/3) h = (3 * h) + 1;
		
		while (h >= 1) {
			// h-sort array (i.e. insertion sort with step h)
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j -= h) {
					if (less(a[j], a[j-h])) exch(a, j, j-h);
					else break;
				}
			}
			h = h/3; // Same as (h-1)/3 since integer division
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
