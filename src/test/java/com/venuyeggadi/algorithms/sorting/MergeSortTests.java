package com.venuyeggadi.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTests {
    @Test
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSingleElementArray() {
        int[] input = {5};
        int[] expected = {5};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testUnsortedArray() {
        int[] input = {3, 1, 4, 1, 5, 9, 2};
        int[] expected = {1, 1, 2, 3, 4, 5, 9};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] input = {4, 2, 4, 3, 2, 1};
        int[] expected = {1, 2, 2, 3, 4, 4};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }
}
