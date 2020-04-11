package com.yufei.learn.datastructure.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 * 归并排序需要有2组已经有顺序的数组参与
 */
public class MergeSort {

    public static void main(String[] args) {

        //int[] array = {5, 3, 17, 10, 32, 0, 12, 9, 16, 20, 1}; // 这个数组不符合2组有顺序的数组，所以不能归并排序
        int[] array = {1, 3, 5, 2, 4, 6, 8, 10}; // 这个数组从5开始，前后可以分为2个有顺序的数组，所以可以归并

        System.out.println("排序前顺序： " + Arrays.toString(array));
        // sort(array, 0, 2, array.length-1);
        mergeSort(array, 0, array.length-1);
        System.out.println("排序后顺序： " + Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int low, int high){
        int middle = (low+high)/2;
        if(low < high){
            // 处理左边
            mergeSort(array, low, middle);
            // 处理右边
            mergeSort(array, low+1, high);
            // 归并
            sort(array, low, middle, high);
        }
    }

    /**
     *
     * @param array  需要遍历的数组
     * @param low    左边数组的开始下标
     * @param middle 左边的结束右边的开始
     * @param high   右边数据的最后下标
     */
    private static void sort(int[] array, int low, int middle, int high){
        // 存储归并后的临时数组
        int[] tmp = new int[high-low+1];
        // 记录第一个数组中要遍历的下标
        int i = low;
        // 记录第二个数组中要遍历的下标
        int j = middle + 1;
        // 记录临时数组中的下标
        int index = 0;

        // 遍历2个数组取出小的数，放入临时数组中
        while (i <= middle && j <= high){
            // 第一组中的数更小
            if(array[i] <= array[j]){
                // 把小的数放入临时数组中
                tmp[index++] = array[i++];
                // i++;
                // index++;
            } else {
                tmp[index++] = array[j++];
            }
        }

        // 处理多出来的数据
        while (j <= high){
            tmp[index++] = array[j++];
        }
        while (i <= middle){
            tmp[index++] = array[i++];
        }

        // 把临时数组中的数重新放入原数组
        if (tmp.length >= 0) System.arraycopy(tmp, 0, array, low, tmp.length);

    }
}
