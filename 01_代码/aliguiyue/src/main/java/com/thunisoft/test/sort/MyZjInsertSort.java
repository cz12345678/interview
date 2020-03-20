package com.thunisoft.test.sort;

/**
 * 直接插入排序
 */
public class MyZjInsertSort {

    public static void main(String[] args) {

        int[] arrays = new int[20];
        for (int i = 0; i < arrays.length; i++){
            arrays[i] = (int)(Math.random() * 100);
        }

        for (int i : arrays){
            System.out.print(i + "\t");
        }
        System.out.println();

        sort(arrays);

        for (int i : arrays){
            System.out.print(i + "\t");
        }

        System.out.println();


    }

    /**
     * 直接插入排序
     * @param array
     */
    public static void sort(int[] array){

        final int length = array.length;

        int i, j;

        for (i = 0; i < length; i++){

            final int temp = array[i];

            for (j = i; j > 0 && array[j - 1] > temp; j--){
                array[j] = array[j - 1];
            }

            array[j] = temp;

        }

    }

}
