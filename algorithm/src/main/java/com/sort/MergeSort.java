package com.sort;

import sun.security.krb5.internal.crypto.KeyUsage;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MergeSort {



    public static void main(String[] args) {
        int[] list =  new int[]{5,3,4,9,2,1,10,7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(list,0,list.length-1);

        System.out.println(Arrays.toString(list));
    }

    public void sort(int[] list,int left,int right){
        if (left == right){
            return;
        }
        int mid = left + ((right - left) >>1);
        sort(list,left,mid);
        sort(list,mid+1,right);
        merge(list,left,right,mid);
    }

    private void merge(int[] list, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right){
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
    }
}
