
public class DoublyLinkedStack<E> implements Stack<E>, Iterable<E> {
	private java.util.LinkedList<E> list = new java.util.LinkedList<E>();

	public DoublyLinkedStack() {}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty(); //size() == 0;
	}

	@Override
	public void push(E element) {
		list.addLast(element);
	}

	@Override
	public E pop() {
		if(isEmpty())
			return null;
		return list.removeLast();
	}

	@Override
	public E peek() {
		if(isEmpty())
			return null;
		return list.peekLast();
	}

	public int search(E element) {
		return list.lastIndexOf(element);
	}

	@Override
	public java.util.Iterator<E> iterator() {
		return list.iterator();
	}
}

class DoublyLinkedStackTest {
	public static void main(String[] args) {
		Stack<Integer> s  = new DoublyLinkedStack<>();
		s.push(5);// contents: (5)
		s.push(3);// contents: (5, 3)
		System.out.println(s.size()); // contents: (5, 3) outputs 2
		
		System.out.println(s.pop()); // contents: (5) outputs 3
		System.out.println(s.size());// outputs 1

		System.out.println(s.isEmpty()); // contents: (5) outputs false
		System.out.println(s.pop()); // contents: () outputs 5
		
		System.out.println(s.isEmpty()); // contents: () outputs true
		System.out.println(s.pop()); // contents: () outputs null
		
		s.push(7); // contents: (7)
		s.push(9); // contents: (7, 9)
		System.out.println(s.peek()); // contents: (7, 9) outputs 9
		
		s.push(4); // contents: (7, 9, 4)
		System.out.println(s.size()); // contents: (7, 9, 4) outputs 3
		System.out.println(s.pop()); // contents: (7, 9) outputs 4
		
		s.push(6); // contents: (7, 9, 6)
		s.push(8); // contents: (7, 9, 6, 8)
		System.out.println(s.pop()); //outputs 8
	}
}