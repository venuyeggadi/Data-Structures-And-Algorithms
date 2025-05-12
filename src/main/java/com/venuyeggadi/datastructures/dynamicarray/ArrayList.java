package com.venuyeggadi.datastructures.dynamicarray;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class ArrayList<T> implements com.venuyeggadi.datastructures.interfaces.List<T> {
    private T[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public boolean add(T t) {
        if (size == array.length){
            capacity = 2 * array.length;
            array = Arrays.copyOf(array, capacity); // uses System.arraycopy internally
        }
        array[size] = t;
        size++;

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        Objects.checkIndex(index, size);
        T oldValue = array[index];
        array[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}