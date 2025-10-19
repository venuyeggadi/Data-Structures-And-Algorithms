package com.venuyeggadi;

import java.util.HashSet;
import java.util.Set;

public class Temp {
    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        set.add(new int[]{1, 1});
        System.out.print(set.contains(new int[]{1, 1}));
    }
}
