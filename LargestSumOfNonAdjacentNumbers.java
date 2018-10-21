package com.dcp;

public class LargestSumOfNonAdjacentNumbers {

    public static int largestSum(int[] array) {
        int inclusiveSum = array[0];
        int exclusiveSum = 0;

        for (int i = 1; i < array.length; i++) {
            int max_sum = Math.max(inclusiveSum, exclusiveSum);
            inclusiveSum = exclusiveSum + array[i];
            exclusiveSum = max_sum;
        }

        return Math.max(inclusiveSum, exclusiveSum);
    }

    public static void main(String[] args) {
        System.out.println(largestSum(new int[]{5, 1, 1, 5}));
    }
}
