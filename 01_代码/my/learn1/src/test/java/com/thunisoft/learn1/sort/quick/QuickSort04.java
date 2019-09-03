package com.thunisoft.learn1.sort.quick;

import java.util.Arrays;

public class QuickSort04 {


    public static void main(String args[]) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        sort(array);
        Arrays.stream(array).forEach(x -> {
            System.out.print(x + "\t");
        });
    }

    public static void sort(int[] array){
        sort(array, 0, array.length);
    }


    private static void sort(int[] array, int low, int high){
        if (low >= high){
            return;
        }

        int begin = low;
        int end = high;

        int index = begin;

        for (int i = begin; i < end; i++){

            if (array[begin] > array[i]){
                index++;

                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

        int temp = array[index];
        array[index] = array[begin];
        array[begin] = temp;

        sort(array, low, index);
        sort(array, index + 1, end);

    }
}
