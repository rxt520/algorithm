package com.dynamic;

import java.util.Arrays;

/**
 *背包有一定的承重W,有N件物品,每件都有自己的价值,记录在数组v中,
 * 也都有自己的重量,记录在数组w中,
 * 每件物品只能选择要装入背包还是不装入背包,
 * 要求在不超过背包承重的前提下,选出物品的总价值最大
 */
public class BackPackage {



    public static void main(String[] args) {
        BackPackage backpack = new BackPackage();
        int[] w = new int[]{16, 36, 25, 19, 26, 23};
        int[] v = new int[]{619,363, 582, 163, 487, 344};
        int cap = 35;
        int j = backpack.maxValue(cap, w, v);
        System.out.println(j);
    }


    public int maxValue(int capacity,int[] weight,int[] values){
        if (capacity == 0 || weight == null || weight.length == 0 || values == null || values.length == 0 ){
            return 0;
        }
        int[][] dp = new int[weight.length][capacity+1];

        // 初始化行
        for (int i = 0; i < capacity + 1; i++) {
            dp[0][i] = i<weight[0]?0:values[0];
        }

        //开始循环每个物品
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < capacity+1; j++) {
                if (j < weight[i]){
                    dp[i][j] =  dp[i-1][j];
                }else {
                    dp[i][j] = Integer.max(dp[i-1][j],dp[i-1][j-weight[i]]+values[i]);
                }
            }
        }

        return dp[weight.length-1][capacity];

    }

}
