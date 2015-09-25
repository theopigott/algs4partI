import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	WeightedQuickUnionUF UF;
	
	public Percolation(int N) {
		if (N <= 0) {
			throw new java.lang.IllegalArgumentException();
		}
		UF = new WeightedQuickUnionUF(N*N + 2);
		for (int i=1; i <= N; i++) {
			UF.union(0, toIndex(0, i));
			UF.union(N*N+1, toIndex(N, i));
		}		
	}
	
	private int toIndex(int i, int j) {
		return 6*(i-1) + j;
	}
	
	public void open(int i, int j) {
		
	}
	
	public static void main(String[] args) {
		

	}

}
