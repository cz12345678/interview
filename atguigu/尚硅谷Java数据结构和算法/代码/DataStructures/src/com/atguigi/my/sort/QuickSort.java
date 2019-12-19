package src.com.atguigi.my.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {


    public static void main(String args[]) {

        int[] array = new int[25];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
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

    /**
     * 快速排序
     * @param array
     * @param low
     * @param high
     */
    public static void sort(int[] array, int low, int high){

        if (low >= high){
            return;
        }
        int key = array[low];
        int keyIndex = low;


        for (int i = low; i < high; i++){

            if (key > array[i]){
                keyIndex++;

                int temp = array[keyIndex];
                array[keyIndex] = array[i];
                array[i] = temp;
            }

        }

        int temp = array[keyIndex];
        array[keyIndex] = array[low];
        array[low] = temp;

        sort(array, low, keyIndex);
        sort(array, keyIndex + 1, high);


    }

}
