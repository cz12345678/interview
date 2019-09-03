package com.thunisoft.learn1.sort.insert;

import java.util.Arrays;

public class ZjInsertSortTest01 {


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

        int i, j;
        for (i = 0; i < length; i++){

            int temp = array[i];

            for (j = i; j > 0 && array[j - 1] > temp; j--){
                array[j] = array[j - 1];
            }
            array[j] = temp;

        }


    }
}
