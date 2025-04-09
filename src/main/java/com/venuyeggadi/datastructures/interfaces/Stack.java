package com.venuyeggadi.datastructures.interfaces;

/**
 * Common use cases:
 * 1.LIFO, symmetric structures like parenthesis
 * 2.Reversing a sequence of values
 */

public interface Stack<E> {

	public int size();

	public boolean isEmpty();

	public void push(E element);

	public E pop();

	public E peek();
}