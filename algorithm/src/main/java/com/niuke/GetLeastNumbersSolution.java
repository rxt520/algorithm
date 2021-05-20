package com.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author COM-RXT
 * @date 2021-05-19
 * 给定一个数组，找出其中最小的K个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */
public class GetLeastNumbersSolution {

    public static void main(String[] args) {
        GetLeastNumbersSolution getLeastNumbersSolution = new GetLeastNumbersSolution();
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        int k = 4;

        ArrayList<Integer> integers = getLeastNumbersSolution.GetLeastNumbers_Solution(arr, k);

        System.out.println(integers.toString());

    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList list = new ArrayList<>();
        if (k > input.length){
            return list;
        }
        //排序
        Arrays.sort(input);

        ArrayList<Integer> collect =new ArrayList<>(Arrays.stream(input).boxed().collect(Collectors.toList()).subList(0,k));

        return collect;

    }
}
