package com.venuyeggadi.problemsolving.basicprograms;

import java.util.Random;
import java.lang.Math;

class RandomNumbers {
	public static void main(String[] args) {

		//#1
		Random rand = new Random();
		System.out.println(rand.nextInt(10));//[0, 10)
		System.out.println(rand.nextDouble());//[0, 1)

		//#2
		System.out.println(Math.random()); //[0, 1)
	}
}