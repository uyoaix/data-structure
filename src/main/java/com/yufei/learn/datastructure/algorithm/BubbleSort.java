package com.yufei.learn.datastructure.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 交换排序： 冒泡排序
 */
@Slf4j
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {2, 3, 17, 10, 32, 12, 4, 16, 20, 1};

        log.info("数组原顺序： " + Arrays.toString(array));
        sort(array);
        log.info("数组排序顺序： " + Arrays.toString(array));

    }

    private static int[] sort(int[] array){


        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1-i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }



}
