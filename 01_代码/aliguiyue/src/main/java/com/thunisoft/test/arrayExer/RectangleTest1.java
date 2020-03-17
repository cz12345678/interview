package com.thunisoft.test.arrayExer;

public class RectangleTest1 {


    public static void test(){
//        float[]=new float[3]; //
//        float f2[]=new float[];//
//        float[] f1=new float[3];//
//        boolean[] b={"true","false","true"};//
//        double f4[]={1,3,5}; //
//        int f5[]=new int[3]{2,3,4}; //
//        float f8[]={1.2F,3.0,5.4};//

    }

    public static void main(String[] args) {
        int n = 7;
        int[][] arr = new int[n][n];

        int count = 0; // 要显示的数据
        int maxX = n - 1; // x轴的最大下标
        int maxY = n - 1; // Y轴的最大下标
        int minX = 0; // x轴的最小下标
        int minY = 0; // Y轴的最小下标
        while (minX <= maxX) {
            for (int x = minX; x <= maxX; x++) {
                arr[minY][x] = ++count;
            }
            minY++;
            for (int y = minY; y <= maxY; y++) {
                arr[y][maxX] = ++count;
            }
            maxX--;
            for (int x = maxX; x >= minX; x--) {
                arr[maxY][x] = ++count;
            }
            maxY--;
            for (int y = maxY; y >= minY; y--) {
                arr[y][minX] = ++count;
            }
            minX++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                String space = (arr[i][j] + "").length() == 1 ? "0" : "";
                System.out.print(space + arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}


