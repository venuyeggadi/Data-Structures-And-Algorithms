package com.venuyeggadi.datastructures.stack;

import com.venuyeggadi.datastructures.interfaces.Stack;

import java.util.EmptyStackException;

/**
	Actual Stack class in Java extends Vector class and is considered legacy
	Recommended way is to use Deque<T> stack = new ArrayDeque<T>(). Is is backed by a dynamic array.
 */

public class DoublyLinkedListStack<E> implements Stack<E>, Iterable<E> {
	private final java.util.LinkedList<E> list;

	public DoublyLinkedListStack() {
		list = new java.util.LinkedList<E>();
	}

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
		list.addLast(element);
	}

	@Override
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		return list.removeLast();
	}

	@Override
	public E peek() {
		if(isEmpty())
			throw new EmptyStackException();
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
