class CircularlyLinkedList<E> {

	//Node
	private static class Node<E> {
		private E element = null;
		private Node<E> next = null;

		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		public E getElement() {
			return this.element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	private Node<E> tail = null;
	private int size = 0;

	public CircularlyLinkedList() {
	}

	//accessor methods
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getFirst() {
		if(isEmpty())
			return null;
		return tail.getNext().getElement();
	}

	public E getLast() {
		if(isEmpty())
			return null;
		return tail.getElement();
	}

	//update methods

	//left rotate
	public void rotate() {
		if(tail != null)
			tail = tail.getNext();
	}


	public void addFirst(E element) {
		if(size == 0) {
			tail = new Node<E>(element, null);
			tail.setNext(tail);
		}
		else {
			Node<E> newest = new Node<E>(element, tail.getNext());
			tail.setNext(newest);
		}

		size++;
	}

	public void addLast(E element) {
		addFirst(element);
		tail = tail.getNext();
	}

	public void add(E element) {
		this.addLast(element);
	}

	public E removeFirst() {
		if(isEmpty())
			return null;
		Node<E> head = tail.getNext();
		if(head == tail)
			tail = null;
		else 
			tail.setNext(head.getNext());
		size--;

		return head.getElement();
	}

	/**
	 * We cann't efficiently acces an arbitrary node and
	   delete it as it takes linear time.
	 * Observe that there is no removeLast() method.
	 * because we don't know the node before tail.
	 * it takes linear time to access that node
	 * */
	public E removeLast() {
		if(isEmpty())
			return null;

		Node<E> node = tail;
		for(int i = 0; i < size - 1; i++) {
			node = node.getNext();
		}
		E element = tail.getElement();
		if(size == 1)
			node.setNext(null);
		else
			node.setNext(tail.getNext());
		tail = node;
		size--;

		return element;
	}

	public String toString() {
		if(isEmpty()) //size == 0
			return "[]";
		StringBuilder list = new StringBuilder("[");
		Node<E> node = tail.getNext();
		for(int i = 0; i < size; i++) {
			list.append(node.getElement());
			node = node.getNext();
			if(i < size - 1)
				list.append(", ");
		}

		return list.append("]").toString();
	}
}

class Tester {
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> cl = new CircularlyLinkedList<Integer>();
		cl.add(1);
		cl.add(2);
		System.out.println(cl);

		cl.rotate();
		System.out.println(cl);

		cl.addFirst(0);
		System.out.println(cl);
		
		cl.addLast(3);
		System.out.println(cl);

		cl.rotate();
		System.out.println(cl);

		System.out.println(cl.removeFirst());
		System.out.println(cl);
		
		System.out.println(cl.removeLast());
		System.out.println(cl);

		System.out.println(cl.size());

		System.out.println(cl.removeLast());
		System.out.println(cl);
	
		System.out.println(cl.removeLast());
		System.out.println(cl);
	
		System.out.println(cl.removeLast());
		System.out.println(cl);
		
		System.out.println(cl.removeLast());
		System.out.println(cl);
	}
}