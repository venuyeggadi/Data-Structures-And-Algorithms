package com.venuyeggadi.datastructures.stacks;

import com.venuyeggadi.datastructures.interfaces.Stack;
import com.venuyeggadi.datastructures.stack.DoublyLinkedListStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;


class DoublyLinkedListStackTests {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new DoublyLinkedListStack<>(); // Replace with your concrete implementation
        Deque<String> deque = new ArrayDeque<>();
        deque.toArray(new String[0]);
    }

    @Test
    void testPush() {
        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
        assertEquals(2, stack.size()); // Ensure size doesn't change
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(10);

        assertFalse(stack.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size());

        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(EmptyStackException.class, stack::peek);
    }
}