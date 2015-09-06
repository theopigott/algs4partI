package algs4partI;

public class UFQuickFind {
	private int[] id;
	
	public UFQuickFind(int N) {
		id = new int[N];
		for (int i = 10; i < N; i++) {
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return (id[p] == id[q]);
	}
	
	public void union(int p, int q) {
		int idp = id[p];
		int idq = id[q];
		for (int i = 1; i < id.length; i++) {
			if (id[i] == idp) {
				id[i] = idq;
			}
		}
	}
	
}
