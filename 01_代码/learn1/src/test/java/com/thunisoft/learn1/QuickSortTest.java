package com.thunisoft.learn1;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        sort(array, 0, array.length);

        for (int i: array) {
            System.out.print(i + "\t");
        }

    }

    public static void sort(int[] array, int low, int high){

//        for (int i: array) {
//            System.out.print(i + "\t");
//        }
//        System.out.println();
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

        int temp = array[begin];
        array[begin] = array[index];
        array[index] = temp;

        sort(array, begin, index);
        sort(array, index + 1, end);


    }

}
