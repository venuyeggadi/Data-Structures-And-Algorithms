package com.venuyeggadi.datastructures.stacks;

import com.venuyeggadi.datastructures.interfaces.Stack;
import com.venuyeggadi.datastructures.stack.ArrayStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;


class ArrayStackTests {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayStack<>();
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