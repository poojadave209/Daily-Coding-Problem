package com.dcp;

public class FirstMissingPositiveNumber {

    public static int getMissingNumber(int[] array) {
        int i = 0;
        while (i < array.length) {
            if (array[i] == i + 1 || array[i] < 0 || array[i] > array.length) i++;
            else if (array[array[i] - 1] != array[i]) {
                swap(array, i, array[i] - 1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < array.length && array[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(getMissingNumber(new int[]{3, 4, -1, 1}));
    }
}
