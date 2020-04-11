package com.yufei.learn.datastructure.algorithm;

import java.util.Arrays;

/**
 * 插入排序： 直接插入排序
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] array = {5, 3, 17, 10, 32, 0, 12, 9, 16, 20, 1};

        System.out.println("排序前数组：" + Arrays.toString(array));
        sort(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }

    private static void sort(int[] array){

        // 认为一个数的时候是有序的，所以从下标1开始遍历，因为前面只有一个数
        for(int i=1; i< array.length; i++){
            // 如果当前数比前面的数小，就将当前数和前面的数做交换
            // 做交换时，循环遍历前面所有的数，只要比当前数大，就一直向左移动
            if(array[i] < array[i-1]){
                //  将当前数字存起来
                int tmp = array[i];

                int j;
                // 遍历当前数字前面所有的数字
                for(j = i-1; j >= 0 && array[j] > tmp; j--){
                    // 只要前面的数比当前数大，就将当前数一直向做移动
                    array[j+1] = array[j];
                }
                // 前面的数遍历完，没有比当前数大的，就将tmp赋给遍历到的数的前一个
                array[j+1] = tmp;

            }
        }
    }
}
