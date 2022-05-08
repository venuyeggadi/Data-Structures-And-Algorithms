package com.venuyeggadi.datastructures.stack;

class SinglyLinkedStack<E> implements Stack<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E element) {
		list.addFirst(element);
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public E peek() {
		return list.peekFirst();
	}
}

class SinglyLinkedStackTest {
	public static void main(String[] args) {
		Stack<Integer> s  = new SinglyLinkedStack<>();
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