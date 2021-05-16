package com.dynamic;

/**
 * 给定数组arr,arr中所有的值都为正数且不重复每个值代表一种面值的货币,
 * 每种面值的货币可以使用任意张,再给定一个整数aim代表要找的钱数,求换钱有多少种方法。
 */
public class Cost {
    public static void main(String[] args) {
        int[] arr  = new int[]{1,5,10,20};
        // 1. 暴力递归法
        Cost cost = new Cost();
        System.out.println(cost.coins1(arr,1000));
    }

    public int coins1(int[] arr,int aim){
        if (arr == null || aim == 0 || arr.length == 0){
            return 0;
        }
        return process1(arr,0,aim);
    }

    /**
     * 暴力递归
     * 1.使用arr 中的下标为1 的面值，分别为0 ，1 ， 2 ，3 ···N张，递归 下标为2的面值 分别为0 ····N 张
     * @return
     */
    public int process1(int[] arr,int index,int aim){
        int res = 0;
        if (arr.length-1 < index){
            res =  aim==0?1:0;
        }else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr,index+1,aim -  arr[index] * i);
            }
        }
        return res;
    }
}
