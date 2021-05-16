package com.dynamic;

/**
 * 给定一个矩阵m,从左上角开始毎次只能向右或者向下走,
 * 最后到达右下角的位置,路径上所有的数字累加起来就是路径和,
 * 返回所有的路径中最小的路径和。如果给定的m如大家看到的样,
 * 路径1,3,1,0,6,1,0是所有路径中路径和最小的,所以返回12
 */
public class MinRoad {
    public static void main(String[] args) {
        int[][] arrint = new int[][]{
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        } ;
        MinRoad minRoad = new MinRoad();
        int[][] dp = minRoad.getDp(arrint);
        System.out.println(minRoad.method1(arrint,0,0));
        System.out.println(dp[arrint.length-1][arrint[0].length-1]);
    }

    /**
     * 暴力递归
     * @return
     */
    public int method1(int[][] arr,int i,int j){
        //递归终止条件
        if (i >= arr.length ||  j >=arr[0].length){
            return 0;
        }
        int result = arr[i][j];
        if (arr.length-1 == i && arr[0].length-1 == j){
            return result;
        }
        int i1 = method1(arr, i + 1, j);
        int j1 = method1(arr, i, j + 1);
        int minRoad = i1>j1?j1:i1;
        return minRoad + result;
    }

    /**
     * 动态规划
     */
    public int[][] getDp(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = arr[0][j] + dp[0][j-1];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = arr[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int result = dp[i-1][j]<dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
                dp[i][j] = result + arr[i][j];
            }
        }
        return dp;
    }

}
