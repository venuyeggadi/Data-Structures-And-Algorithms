package com.venuyeggadi.datastructures.stack;
import com.venuyeggadi.datastructures.interfaces.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
	private int tos = -1;
	private int capacity;
	private E[] data;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		capacity = 16;
		data = (E[]) new Object[capacity];
	}

	//O(1)
	@Override
	public int size() {
		return tos + 1;
	}

	//O(1)
	@Override
	public boolean isEmpty() {
		return tos == -1;
	}

	//O(1) (amortized)
	@Override
	public void push(E element) {
		if(size() == capacity)
			increaseCapacity();
		data[++tos] = element;
	}

	//O(n)
	private void increaseCapacity() {
		capacity *= 2;
		data = Arrays.copyOf(data, capacity);
	}

	//O(1)
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		
		E element = data[tos];
		data[tos--] = null;//dereference to help garbage collection

		return element;
	}

	//O(1)
	public E peek() {
		if(isEmpty())
			throw new EmptyStackException();
		
		return data[tos];
	}
}
