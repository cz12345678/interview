package com.thunisoft.learn1.sort.shell;

import java.util.Arrays;

public class ShellSortTest01 {

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


            int i, preIndex;

            for (i = gap; i < length; i++){

                int temp = array[i];

                for (preIndex = i - gap; preIndex >= 0 && array[preIndex] > temp; preIndex -= gap){
                    array[preIndex + gap] = array[preIndex];
                }
                array[preIndex + gap] = temp;
            }

            gap = gap >> 1;

        }


    }

}
