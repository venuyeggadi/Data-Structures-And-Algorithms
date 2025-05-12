package com.venuyeggadi.datastructures.set;

import com.venuyeggadi.datastructures.interfaces.Set;

import java.util.HashSet;

public class CustomHashSet<E> implements Set<E> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }
}
