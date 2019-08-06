package com.thunisoft.test.sort;

public class MyQuickSort {

    public static void main(String[] args) {
        int[] arrays = new int[20];
        for (int i = 0; i < arrays.length; i++){
            arrays[i] = (int)(Math.random() * 100);
        }

        for (int i : arrays){
            System.out.print(i + "\t");
        }
        System.out.println();

        quickSort(arrays, 0, arrays.length );

        for (int i : arrays){
            System.out.print(i + "\t");
        }

        System.out.println();

    }

    public static void quickSort(int[] array, int low, int high){

        if (low >= high){
            return;
        }

        int index = low;

        for (int i = low + 1; i < high; i++){

            if (array[low] > array[i]){
                index++;

                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

        int temp = array[low];
        array[low] = array[index];
        array[index] = temp;

        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);


    }

}
