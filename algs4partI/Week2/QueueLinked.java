import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinked<Item> implements Iterable<Item>{
	Node first = null;
	Node last = null;
	int N = 0;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return first == null; }
	
	public int size() { return N; }
	
	public void enqueue(Item item) {
		Node oldlast = last;
		Node last = new Node();
		last.item = item;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}
	
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException();
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		N--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() { return current != null; }
		public void remove() { throw new UnsupportedOperationException(); }
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
