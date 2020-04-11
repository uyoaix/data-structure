package com.yufei.learn.datastructure.algorithm;

import java.util.Arrays;

/**
 * 选择排序： 简单选择排序
 * 1） 认为第一个数是最小的，遍历数组，找到比第一个数还要小的数，交换位置，把最小的数移到最前面
 * 2） 从第二个数开始，重复执行第一步
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] array = {5, 3, 17, 10, 32, 0, 12, 9, 16, 20, 1};

        System.out.println("排序前顺序： " + Arrays.toString(array));
        sort(array);
        System.out.println("排序后顺序： " + Arrays.toString(array));
    }

    private static void sort(int[] array){
        // 遍历所有的数
        for(int i = 0; i < array.length; i++){
            // 最小数的下标
            int minIndex = i;

            // 从当前遍历的数开始依次和后面的数比较，找到最小数的下标
            for(int j = i + 1; j < array.length; j++){
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }

            // 如果最小的数的下标和当前数的下标不一致，交换位置，把最小数放在最前面
            if(i != minIndex){
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }
}
