import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class Quick {
	private static final int CUTOFF = 10;
	
	public static void main(String[] args) {
		int N = 50;
		Integer[] a = new Integer[N];
		for (int i = 0; i < N; i++) {
			a[i] = i;
		}
		shuffle(a);
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		
		while (true) {
			// Find first entry not less than a[lo] without falling off end of array
			while (less(a[++i], a[lo])) if (i == hi) break;
			// Find last entry not greater than a[lo] without falling off start of array
			while (less(a[lo], a[--j])) if (j == lo) break;
			// Stop when i and j cross
			if (i >= j) break;
			// Swap a[i] and a[j] to maintain invariance
			exch(a, i, j);
		}
		// Put a[lo] at the correct place between partitions
		exch(a, lo, j);
		// Return index of entry now in place
		return j;
	}
	
	public static void sort(Comparable[] a) {
		shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		// Sort 'small' arrays with insertion sort as quicksort has large overhead
		if (hi <= lo + CUTOFF - 1) {
			insertionSort(a, lo, hi);
			return;
		}
		// Partition array and store dividing entry index
		int j = partition(a, lo, hi);
		// Sort either side
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	// Pick out kth smallest element
	public static Comparable select(Comparable[] a, int k) {
		shuffle(a);
		int lo = 0;
		int hi = a.length - 1;
		// Recursively partition the sections containing a[k]
		while (lo < hi) {
			int j = partition(a, lo, hi);
			if (j < k) lo = j + 1;
			else if (k < j) hi = j - 1;
			else return a[k];
		}
		return a[k];
	}
	
	public static void sortDuplicates(Comparable[] a) {
		sortDuplicates(a, 0, a.length - 1);
	}
	
	// Dijkstra 3-way partitioning algorithm
	// Code maintains invariants: 
	// - Entries between lt and gt and equal to partitioning element
	// - Entries below lt and smaller
	// - Entries above gt are larger
	public static void sortDuplicates(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int lt = lo;
		int gt = hi;
		Comparable v = a[lo];
		int i = lo;
		while (i <= gt) {
			@SuppressWarnings("unchecked")
			int cmp = v.compareTo(a[i]);
			if (cmp > 0) exch(a, i++, lt++);
			else if (cmp < 0) exch(a, i, gt--);
			else i++;
		}
		sortDuplicates(a, lo, lt-1);
		sortDuplicates(a, gt+1, hi);
	}
	
	// Knuth shuffle
	public static void shuffle(Comparable[] a) {
		Random rng = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = rng.nextInt(i+1);
			exch(a, i, r);
		}
	}
	
	public static void insertionSort(Comparable[] a, int lo, int hi) {
		assert lo >= 0;
		assert hi < a.length;
		
		for (int i = 0; i <= hi; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j-1])) exch(a, j, j-1);
				else break;
			}
		}
		
		assert isSorted(a, lo, hi);
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
	
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int k = lo; k < hi-1; k++) {
			if (less(a[k+1], a[k])) return false;
		}
		return true;
	}
	
}
