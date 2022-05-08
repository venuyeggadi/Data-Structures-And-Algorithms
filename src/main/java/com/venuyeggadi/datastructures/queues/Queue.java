package com.venuyeggadi.datastructures.queues;

public interface Queue<T> {

	public int size();

	public boolean isEmpty();

	public boolean offer(T element);

	public T poll();

	public T peek();
}