package com.yufei.learn.datastructure.algorithm;

import java.util.Arrays;

/**
 * 交换排序： 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {5, 2, 8, 1, 2, 9, 7, 4, 12};
        System.out.println("排序前数组：" + Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }

    /**
     * 1）取一个数作标准(一般取数组第一个数)，将数组分为2部分
     * 左边的都是比标准数小的，右边都是比标准数大的
     * 2）重复第一步，递归左右2部分数据
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] sort(int[] array, int start, int end){

        int standard = array[start];
        int low = start;
        int high = end;

        // 1）第一步： 循环数组，找到比标准数大的和标准数小的数

        if(low < high){
            while(low < high){
                // 从最后一个数开始比较，比标准数大，就不动，并将下标向左移动；
                while(low < high && array[high] >= standard){
                    // 向左移动下标
                    high--;
                }
                // 如果比标准数小，就和低位交换，放在左边
                array[low] = array[high];

                // 再从左边比较，如果比标准数小，就不动，并将下标向右移动
                while(low < high && array[low] <= standard){
                    // 向右移动下标
                    low++;
                }
                // 如果比标准数大，就和高位交换，放在右边
                array[high] = array[low];
            }

            // 将数组根据标准数分为2部分后，low = high，此时退出循环
            // 此时将标准数的值赋给下标移动到的位置，左边都是比标准数小的数据，右边都是比标准数大的数据
            array[low] = standard;

            // 第二步： 递归操作，把左右2边的数据重复执行第一步
            sort(array, start, low); // 左边的数据下标从0开始到low移动后到达的位置
            sort(array, low + 1, end); // 右边的数据下标从low后一位开始到数组最后的位置
        }

        return array;
    }


}
