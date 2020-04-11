package com.yufei.learn.datastructure.algorithm;

import java.util.Arrays;

/**
 * 基数排序: 基于二维数组实现
 * 适用于有大有小的数组排序： 个位有，十位有，百位数也有
 * 1) 创建10个数组作为桶： （余数只有0-9这10中情况）
 *
 * 2） 先把数字按个位放入桶中，放入的方法是求余数
 * 3） 把第一轮放入桶中的数据取出来，顺序是先放的先取
 *
 * 4） 把数字按照十位放入桶中，
 * 5） 把第二轮放入桶中的数据取出来，先放的先取
 *
 * 6） 把数字按百位数放入桶中
 * 7） 把第三轮放入的桶中的数据取出来，先放的先取
 *
 * 8） 放几轮取决于数组中最大数的长度，此时数组已经是有序的
 */
public class RedixSortWithArray {

    public static void main(String[] args) {

        int[] array = {5, 36, 12, 798, 102, 156, 3, 79, 22, 369};
        System.out.println("排序前顺序： " + Arrays.toString(array));
        sort(array);
        System.out.println("排序后顺序： " + Arrays.toString(array));
    }

    private static void sort(int[] array){

        int max = Integer.MIN_VALUE;
        for (int data : array) {
            if (data > max) {
                max = data;
            }
        }
        System.out.println("数组中最大数：" + max);
        int maxLength = ("" + max).length();
        // 存放临时数据的二维数组
        int[][] tmp = new int[10][array.length];
        // 记录再相应数组存放数据的个数
        int[] counts = new int[10];

        // 根据最大长度决定比较的次数
        for(int i=0, n=1; i<maxLength; i++, n*=10){

            // 把每个数计算余数
            for (int data : array) {
                int remainder = (data / n) % 10;
                // 把当前遍历的数据放入数组
                tmp[remainder][counts[remainder]] = data;
                counts[remainder]++;
            }

            // 打印一次放入的结果
//            if(i == 0){
//                for(int[] nums:tmp){
//                    System.out.println(Arrays.toString(nums));
//                }
                // System.out.println("每个桶中放入数据的个数：" + Arrays.toString(count))
//            }

            // 记录取出元素要放入的位置
            int index = 0;
            // 桶中的数据取出来
            for(int k=0; k<counts.length; k++){
                if(counts[k] != 0){
                    for(int m=0; m<counts[k]; m++){
                        array[index++] = tmp[k][m];
                    }
                    counts[k] = 0;
                }
            }

        }
    }
}
