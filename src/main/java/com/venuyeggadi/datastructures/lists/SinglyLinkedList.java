package com.venuyeggadi.datastructures.lists;

public class SinglyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;

		Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}

		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	private Node<E> head = null, tail = null;
	private int size = 0;

	public SinglyLinkedList() {//Empty Constructor
	}

	//access methods
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E peekFirst() {
		if(isEmpty()) //or size == 0
			return null;
		return head.getElement();
	}

	public E peekLast() {
		if(isEmpty())
			return null;
		return tail.getElement();
	}

	//update methods
	public void addFirst(E element) {
		head = new Node<E>(element, head);
		if(isEmpty())
			tail = head;
		size++;
	}

	public void addLast(E element) {
		Node<E> newest = new Node<E>(element, null);
		if(isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}

	public void add(E element) {
		addLast(element);
	}

	public E removeFirst() {
		if(isEmpty())
			return null;
		E element = head.getElement();
		head = head.getNext();
		size--;
		if(isEmpty())
			tail = null;

		return element;
	}
	/**
	 * We can't efficiently access an arbitrary node and
	   delete it as it takes linear time.
	 * Observe that there is no removeLast() method.
	 * because we don't know the node before tail.
	 * it takes linear time to access that node
	 * */
	public E removeLast() {
		if(size == 0)
			return null;
		if(size == 1)
		{
			E element = head.getElement();
			head = tail = null;
			size = 0;
			return element;
		}
		Node<E> node = head;
		while(node.getNext().getNext() != null) {
			node = node.getNext();
		}
		E element = node.getElement();
		node.next = null;
		tail = node;
		size--;

		return element;
	}

	public String toString() {
		if(isEmpty()) //size == 0
			return "[]";
		StringBuilder list = new StringBuilder("[");
		Node<E> node = head;
		while(node != null) {
			list.append(node.getElement());
			node = node.getNext();
			if(node != null)
				list.append(", ");
		}

		return list.append("]").toString();
	}
}

