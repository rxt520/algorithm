package com.leetcode;

import java.util.*;

/**
 * @author P-RXT
 * @date 2021-05-11
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值
 * 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案
 */
public class Subject1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }



    /**
     * 暴力
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] findNums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            findNums[0] = i;
            int findNum = target - nums[i];
            for (int j = 0; j < nums.length && j!=i; j++) {
                if (findNum == nums[j]){
                    findNums[1] = j;
                    return findNums;
                }
            }

        }
        return null;
    }
}
