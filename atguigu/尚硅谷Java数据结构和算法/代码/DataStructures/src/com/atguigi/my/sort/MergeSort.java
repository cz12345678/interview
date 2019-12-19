package src.com.atguigi.my.sort;

import java.util.Arrays;

/**
 * πÈ≤¢≈≈–Ú
 */
public class MergeSort {

    public static void main(String args[]){

        int[] array = new int[12];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 1000);
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        array = sort1(array, 0, array.length - 1);

        Arrays.stream(array).forEach(x -> {
            System.out.print(x + "\t");
        });

    }


    public static int[] sort1(int[] array, int low, int high){
        if (low >= high){
            return new int[]{array[low]};
        }
        int mid = low + ((high - low) >> 1);

        int[] left = sort1(array, low, mid);
        int[] right = sort1(array, mid + 1, high);

        int[] newArr = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length){
            newArr[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }

        while (i < left.length){
            newArr[k++] = left[i++];
        }
        while (j < right.length){
            newArr[k++] = right[j++];
        }

        return newArr;
    }

    public static int[] sort(int[] array, int low, int high){
        if (low >= high){
            return new int[]{array[low]};
        }
        int mid = low + ((high - low) >> 1);
        int[] left = sort(array, low, mid);
        int[] right = sort(array, mid + 1, high);

        int[] newArr = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length){
            newArr[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }

        while (i < left.length){
            newArr[k++] = left[i++];
        }

        while (j < right.length){
            newArr[k++] = right[j++];
        }

        return newArr;
    }

}
