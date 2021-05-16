package com.dynamic;

/***
 * 给定数组arr,返回arr的最长递增子序列长度。比如arr=[2,1,5,3,6,4,8,9,7]
 * ,最长递增子序列为[1,3,4,8,9],所以返回这个子序列的长度5。给定数组arr
 * ,返回arr的最长递增子序列长度。比如arr=[2,1,5,3,6,4,8,9,7]
 * ,最长递增子序列为[1,3,4,8,9],所以返回这个子序列的长度5
 */

public class MaxSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{10,22,9,33,21,50,41,60,80};
        MaxSubsequence maxSubsequence = new MaxSubsequence();
        int[] dp = maxSubsequence.dp(arr);
        System.out.println(dp[dp.length-1]);

    }

    public int[] dp(int[] arr){
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = max(arr,i);
        }
        return dp;
    }

    public int max(int[] arr, int index){
        int max = 1;
        if (index == 0){
            return max;
        }
        for (int i = index-1; i >= 0 ; i--) {
            if (arr[i]>arr[index]){
                continue;
            }
            int max1 = max(arr, i);
            max = max<max1?max1:max;
        }
        return max+1;
    }
}
