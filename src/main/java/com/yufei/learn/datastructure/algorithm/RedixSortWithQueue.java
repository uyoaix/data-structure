package com.yufei.learn.datastructure.algorithm;

import java.util.*;

/**
 * 基数排序: 基于队列实现
 */
public class RedixSortWithQueue {

    public static void main(String[] args) {

        int[] array = {5, 36, 12, 798, 102, 156, 3, 79, 22, 369};
        System.out.println("排序前顺序： " + Arrays.toString(array));
        sort(array);
        System.out.println("排序后顺序： " + Arrays.toString(array));
    }

    private static void sort(int[] array){

        // 找出数组中最大的数
        int max = Integer.MIN_VALUE;
        for (int data : array) {
            if (data > max) {
                max = data;
            }
        }
        System.out.println("数组中最大数：" + max);

        int maxLength = ("" + max).length();
        // 存放临时数据的队列：10个桶（0-9），每次计算余数后放入对应的桶
        // ArrayDeque<Integer>[] queues = new ArrayDeque[10];
        // 使用上面的范型数组会出现类型擦除，编译会有unchecked类型警告，可以使用下面的代码
        List<ArrayDeque<Integer>> queues = new ArrayList<>(10);
        // 初始化list中的队列
        for(int i=0; i<10; i++){
            queues.add(new ArrayDeque<>());
        }

        // 根据最大长度决定比较的次数
        for(int i=0, n=1; i<maxLength; i++, n*=10){

            // 把每个数计算余数
            for (int data : array) {
                int remainder = (data / n) % 10;
                // 把当前遍历的数据放入数组
                queues.get(remainder).add(data);
            }


            // 记录取出元素要放入的位置
            int index = 0;
            // 桶中的数据取出来
            for (Queue queue : queues) {
                while (!queue.isEmpty()) {
                    array[index++] = (int) queue.poll();
                }
            }

        }
    }
}
