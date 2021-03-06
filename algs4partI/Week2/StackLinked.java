import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLinked<Item> implements Iterable<Item>{
	Node first = null;
	int N = 0;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return first != null; }
	
	public int size() { return N; }
	
	public void push(Item item) {
		Node oldfirst = first;
		Node first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		if (isEmpty()) throw new NoSuchElementException();
		Item item = first.item;
		first = first.next;
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
