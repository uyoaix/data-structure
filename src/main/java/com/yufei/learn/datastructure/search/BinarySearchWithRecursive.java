package com.yufei.learn.datastructure.search;

/**
 * 二分查找： 递归实现实现
 *
 * @author uyoaix
 * @date 2020年04月13日 00:52:00
 */
public class BinarySearchWithRecursive {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int key = 8;
        int index = search(array, key, 0, array.length - 1);
        System.out.println("目标元素下标：" + index);
    }

    private static int search(int[] array, int key, int low, int high) {

        if (array[low] > key || array[high] < key) {
            return -1;
        }

        int middle = (low + high) / 2;
        if (array[middle] > key) {
            return search(array, key, low, middle - 1);
        } else if (array[middle] < key) {
            return search(array, key, middle + 1, high);
        } else {
            return middle;
        }
    }
}
