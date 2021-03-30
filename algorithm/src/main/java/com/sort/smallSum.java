package com.sort;

import java.util.Arrays;

public class smallSum {
    public static void main(String[] args) {
        int[] list =  new int[]{5,3,4,9,2,1,10,7};
        smallSum smallSum = new smallSum();
        int sort = smallSum.sort(list, 0, list.length - 1);

        System.out.println(sort);
    }

    public int sort(int[] list,int left,int right){
        if (left == right){
            return 0;
        }
        int mid = left + ((right - left) >>1);
        return sort(list,left,mid)+
        sort(list,mid+1,right)+
        merge(list,left,right,mid);
    }

    private int merge(int[] list, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int result = 0;
        while (i <= mid && j <= right){
            result += list[i] < list[j]? (right-j+1)*list[i]:0;
            temp[k++] = list[i] <= list[j]?list[i++]:list[j++];
        }
        while (i <= mid){
            temp[k++] = list[i++];
        }
        while (j <= right){
            temp[k++] = list[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            list[left ++] = temp[l];
        }
        return result;
    }
}
