package com.venuyeggadi.datastructures.dynamicarray;

import com.venuyeggadi.datastructures.interfaces.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTests {

    private List<Integer> list;


    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        assertTrue(list.add(10));

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void testAddElementAtIndex() {
        list.add(0, 20);
        list.add(1, 30);

        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void testGetElement() {
        list.add(10);
        list.add(20);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void testSetElement() {
        list.add(10);
        list.add(20);

        assertEquals(10, list.set(0, 30));
        assertEquals(30, list.get(0));
    }

    @Test
    void testRemoveElementByObject() {
        list.add(10);
        list.add(20);

        assertTrue(list.remove(Integer.valueOf(10)));
        assertFalse(list.contains(10));
        assertEquals(1, list.size());
    }

    @Test
    void testRemoveElementByIndex() {
        list.add(10);
        list.add(20);

        assertEquals(10, list.remove(0));
        assertEquals(20, list.get(0));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());

        list.add(10);
        list.add(20);

        assertEquals(2, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(10);

        assertFalse(list.isEmpty());
    }
}