import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class StackArray<Item> implements Iterable<Item> {
	private Item[] a;
	int N = 0;
	
	public StackArray() {
		a = (Item[]) new Object[1];
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	public void push(Item item) {
		if (N == a.length) resize(a.length * 2);
		a[N++] = item;
	}
	
	public Item pop() {
		if (isEmpty()) throw new NoSuchElementException();
		Item item = a[--N];
		a[N] = null; // Avoid loitering
		if (N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	
	private void resize(int M) {
		Item[] copy = (Item[]) new Object[M];
		for (int i = 0; i < N; i++) {
			copy[i] = a[i];
		}
		a = copy;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private int i = N;
		
		public boolean hasNext() { return i > 0; }
		public void remove() { throw new UnsupportedOperationException(); }
		public Item next() { 
			if (!hasNext()) throw new NoSuchElementException();
			return a[--i]; 
		}
	}
}
