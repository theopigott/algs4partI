import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class QueueArray<Item> implements Iterable<Item>{
	private Item[] a;
	int N = 0;
	int head = 0; // Index of first element
	int tail = 0; // Index to insert next element
	
	public QueueArray() {
		a = (Item[]) new Object[1];
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	public void enqueue(Item item) {
		if (N == a.length) resize(a.length * 2);
		a[tail++] = item;
		if (tail == a.length) tail = 0;
		N++;
	}
	
	public Item dequeue() {
		Item item = a[head];
		a[head] = null; // Avoid loitering
		head++;
		N--;
		if (head == a.length) head = 0;
		if (N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	
	private void resize(int M) {
		Item[] copy = (Item[]) new Object[M];
		for (int i = 0; i < N; i++) {
			copy[i] = a[(head + i) % a.length];
		}
		a = copy;
		head = 0;
		tail = N;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private int i = 0;
		
		public boolean hasNext() { return i < N; }
		public void remove() { throw new UnsupportedOperationException(); }
		public Item next() { 
			if (!hasNext()) throw new NoSuchElementException();
			return a[(head + (i++)) % a.length]; 
		}
	}
}
