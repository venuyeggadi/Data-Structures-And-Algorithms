package com.venuyeggadi.problemsolving.basicprograms;

import java.util.Stack;
import java.util.Arrays;

class ReverseAnArray {
	public static void main(String[] args) {
		Integer[] a = new Integer[]{1, 2, 3, 4, 5};

		System.out.println(Arrays.toString(a));
		System.out.println();
		
		reverse(a);

		System.out.println(Arrays.toString(a));
	}

	public static <E> void reverse(E[] a) {
		Stack<E> stack = new Stack<E>();
		for(E e : a)
			stack.push(e);
		for(int i = 0; i < a.length; i++)
			a[i] = stack.pop();
	}
}