package com.venuyeggadi.datastructures.lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinglyLinkedListTest {
    @Test
    public void add() {
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();

        sl.add(1);
        sl.add(2);

        assertEquals(2, sl.size());

        sl.addFirst(0);
        System.out.println(sl);
        sl.addLast(3);
        System.out.println(sl);
        System.out.println(sl.removeFirst());
        System.out.println(sl);
        System.out.println(sl.removeLast());
        System.out.println(sl);

        System.out.println(sl.size());

        System.out.println(sl.removeLast());
        System.out.println(sl);
        System.out.println(sl.removeLast());
        System.out.println(sl);
        System.out.println(sl.removeLast());
        System.out.println(sl);
        System.out.println(sl.removeLast());
        System.out.println(sl);
    }
}
