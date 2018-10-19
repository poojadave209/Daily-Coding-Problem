package com.dcp;

import java.util.HashSet;
import java.util.Set;

public class SumOfNumbers {

    public static boolean canAddToMakeTarget(int[] array, int target) {

        // if the array is sorted
        int start = array[0], end = array[array.length - 1];
        while (start < end) {
            if (array[start] + array[end] == target) {
                return true;
            } else if (array[start] + array[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        // if the array is not sorted
        Set<Integer> set = new HashSet<Integer>();
        for (int n : array) {
            if (set.contains(target - n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canAddToMakeTarget(new int[]{10, 15, 3, 7}, 17));
    }
}
