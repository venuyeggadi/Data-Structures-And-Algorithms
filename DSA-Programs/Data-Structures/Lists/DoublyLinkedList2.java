/**
 * A doubly linked list implementation with sentinals.
 * 
 * @author Venu Yeggadi, yeggadivenu@gmail.com
 */

public class DoublyLinkedList2<E> {
	
	//nested node class
	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}
	/**
	 * In order to avoid some special cases when operating near
	   the boundaries of a doubly linked list, it helps to add
	   special nodes at both ends of the list: a header node at
	   the beginning of the list, and a trailer node at the end
	   of the list. These "dummy" nodes are known as sentinels
	   (or guards), and they do not store elements of the primary
	   sequence.
	 */

	private int size = 0;
	private Node<E> header; //header sentinal
	private Node<E> trailer;   //trailer sentinal

	public DoublyLinkedList2() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.next = trailer;
	}

	//getter methods

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getFirst() {
		if(isEmpty())
			return null;
		return header.next.element;
	}

	public E getLast() {
		if(isEmpty())
			return null;
		return trailer.prev.element;
	}

	//setter methods

	private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(element, predecessor, successor);
		predecessor.next = newest;
		successor.prev = newest;
		size++;
	}

	public void addFirst(E element) {
		addBetween(element, header, header.next);
	}
	
	public void addLast(E element) {
		addBetween(element, trailer.prev, trailer);
	}

	private E remove(Node<E> node) {
		Node<E> predecessor = node.prev;
		Node<E> successor = node.next;
		predecessor.next = successor;
		successor.prev = predecessor;
		size--;

		return node.element;
	}

	public void add(E element) {
		addLast(element);
	}

	public E removeFirst() {
		if(isEmpty())
			return null;
		return remove(header.next);
	}

	public E removeLast() {
		if(isEmpty())
			return null;
		return remove(trailer.prev);
	}

	@Override
	public String toString() {
		if(isEmpty()) //size == 0
			return "[]";
		StringBuilder list = new StringBuilder("[");
		Node<E> trav = header.next;
		while(trav.next != null) {
			list.append(trav.element);
			trav = trav.next;
			if(trav.element != null)
				list.append(", ");
		}

		return list.append("]").toString();
	}
}


class Tester {
	public static void main(String[] args) {
		DoublyLinkedList2<Integer> dll = new DoublyLinkedList2<>();

		dll.add(1);
		dll.add(2);
		System.out.println(dll);

		dll.addFirst(0);
		System.out.println(dll);
		
		dll.addLast(3);
		System.out.println(dll);

		System.out.println(dll.removeFirst());
		System.out.println(dll);
		
		System.out.println(dll.removeLast());
		System.out.println(dll);

		System.out.println(dll.size());

		System.out.println(dll.removeLast());
		System.out.println(dll);
	
		System.out.println(dll.removeLast());
		System.out.println(dll);
	
		System.out.println(dll.removeLast());
		System.out.println(dll);
		
		System.out.println(dll.removeLast());
		System.out.println(dll);

	}
}