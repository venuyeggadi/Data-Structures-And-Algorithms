package com.venuyeggadi.datastructures.interfaces;

import java.util.Iterator;

public interface List<T> {
    boolean add(T t);
    void add(int index, T element);
    T get(int index);
    T set(int index, T element);
    boolean remove(Object o);
    T remove(int index);

    int size();

    boolean isEmpty();

    void clear();

    int indexOf(Object o);

    int lastIndexOf(Object o);

    boolean contains(Object o);

    Iterator<T> iterator();
}
