import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class Merge {
	private static final int CUTOFF = 7;

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		// Copy
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		// Merge
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
		assert isSorted(a, lo, hi);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		// Cutoff to insertion sort
		if (hi <= lo + CUTOFF - 1) {
			insertionSort(a, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		// Stop if already sorted
		if (!less(a[mid+1], a[mid])) return;
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	public static void main(String[] args) {
		Integer[] a = {3, 7, 2, 6, 1, 5, 4, 9, 11, 8, 10};
		sort(a);
		System.out.println(Arrays.toString(a));
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
	
	// Code before improvements
/*	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		// Copy
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		// Merge
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
		assert isSorted(a, lo, hi);
	}*/
	
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
