package com.dcp;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productArray(int[] array) {
        int[] product = new int[array.length];
        product[0] = 1;
        for (int i = 1; i < array.length; i++) {
            product[i] = array[i - 1] * product[i - 1];
        }
        int right = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            product[i] *= right;
            right *= array[i];
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productArray(new int[]{1, 2, 3, 4})));
    }
}
