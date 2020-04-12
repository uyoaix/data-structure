package com.yufei.learn.datastructure.search;

/**
 *  二分查找： while循环实现
 *  @author uyoaix
 *  @date 2020年04月13日 00:49:28
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int key = 8;
        int index = search(array, key);
        System.out.println("目标元素下标：" + index);
    }

    private static int search(int[] array, int key) {

        int low = 0;
        int high = array.length - 1;
        int middle;

        if (array[low] > key || array[high] < key) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (array[middle] > key) {
                high = middle - 1;
            } else if (array[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


}
