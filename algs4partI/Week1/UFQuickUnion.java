

public class UFQuickUnion {
	private int[] id;
	
	public UFQuickUnion(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	private int root(int i) {
		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}
	
	public void union(int p, int q) {
		id[root(p)] = root(q);
	}
}
