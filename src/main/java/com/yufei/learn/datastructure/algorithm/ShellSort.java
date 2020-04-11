package com.yufei.learn.datastructure.algorithm;

import java.util.Arrays;

/**
 * 插入排序： 希尔排序
 * 直接插入排序最右边有比较小的数时，查询效率比较低
 * 希尔排序数组长度除以2，得到步长，根据步长分组进行直接插入排序，能快速把比较小的数移动到前面
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] array = {5, 3, 17, 10, 32, 0, 12, 9, 16, 20, 1};

        System.out.println("排序前顺序： " + Arrays.toString(array));
        sort(array);
        System.out.println("排序后顺序： " + Arrays.toString(array));

    }

    private static void sort(int[] array){

        // 遍历所有步长, 步长每次缩小一半
        for(int d = array.length/2; d >0; d/=2){
            // 遍历所有元素
            for(int i = d; i < array.length; i++){
                // 遍历本组中所有元素
                for(int j = i-d; j >= 0; j -= d){
                    if(array[j] > array[j+d]){
                        int tmp = array[j];
                        array[j] = array[j+d];
                        array[j+d] = tmp;
                    }
                }
            }
        }
    }
}
