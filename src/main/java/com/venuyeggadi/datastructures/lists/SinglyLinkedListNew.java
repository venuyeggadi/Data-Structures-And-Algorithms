package com.venuyeggadi.datastructures.lists;

import com.venuyeggadi.datastructures.interfaces.List;

import java.util.Iterator;
import java.util.Objects;

public class SinglyLinkedListNew<E> implements List<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            return Objects.equals(element, node.element);
        }

        @Override
        public int hashCode() {
            return element != null ? element.hashCode() : 0;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedListNew() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = new Node<>(e, null);
            tail = head;
            size = 1;
        }

        tail.next = new Node<>(e, null);
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = head;
        for (int i = 1; i <= index; i++) {
            node = head.next;
        }

        Node<E> restOfTheList = node.next;
        Node<E> newNode = new Node<>(element, restOfTheList);
        node.next = newNode;
        size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index == 0)
            return head.element;
        Node<E> node = head;
        for (int i = 1; i <= index; i++)
            node = node.next;

        return node.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o.equals(head.element))
            return true;

        var node = head;
        while (node.next != null) {
            node = node.next;
            if (o.equals(node.element))
                return true;
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        if (index == 0)
            head.element = element;

        var node = head;
        for (int i = 1; i <= index; i++)
            node = node.next;

        E existingValue = node.element;
        node.element = element;

        return existingValue;
    }



    @Override
    public boolean remove(Object o) {
        if (size() == 0)
            return false;

        if (size() == 1){
            if (o.equals(head.element)) {
                head = null;
                tail = null;
                size = 0;
            }
        }

        var node = head;
        while (node.next != null) {
            var previousNode = node;
            node = node.next;
            var nextNode = node.next;
            if (o.equals(node.element)) {
                previousNode.next = nextNode;
                break;
            }
        }

        return false;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size());
        if (index == 0) {
            var removedValue = head.element;
            head = head.next;
            return removedValue;
        }

        Node<E> previousNode = head;
        Node<E> node = head;
        for (int i = 1; i <= index; i++) {
            previousNode = node;
            node = node.next;
        }

        previousNode.next = node.next;

        return node.element;
    }

    @Override
    public int indexOf(Object o) {
        if (size() == 0)
            return -1;
        var node = head;
        for (int i = 1; i < size; i++) {
            node = node.next;
            if (node.element.equals(o))
                return i;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}


