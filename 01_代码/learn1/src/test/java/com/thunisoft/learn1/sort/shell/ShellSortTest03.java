package com.thunisoft.learn1.sort.shell;

import java.util.Arrays;

public class ShellSortTest03 {
    public static void main(String args[]){

        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        sort(array);

        Arrays.stream(array).forEach(x -> {
            System.out.print(x + "\t");
        });
    }


    public static void sort(int[] array){

        final int length = array.length;

        int gap = length >> 1;

        while (gap > 0){

            int i, j;

            for (i = 0; i < length; i++){

                int temp = array[i];
                for (j = i - gap; j >= 0 && array[j] > temp; j -= gap){
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }

            gap = gap >> 1;
        }


    }
}
