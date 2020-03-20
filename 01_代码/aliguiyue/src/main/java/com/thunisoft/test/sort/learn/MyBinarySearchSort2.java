package com.thunisoft.test.sort.learn;

        import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class MyBinarySearchSort2 {

    public static void main(String[] args) {
        Test t = new Test();
        t.method(5);


//        int[] array = ArrayUtils.getArray(20);
//
//        ArrayUtils.forEachArray(array);
//
//        sort(array);
//
//        ArrayUtils.forEachArray(array);
    }


    public static void sort(int[] array){

        final int length = array.length;

        for (int i = 1; i < length; i++){

            int temp = array[i];

            int low = 0;
            int high = i - 1;

            while (low <= high){

                int mid = (high + low) >> 1;

                if (array[mid] > temp){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }

            }

            for ( int j = i; j > low; j--){
                array[j] = array[j - 1];
            }
            array[low] = temp;

        }



    }


}
class Test {
    int x= 12;
    public void method(int x) {
        x+=x;
        System.out.println(x);
    }
}
